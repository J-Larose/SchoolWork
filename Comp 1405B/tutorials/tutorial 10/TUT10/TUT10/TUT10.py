from Pet import *

pet = Pet(input("Name:"), input("type"), int(input("age")))


while True:
    pet.growOlder()
    while True:
        try:
            pet.addToBill(int(input("how much was spent this year? ")))
            print(Pet.getBill(pet))
            break
        except:
            print("err")

    quit = input("would you like to quit? y/n ")
    if quit == "y":
        break
