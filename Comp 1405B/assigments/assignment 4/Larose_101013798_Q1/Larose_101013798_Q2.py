#Collier, R. "Lectures Notes for COMP1405B ? Introduction to Computer Science I" [PDF document]. Retrieved
#from cuLearn: https://www.carleton.ca/culearn/ (Fall 2015).

#Stephenson, B. "Part 2 of Ben Stephenson's SimpleGraphics Tutorial" [PDF document]. Retrieved
#from cuLearn: https://www.carleton.ca/culearn/ (Fall 2015).

#Python 3.5.0 documentation. (2015-09-29) Retrived from https://docs.python.org/3/

from SimpleGraphics import *

def TakeInput():

    #load img to convert
    while True:
        try:
            img = loadImage(input("What is the image file name: "))
            break
        except:
            print("ERR: Something has gone wrong (That might not be a valid file name)")
    
    return img

def ConvertImg(img, sym):
    asciiImg=[]
    #counter for row and column
    for row in range(0, getHeight(img)):
        asciiImg.append([])
        for c in range(0, getWidth(img)):
            #take rgb of pixel
            r, g, b = getPixel(img, c, row)
            #convert to grayscale
            brightness = (r+g+b)/3
            #assign a char 
            x = 26
            for i in range (0, 11):
                if brightness<x:
                    asciiImg[row].append(sym[i])
                    break
                x += 26

    return asciiImg

def PrintImg(asciiImg):
    for r in asciiImg:
        for c in r:
            print(c, end="")
        print("\n")

def Save(asciiImg, sym):
    while True:
        try:
            fileName = input("What is the filename? ")
            filehndl = open(fileName, "w")
            break
        except:
            e = sys.exc_info()[0]
            print("ERR", e)
    for item in sym:
        filehndl.write(item)
    filehndl.write("\r\n")
    for c in asciiImg:
        for r in c:
            filehndl.write(r)
        filehndl.write("\r\n")
    filehndl.close()

def Main():
    while True:
        bg = input("Q2 What colour is the background? ")
        if bg=="black":
            sym = [" ", ".", "-", ":", ";", "/", "+", "0", "3", "#"]
            break
        elif bg=="white":
            sym = ["#", "3", "0", "+", "/", ";", ":", "-", ".", " "]
            break
        else:
            print("ERR: the options are black and white")

    img = TakeInput()
    asciiImg = ConvertImg(img, sym)
    PrintImg(asciiImg)
    Save(asciiImg, sym)

Main()