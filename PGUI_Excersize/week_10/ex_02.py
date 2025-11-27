def getLinesFromFile(filename):
    lines = []
    try:
        with open(filename, "r") as file:
            lines = file.readlines()
    except FileNotFoundError:
        print(f"Error: The file '{filename}' was not found.")
    except IOError:
        print(f"Error: An I/O error occurred while trying to read the file '{filename}'.")
    return lines