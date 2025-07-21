def read_land_info():
    land_info = []
    with open("land_info.txt", 'r') as file: #open file in read mode
        for line in file:
            land_info.append(line.strip().split(', '))
    return land_info



