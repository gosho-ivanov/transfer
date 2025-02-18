from itertools import product
import random

A ={7, 8, 9, 10, "A", "J", "Q", "K"}
B = {"\u2663", "\u2660", "\u2665", "\u2666"}
deck = (list(product(A, B)))
random.shuffle(deck)

p1 = deck[:8]
p2 = deck[8:16]
p3 = deck[16:24]
p4 = deck[24:]
players = [p1, p2, p3, p4]
player_names = ['player 1', "player 2", "player 3", "player 4"]

announcements = {name : "" for name in player_names}

def has_belot(hand):
    suits = {}

    for card in hand:
        rank, suit = card

        if suit not in suits:
            suits[suit] = []
        suits[suit].append(rank)

    for suit, ranks in suits.items():
        if "Q" in ranks and "K" in ranks:
            return True
        
    return False

def has_terca(hand):
    return has_consecutive(hand, 3)

def has_quarta(hand):
    return has_consecutive(hand, 4)

def has_quinte(hand):
    return has_consecutive(hand, 5)

def has_consecutive(hand, length):
    suits = {}

    for card in hand:
        rank, suit = card
        if suit not in suits:
            suits[suit] = []
        suits[suit].append(rank)

    for suit, ranks in suits.items():
        rank_order = ['7', '8', '9', '10', 'A', 'J', 'Q', 'K']
        for rank in ranks:
            if rank in rank_order:
                rank_indices = [rank_order.index(rank)]
        rank_indices.sort()

        for i in range(len(rank_indices) - length + 1):
            for j in range(length):
                if all(rank_indices[j] == rank_indices[i] + j):
                    return True
    return False

def has_kare(hand):
    rank_count = {}
    for card in hand:
        rank, suit = card
        if rank not in ['7', '8']:
            if rank not in rank_count:
                rank_count[rank] = 0
            rank_count[rank] += 1
    return any(count == 4 for count in rank_count.values())

def calculate_announcements(players):
    for i, hand in enumerate(players):
        player_name = player_names[i]

        if has_kare(hand):
            announcements[player_name] = 'Каре'
        elif has_quinte(hand):
            announcements[player_name] = 'Квинта'
        elif has_quarta(hand):
            announcements[player_name] = 'Кварта'
        elif has_terca(hand):
            announcements[player_name] = 'Терца'
        elif has_belot(hand):
            announcements[player_name] = 'Белот'

        if announcements[player_name] == "":
            announcements[player_name] = 'Няма анонс'


calculate_announcements(players)

for name, hand in zip(player_names, players):
    print(f"{name}: {hand} -> Анонси: {announcements[name]}")