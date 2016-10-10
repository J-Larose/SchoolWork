#Collier, R. "Lectures Notes for COMP1405B ? Introduction to Computer Science I" [PDF document]. Retrieved
#from cuLearn: https://www.carleton.ca/culearn/ (Fall 2015).

#Stephenson, B. "Part 2 of Ben Stephenson's SimpleGraphics Tutorial" [PDF document]. Retrieved
#from cuLearn: https://www.carleton.ca/culearn/ (Fall 2015).


from SimpleGraphics import *

def TakeInput():

    #take str for name of background and forground imgs
    while True:
        try:
            bg = loadImage(input("What is the background image name: "))
            fg = loadImage(input("What is the forground image name: "))
            break
        except:
            print("ERR: Something has gone wrong (That might not be a valid file name)")
    
    #take input for x and y values
    while True:
        try:
            x = int(input("x value:"))
            y = int(input("y value:"))

            
            #check if this point is valid (entire image fits on canvas)
            if (x-getWidth(fg)/2)>0 and (x+getWidth(fg)/2)<800  and (y-getHeight(fg)/2)>0 and (y+getHeight(fg)/2)<600:
                x = int(x-getWidth(fg)/2)
                y = int(y-getHeight(fg)/2)
                break
            else:
                print("The picture won't fit, please choose a more centered point")
        except ValueError:
            print("must be int")

    return bg, fg, x, y

def ChromaKey(fg, bg, xIn, yIn):
    ckImg = createImage(getWidth(fg), getHeight(fg))
    #loop through fg
    for x in range(0, getWidth(fg)):
        for y in range(0, getHeight(fg)):
            #take rgb of fg and equivilant bg based on user input
            r, g, b = getPixel(fg, x, y)
            r2, g2, b2 = getPixel(bg, x+xIn, y+yIn)
            if r<10 and g>245 and b<10:
                #if pixel in fg is "green", replace with bg in newImg1
                putPixel(ckImg, x, y, r2, g2, b2)
            else:
                #if not green replace with avg of both pixels
                putPixel(ckImg, x, y, (r+r2)/2, (g+g2)/2, (b+b2)/2)
    return ckImg

def CreateFinal(ckImg, bg, xIn, yIn):
    finalImg = createImage(getWidth(bg), getHeight(bg))
    #loop through whole image
    for x in range(0, getWidth(bg)):
        for y in range(0, getHeight(bg)):
            #if x and y are within the image space of the chromakeyed fg img, put pixel from chroma keyed img
            if x>xIn and x<xIn+getWidth(ckImg)  and  y>yIn and y<yIn+getHeight(ckImg):
                r, g, b = getPixel(ckImg, x-xIn, y-yIn)
                putPixel(finalImg, x, y, r, g, b)
            #if not in image space of the chromakeyed fg img, put original bg img pixel in final
            else:
                r, g, b = getPixel(bg, x, y)
                putPixel(finalImg, x, y, r, g, b)
    return finalImg


def Main():
    bg, fg, xIn, yIn = TakeInput()
    ckImg = ChromaKey(fg, bg, xIn, yIn)
    finalImg = CreateFinal(ckImg, bg, xIn, yIn)
    drawImage(finalImg, 0, 0)



Main()