from operation import rent_land, return_land
def display():

    with open("land_info.txt", 'r') as file:
         lines = file.readlines()#reading each lines
         data = []
         for line in lines:
             parts = line.strip().split(',')
             data.append(parts)#adding to data
         print("Kitta No.   Location    Direction   Anna       Price      Availability")
         print("-" * 70)


         for item in data:
             print(
                 item[0], " " * (8 - len(str(item[0]))),
                 item[1], " " * (12 - len(item[1])),
                 item[2], " " * (10 - len(item[2])),
                 item[3], " " * (8 - len(str(item[3]))),
                 item[4], " " * (9 - len(str(item[4]))),
                 item[5], " " * (14 - len(item[5]))
            )
                    

def main():
    print(" \t\t\t\t* *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ")
    print(" \t\t\t\t* \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t     *")
    print(" \t\t\t\t* " + "\t\t\t  WELCOME TO TECHNO PROPERTY NEPAL" +"\t\t     *")
    print(" \t\t\t\t* " + "\t\t\t Bagbazzar, Kathmandu | 98********" +"\t\t     *")
    print(" \t\t\t\t* \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t     *")
    print(" \t\t\t\t* *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * \n\n")
    print(" \t\t------------------------------------------------------------------------------------------------------------")
    print("\t\t We are here to provide land on rent inside the country. If you are interested then choose the option below.")
    print(" \t\t------------------------------------------------------------------------------------------------------------\n")


    while True:
        print("\n1. Enter 1 to Rent Land\n2. Enter 2 toReturn Land\n3. Enter 3 to Exit")
        choice = input("Enter your choice: ")

        if choice == '1':
            display()
            rent_land()
        elif choice == '2':
            display()
            return_land()
        elif choice == '3':
            print("Thank You For Visiting Us!!")
            break
        else:
            print("Invalid choice. Please enter a valid option.")

if __name__ == "__main__":
    main()
