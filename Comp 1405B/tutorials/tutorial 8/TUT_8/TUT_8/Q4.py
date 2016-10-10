import Q1
import sys

def ImportTxtFile():
    list = []
    #take str for name of save file
    while True:
        fileName = input("What is the file name: ")
        try:
            #add each line of txt file to list as list
            with open(fileName, "r") as file:
                for txtLine in file:
                    if "," in txtLine:
                        list = txtLine.split(",")
                    else:
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
    return list, filename

def Save(filename, list):
    filename = filename.strip(".", 1)
    fileName = filename[0]+"_sorted"+filename[1]
    #get str for name of save file
    while True:
        try:
            #add each line of txt file to list as list
            with open(fileName, "w") as file:
                for item in list:
                    file.write(item)

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
list, filename = ImportTxtFile()
list = Q1.InsertSort(list)
Save(filename, list)
