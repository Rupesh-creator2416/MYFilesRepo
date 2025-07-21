import datetime
from read import read_land_info
from write import write_land_info



def rent_land():
    try:
        customer_name = input("Enter your name: ")
        rent_duration = int(input("Enter the duration of rent (in months): "))
        total_rent_amount = 0
        
        land_info = read_land_info()
        rented_lands = [] #create empty list
        
        while True:
            kitta_number = input("Enter Kitta Number of the land you want to rent (or type 'done' to finish): ")
            if kitta_number.lower() == 'done':
                break
            anna_demand = int(input("Enter the number of annas you want to rent: "))
            
            found = False
            for land in land_info:
                if land[0] == kitta_number and land[5] == 'Available':
                    if int(land[3]) != anna_demand:
                        print("Invalid input. you can cannot rent less or more than given anna.")
                        return
                    land[5] = 'Not Available'
                    now = datetime.datetime.now()
                    rent_date = "-".join([str(now.year), str(now.month), str(now.day), str(now.hour), str(now.minute), str(now.second), str(now.microsecond)])
                    rent_amount = int(land[4]) * rent_duration
                    total_rent_amount += rent_amount
                    rented_lands.append(land)
                    print("Land with Kitta Number", kitta_number, "rented successfully. Rent amount: Rs.", rent_amount)
                    found = True
                    break
            if not found:
                print("Land with Kitta Number", kitta_number, "not available for rent.")
        #create rent invoice
        if rented_lands:
            note = "Rent Details for " + customer_name + ":\n"
            for land in rented_lands:
                note += "Kitta Number: " + land[0] + "\nCity/District: " + land[1] + "\nLand Faced: " + land[2] + "\nArea: " + land[3] + " annas\n"
            note += "Customer Name: " + customer_name + "\nRent Date: " + rent_date + "\nRent Duration: " + str(rent_duration) + " months\nTotal Amount: Rs. " + str(total_rent_amount) + "\n"
            
            with open("Rent_Invoice_" + customer_name + ".txt", 'w') as invoice_file:
                invoice_file.write(note)
                print("Invoice generated successfully for", customer_name, ". Total rent amount: Rs.", total_rent_amount)
            
            write_land_info(land_info)
        else:
            print("No lands rented.")
    
    except ValueError:  #handling error
        print("Error: Invalid input. Please enter a valid number.")

def return_land():
    try:
        kitta_number = input("Enter Kitta Number of the land you are returning: ")
        customer_name = input("Enter your name: ")
        now = datetime.datetime.now()
        return_date = "-".join([str(now.year), str(now.month), str(now.day), str(now.hour), str(now.minute), str(now.second), str(now.microsecond)])
        rent_duration = int(input("Enter the duration of rent (in months): "))
        
        land_info = read_land_info()
        for land in land_info:
            if land[0] == kitta_number and land[5] == 'Not Available':
                land[5] = 'Available'
                rent_amount = int(land[4]) * rent_duration
                return_amount = rent_amount
                
                # Calculate fine for overdue months
                overdue_months = rent_duration - 12 if rent_duration > 12 else 0
                fine_rate = 10000  # Fine rate per month
                fine = fine_rate * overdue_months
                return_amount += fine  # Add fine to return amount
                
                # Create fine invoice
                if fine > 0:
                    fine_note = "Fine Applied:\nKitta Number: " + land[0] + "\nCity/District: " + land[1] + "\nLand Faced: " + land[2] + "\nFine Rate: Rs. " + str(fine_rate) + "/month\nOverdue Months: " + str(overdue_months) + "\nFine Amount: Rs. " + str(fine) + "\n"
                    with open("Fine_Invoice_" + kitta_number + ".txt", 'w') as invoice_file:
                        invoice_file.write(fine_note)
                
                # Create return invoice
                return_note = "Return Details:\nCustomer Name: " + customer_name + "\nKitta Number: " + land[0] + "\nCity/District: " + land[1] + "\nLand Faced: " + land[2] + "\nReturn Date: " + return_date + "\nRent Duration: " + str(rent_duration) + " months\nArea: " + land[3] + "\nTotal Amount: Rs. " + str(return_amount) + "\nFine Amount: Rs. " + str(fine) + "\n"
                with open("Return_Invoice_" + land[0] + ".txt", 'w') as invoice_file:
                    invoice_file.write(return_note)
                
                print("Land returned successfully. Total Amount: Rs. " + str(return_amount) + ".")
                write_land_info(land_info)
                return
        
        print("Land was not rented or kitta number does not exist.")
    
    except ValueError:
        print("Error: Invalid input. Please enter a valid number.")



