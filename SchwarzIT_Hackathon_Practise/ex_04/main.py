def quick_lsb_decode(image_path):
    """Най-простия LSB декодер"""
    img = Image.open(image_path)
    width, height = img.size

    binary = ''
    for y in range(height):
        for x in range(width):
            pixel = img.getpixel((x, y))
            if isinstance(pixel, int):  # Grayscale
                binary += str(pixel & 1)
            else:  # RGB
                for value in pixel[:3]:  # R, G, B
                    binary += str(value & 1)


    text = ''
    for i in range(0, len(binary)-7, 8):
        text += chr(int(binary[i:i+8], 2))


    import re
    flags = re.findall(r'flag{[^}]+}|FLAG{[^}]+}|ctf{[^}]+}|CTF{[^}]+}', text)

    return flags[0] if flags else text[:200]

