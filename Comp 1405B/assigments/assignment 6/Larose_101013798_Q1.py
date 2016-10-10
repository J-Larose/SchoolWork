from SimpleGraphics import *
import sys

class Entry:
    def __init__(self, id, name, faculty, photo):
        self.__id = id
        self.__name = name
        self.__faculty = faculty
        self.__photo = photo
    def getId(self):
        return self.__id
    def getName(self):
        return self.__name
    def getFaculty(self):
        return self.__faculty
    def getPhoto(self):
        return self.__photo

def takeInput(database):
    while True:
        try:
            id = int(input("Enter ID: "))
            if id in database:
                raise Exception
            else:
                break
        except ValueError:
            print("That is not a number")
        except Exception:
            print("that is already used")

    while True:
        try:
            img = loadImage(input("What is the image file name: "))
            drawImage(img, 0, 0)
            break
        except:
            e = sys.exc_info()[0]
            print("ERR:", e)
            print("ERR: Something has gone wrong (That might not be a valid file name)")

    return id, img



def main():
    database = {}
    while True:
        operation = input("would you like to 1) update 2) delete 3) view or 4) quit? ")
        if operation == "update":
            id, img = takeInput(database)
            student = Entry(id, input("Enter name: "), input("Enter faculty: "), img) 

            database.update({id: student})
        elif operation == "delete":
            while True:
                try:
                    key = int(input("What is the ID of the record to delete? "))
                    del database[key]
                    break
                except ValueError:
                    print("IDs are all ints.")
                except KeyError:
                    print("That ID does not exist.")
        elif operation == "view":
            while True:
                try:
                    key = int(input("What is the ID of the record to view? "))
                    if key in database:
                        record = database.get(key)
                        print("Name:"+ record.getName())
                        print("ID:"+ str(record.getId()))
                        print("Faculty:"+ record.getFaculty())
                        img = record.getPhoto()
                        drawImage(img, 0, 0)
                        break
                    else:
                        print("that ID does not exist.")
                except ValueError:
                    print("ERR: keys must be ints")
        elif operation == "quit":
            break
        else:
            print("ERR: the options are update, delete, view or quit")


main()