def write_land_info(land_info):
    with open("land_info.txt", 'w') as file: #open in write mode
        for land in land_info:
            file.write(', '.join(land) + '\n')#join elements with commas
