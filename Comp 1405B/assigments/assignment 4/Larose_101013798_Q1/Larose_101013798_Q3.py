#Collier, R. "Lectures Notes for COMP1405B ? Introduction to Computer Science I" [PDF document]. Retrieved
#from cuLearn: https://www.carleton.ca/culearn/ (Fall 2015).

#Python 3.5.0 documentation. (2015-09-29) Retrived from https://docs.python.org/3/

import sys
import copy

def ImportTxtFile():
    asciiImg = []
    #take str for name of save file
    while True:
        fileName = input("What is the ascii file name: ")
        try:
            #add each line of txt file to list as list
            with open(fileName, "r") as file:
                for txtLine in file:
                    txtLine = list(txtLine) 
                    asciiImg.append(txtLine)
            break
        except IOError:
            print("ERR: Something has gone wrong (That might not be a valid file name)")
        except:
            e = sys.exc_info()[0]
            print("ERR", e)

    #remove all newline chars
    while ["\n"] in asciiImg:
        asciiImg.remove(["\n"])

    for row in asciiImg:
        while "\n" in row:
            row.remove("\n")
    return asciiImg, fileName

def PrintImg(asciiImg):
    for c in asciiImg:
        for r in c:
            print(r, end="")
        print("\n")

def Flip(asciiImg):
    #take input for axis of symetry
    while True:
        axis = input("Which axis would you like to flip on (hor/vir)? ")
        if axis == "vir":
            #reverse the rows
            for row in asciiImg:
                row.reverse()
            break
        elif axis == "hor":
            #reverse the columns
            asciiImg.reverse()
            break
        else:
            print("please enter vir or hor")
    return asciiImg

def Rotate(asciiImg):
    asciiImgRotated = []
    #flip img on horizontal axis
    asciiImg.reverse()
    #flip along diagonal axis
    for indx in range(0, len(asciiImg[0])):
        asciiImgRotated.append([])
        for row in asciiImg:
            asciiImgRotated[indx].append(row[indx])

    return asciiImgRotated

def Invert(asciiImg, sym):
    #take deep copy of sym list
    try:
        symInverted = copy.deepcopy(sym)
    except:
        e = sys.exc_info()[0]
        print("ERR", e)
    #take reverse of sym list
    symInverted.reverse()
    asciiImgInverted = []
    #switch original symbols with the oposite
    x = 0
    for row in asciiImg:
        asciiImgInverted.append([])
        for item in row:
            for symbol in sym:
                if symbol==item:
                    indx=sym.index(symbol)
                    asciiImgInverted[x].append(symInverted[indx])
                    break
        x += 1
    return asciiImgInverted

def Save(asciiImg, fileName, sym):
    #open file
    while True:
        try:
            filehndl = open(fileName, "w")
            break
        except:
            e = sys.exc_info()[0]
            print("ERR", e)
    #write the file
    for item in sym:
        filehndl.write(item)
    filehndl.write("\r\n")
    for c in asciiImg:
        for r in c:
            filehndl.write(r)
        filehndl.write("\r\n")
    #close the file
    filehndl.close()

def Main():
    #take inputs
    asciiImg, fileName = ImportTxtFile()
    #populate sym list based on bg colour
    while True:
        try:
            bg = input("What colour is the background? ")
    
            if bg=="black":
                sym = asciiImg.pop(0)
                break
            elif bg=="white":
                sym = asciiImg.pop(0)
                sym.reverse()
                break
            else:
                print("ERR: the options are black and white")
        except:
            e = sys.exc_info()[0]
            print("ERR", e)
    #take input and run function for 3 operations
    while True:
        while True:
            option = input("Would you like to 'flip', 'rotate', or 'invert' the image? ")
            if option=="flip":
                asciiImg = Flip(asciiImg)
                break
            elif option=="rotate":
                asciiImg = Rotate(asciiImg)
                break
            elif option=="invert":
                asciiImg = Invert(asciiImg,sym)
                break
            else:
                print("ERR: options are 'flip', 'rotate', or 'invert' (no quotation marks)")
        #print modified img
        PrintImg(asciiImg)
        tryAgain = input("Would you like to do more? (yes/no)" )
        if tryAgain=="no":
            break
    Save(asciiImg, fileName, sym)



Main()