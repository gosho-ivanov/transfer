import json
from star_wars_simulator import ShipFactory, Alliance, SHIP_REGISTRY

STATE_FILE = "fleet_state.json"

# =========================
# Persistence
# =========================

def load_state():
    try:
        with open(STATE_FILE, "r") as f:
            return json.load(f)
    except FileNotFoundError:
        return {}
    except json.JSONDecodeError:
        print("⚠️ Error reading file. Starting with an empty fleet.")
        return {}


def save_state(state):
    try:
        with open(STATE_FILE, "w") as f:
            json.dump(state, f, indent=2)
    except IOError:
        print("⚠️ Error writing to file")

# =========================
# Menu Actions
# =========================

def add_ship(state):
    try:
        print("Available ship types:")
        for s in SHIP_REGISTRY:
            print(f"- {s}")

        ship_type = input("Enter ship type: ").strip().upper()
        name = input("Enter ship name: ").strip()

        ship = ShipFactory.create(ship_type, name)
        state[name] = {
            "type": ship_type,
            "alliance": ship.alliance.value,
        }
        save_state(state)
        print("✅ Ship added successfully")

    except KeyError:
        print("❌ Invalid ship type")
    except Exception as e:
        print(f"❌ An error occurred: {e}")


def delete_ship(state):
    try:
        name = input("Enter ship name to delete: ").strip()
        if name not in state:
            raise ValueError("Ship does not exist")
        del state[name]
        save_state(state)
        print("🗑️ Ship deleted")
    except ValueError as e:
        print(f"❌ {e}")


def list_ships(state):
    if not state:
        print("No ships available")
        return

    print("📋 Ship list:")
    for name, data in state.items():
        print(f"- {name} [{data['alliance']}] ({data['type']})")


def battle_ships(state):
    from star_wars_simulator import Battle

    if len(state) < 2:
        print("❌ At least 2 ships are required for a battle")
        return

    print("Available ships:")
    for name, data in state.items():
        print(f"- {name} [{data['alliance']}] ({data['type']})")

    try:
        names = input("Enter ship names for battle (comma-separated): ")
        selected = [n.strip() for n in names.split(",") if n.strip()]

        if len(selected) < 2:
            raise ValueError("You must select at least 2 ships")

        ships = []
        for name in selected:
            if name not in state:
                raise ValueError(f"Ship '{name}' does not exist")
            data = state[name]
            ships.append(ShipFactory.create(data["type"], name))

        rebels = [s for s in ships if s.alliance == Alliance.REBELS]
        empire = [s for s in ships if s.alliance == Alliance.EMPIRE]

        if not rebels or not empire:
            raise ValueError("Both Rebels and Empire ships are required")

        battle = Battle(ships)
        battle.run()

    except ValueError as e:
        print(f"❌ {e}")

# =========================
# Main Menu
# =========================

def main():
    state = load_state()

    while True:
        print("\n=== STAR WARS MENU ===")
        print("1. Add ship")
        print("2. Delete ship")
        print("3. Show all ships")
        print("4. Battle ships")
        print("5. Exit")

        try:
            choice = int(input("Choose an option: "))

            if choice == 1:
                add_ship(state)
            elif choice == 2:
                delete_ship(state)
            elif choice == 3:
                list_ships(state)
            elif choice == 4:
                battle_ships(state)
            elif choice == 5:
                print("👋 Exiting program")
                break
            else:
                print("❌ Invalid choice")

        except ValueError:
            print("❌ Please enter a number")


if __name__ == "__main__":
    main()
