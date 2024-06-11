playing_field = []
N = int(input())

for _ in range(N):
    row = input().split()
    
    playing_field.append(row)

commands = input().split(", ")
redhood_x = 0
redhood_y = 0
collected_shrooms = 0
not_shrooms = ["W", "H"]
flag = False
wolf_encounter = False

for com in commands:
    if com == "Right":
        redhood_x += 1
        if redhood_x >= len(playing_field):
            redhood_x -= 1
            print("I can't get out of the woods!")
            pass
        
        if playing_field[redhood_y][redhood_x] not in not_shrooms:
            collected_shrooms += int(playing_field[redhood_y][redhood_x])
            playing_field[redhood_y][redhood_x] = "R"
            playing_field[redhood_y][redhood_x-1] = 0
        else:
            if playing_field[redhood_y][redhood_x] == "W":
                print("Oops, I met a Wolf!\nGAME OVER!")
                wolf_encounter = True
                break
            elif playing_field[redhood_y][redhood_x] == "H":
                flag = True
                break

    elif com == "Left":
        redhood_x -= 1
        if redhood_x < 0:
            redhood_x += 1
            print("I can't get out of the woods!")
            pass
    
        if playing_field[redhood_y][redhood_x] not in not_shrooms:
            collected_shrooms += int(playing_field[redhood_y][redhood_x])
            playing_field[redhood_y][redhood_x] = "R"
            playing_field[redhood_y][redhood_x+1] = 0
        else:
            if playing_field[redhood_y][redhood_x] == "W":
                print("Oops, I met a Wolf!\nGAME OVER!")
                wolf_encounter = True
                break
            elif playing_field[redhood_y][redhood_x] == "H":
                flag = True
                break

    elif com == "Up":
        redhood_y -= 1
        if redhood_y < 0:
            redhood_y += 1
            print("I can't get out of the woods!")
            pass

        if playing_field[redhood_y][redhood_x] not in not_shrooms:
            collected_shrooms += int(playing_field[redhood_y][redhood_x])
            playing_field[redhood_y][redhood_x] = "R"
            playing_field[redhood_y+1][redhood_x] = 0
        else:
            if playing_field[redhood_y][redhood_x] == "W":
                print("Oops, I met a Wolf!\nGAME OVER!")
                wolf_encounter = True
                break
            elif playing_field[redhood_y][redhood_x] == "H":
                flag = True
                break

    elif com == "Down":
        redhood_y += 1
        if redhood_y > len(playing_field):
            redhood_y -= 1
            print("I can't get out of the woods!")
            pass
        
        if playing_field[redhood_y][redhood_x] not in not_shrooms:
            collected_shrooms += int(playing_field[redhood_y][redhood_x])
            playing_field[redhood_y][redhood_x] = "R"
            playing_field[redhood_y-1][redhood_x] = 0
        else:
            if playing_field[redhood_y][redhood_x] == "W":
                print("Oops, I met a Wolf!\nGAME OVER!")
                wolf_encounter = True
                break
            elif playing_field[redhood_y][redhood_x] == "H":
                flag = True
                break

if wolf_encounter:pass
else:
    if flag:
        print(f"Grandma, I'm here! I've collected {collected_shrooms} mushrooms on the way!")
    else:
        print("Help, I'm lost!")