def area_square(side: float):
    return side ** 2

def area_right_rectangle(length: float, width: float):
    return length * width

def area_triangle(base: float, height: float):
    return 0.5 * base * height

def are_rectangle(length: float,  width: float):
    return length * width

def area_diamond(diagonal1: float, diagonal2: float):
    return 0.5 * diagonal1 * diagonal2

def area_parallelogram(base: float, height: float):
    return base * height

def find_area(shape: str, dimension1: float, dimension2: float = 0) -> float:
    shape = shape.lower()
    if shape == "square":
        return area_square(dimension1)
    elif shape == "right_rectangle":
        return area_right_rectangle(dimension1, dimension2)
    elif shape == "triangle":
        return area_triangle(dimension1, dimension2)
    elif shape == "rectangle":
        return are_rectangle(dimension1, dimension2)
    elif shape == "diamond":
        return area_diamond(dimension1, dimension2)
    elif shape == "parallelogram":
        return area_parallelogram(dimension1, dimension2)
    else:
        raise ValueError("Invalid shape type. Please use one of the following: square, right_rectangle, triangle, rectangle, diamond, parallelogram.")