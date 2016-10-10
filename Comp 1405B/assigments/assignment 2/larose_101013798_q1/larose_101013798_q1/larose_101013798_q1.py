#Collier, R. "Lectures Notes for COMP1405B – Introduction to Computer Science I" [PDF document]. Retrieved
#from cuLearn: https://www.carleton.ca/culearn/ (Fall 2015).

#Stephenson, B. "Part 1 of Ben Stephenson's SimpleGraphics Tutorial" [PDF document]. Retrieved
#from cuLearn: https://www.carleton.ca/culearn/ (Fall 2015).

#Python 3.5.0 documentation. (2015-09-29) Retrived from https://docs.python.org/3/

#imports and print program title
from SimpleGraphics import *
from random import *
import math

print("===============\n Chart Maker \n===============\n")

##take input and check for given error
# @param prompt the prompt to use in input function
# @param cast the input type being sought
# @param errorType a specific error to be caught by the except statement
def takeInput(prompt, cast, errorType):
    while True:
        try:
            return cast(input(prompt))
            break
        except errorType:
            print("Please enter a valid value")


#take global user definitions for the chart
title = takeInput("What is the title of your chart? ", str, None)
numberOfSectors = takeInput("How many sectors do you want? ", int, ValueError)
totalValue = takeInput("What is the total value of your chart? ", float, ValueError)
while True:
    try:
        legendType = takeInput("Would you like a 1. legend or 2. sector labels?", int, ValueError)
        assert(legendType>=1)
        assert(legendType<=2)
        break
    except AssertionError:
        print("please make a valid choice")

#create pseudo 2d array to hold values of sectors
sectors= []
sectors.append([])
sectors.append([])

#populate sectors lists
for x in range(1, numberOfSectors+1):
    sectors[0].append(takeInput("What is the title of this sector? ", str, None))
    sectors[1].append(takeInput("What is the value of this sector? ", float, ValueError))


#chart repair, convert user inputs to percentage of total input by the user and convert
#them to equal percentages of the total value of the graph, or simply set the total value of the chart
#equal to that of what was imputted
if sum(sectors[1]) != totalValue:
    totalInput=sum(sectors[1])
    while True:
       try:
           repairOption = takeInput("Your declared total value of the chart does not match the total that you inputed. \n would you like to 1. Adjust the input so it matches the declared total or 2. Adjust the the delcared total to match the input values", int, ValueError)
           assert(repairOption>=1)
           assert(repairOption<=2)
           break
       except AssertionError:
           print("please make a valid choice")
    if repairOption==1:
        for i in range (0, numberOfSectors):
            sectors[1][i] = (sectors[1][i]/totalInput)*totalValue
    elif repairOption==2:
        totalValue=totalInput


#print title on canvas
setFont("Times", "28")
text(400, 50, title)

#create pie slices
startOfSlice = 0

for x in range(0, numberOfSectors):
    #choose one of 6 colours
    if x==0:
        setFill("red")
    elif x==1:
        setFill("orange")
    elif x==2:
        setFill("yellow")
    elif x==3:
        setFill("green")
    elif x==4:
        setFill("blue")
    elif x==5:
        setFill("indigo")
    else:
        setFill(randint[0, 255], randint[0, 255], randint[0, 255])
    #create pieslices
    degrees = float((sectors[1][x]/totalValue)*360)
    pieSlice(250, 100, 300, 300, startOfSlice, degrees)
    
    #create legends
    if legendType==2:
        #creates line pointing from sector to label text
        print("x",400 + 150 * math.cos(math.radians(startOfSlice)))
        print("y", 250 + 150 * math.sin(math.radians(startOfSlice)))
        if startOfSlice<90 or startOfSlice>=270:
            line(400 + 150 * math.cos(math.radians(startOfSlice+10)), 250 + 150 * math.sin(math.radians(startOfSlice+10)), 560, 250 + 150 * math.sin(math.radians(startOfSlice+10)))
            text(560, 250 + 150 * math.sin(math.radians(startOfSlice+10)), sectors[0][x], "w")
        else:
            line(400 + 150 * math.cos(math.radians(startOfSlice+10)), 250 + 150 * math.sin(math.radians(startOfSlice+10)), 240, 250 + 150 * math.sin(math.radians(startOfSlice+10)))
            text(240, 250 + 150 * math.sin(math.radians(startOfSlice+10)), sectors[0][x], "e")
    elif legendType==1:
        #create virticle legend on left side of screen
        rect(10, 50*x+50, 15, 15)
        setFont("Times", "15")
        text(30, 50*x+50, sectors[0][x], "nw")
    startOfSlice = startOfSlice+degrees