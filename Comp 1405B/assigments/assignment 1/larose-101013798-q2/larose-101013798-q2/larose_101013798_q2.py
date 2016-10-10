#Collier, R. "Lectures Notes for COMP1405B – Introduction to Computer Science I" [PDF document]. Retrieved
#from cuLearn: https://www.carleton.ca/culearn/ (Fall 2015).

#charecter selection
print("Welcome to the trail! What are you?")
print("1. A banker from Boston?")
print("2. A carpenter from Ohio?")
print("3. A farmer from Illinois")

while True:
    try:
        choice = int(input("Enter the number beside your choice: "))
        if (choice>=1 & choice<=3):
            break
        else:
            print("Please make a valid choice")
    except ValueError:
        print("Please make a valid choice")

#declaration of money in purse based on charecters
if (choice==1):
    purse=1600.00
    choice=None
elif (choice==2):
    purse=1200.00
    choice=None
elif (choice==3):
    purse=800.00
    choice=None

#initialse store
totalBill = float(0.00)

def store (totalBill):
    print()
    print("Next up you have to buy some suplies! You start with $", purse, "to spend")
    print("1. Oxen for $40.00 a yoke")
    print("2. Food for $0.20 a pound")
    print("3. Clothing for $10.00 a set")
    print("4. Amunition for $2.00 a box")
    print("5. And spare parts for your wagon for $10.00 each")

    #recieve input and declare prices
    while True:
        try:
            choice = int(input("What would you like to buy? "))
            if (choice==1):
                price = 40.00
                break
            elif (choice==2):
                price = 00.20
                break
            elif (choice==3):
                price = 10.00
                break
            elif (choice==4):
                price = 2.00
                break
            elif (choice==5):
                price = 10.00
                break
            else:
                print("Please make a valid choice")

        except ValueError:
            print("Please make a valid choice")
    
    try:
        amout = int(input("How many would you like to buy? "))
    except ValueError:
        print("Please enter a whole number")

    #calculate purchase and total bills, calculate if its affordable
    purchase = price*amout
    print("Purchase: $", format(purchase, '.2f'))

    if((totalBill+purchase)>purse):
        print("you can't afford that!")
    else:
        totalBill = totalBill + purchase

    print("Total Bill:", format(totalBill, '.2f'))
    purseAfterPurchase = purse - totalBill
    print("you have", formate(purseAfterPurchase, '.2f'), "left to spend")

    #recieve input to continue or quit the store function
    while True:
        buyMore= input("Would you like to buy more?(Y/N) ")
        if (buyMore=="Y" or buyMore=="y"):
            store(totalBill)
            break
        elif (buyMore=="N" or buyMore=="n"):
            break
        else:
            print("Enter a valid option")

#inital store function
store (totalBill)

#terminate program
print("Thank you for coming to the Store!")