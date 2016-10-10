import Q1
import sys

def ImportTxtFile():
    list = []
    #take str for name of save file
    while True:
        fileName = input("What is the ascii file name: ")
        try:
            #add each line of txt file to list as list
            with open(fileName, "r") as file:
                for txtLine in file:
                    list.append(txtLine)
            break
        except IOError:
            print("ERR: Something has gone wrong (That might not be a valid file name)")
        except:
            e = sys.exc_info()[0]
            print("ERR", e)

    #remove all newline chars
    for row in list:
        while "\n" in row:
            row.remove("\n")
    return list

list = ImportTxtFile()
list = Q1.InsertSort(list)
