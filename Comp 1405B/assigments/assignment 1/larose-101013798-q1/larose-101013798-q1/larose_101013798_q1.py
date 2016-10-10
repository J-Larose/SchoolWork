#Collier, R. "Lectures Notes for COMP1405B – Introduction to Computer Science I" [PDF document]. Retrieved
#from cuLearn: https://www.carleton.ca/culearn/ (Fall 2015).

#Stephenson, B. "Part 1 of Ben Stephenson's SimpleGraphics Tutorial" [PDF document]. Retrieved
#from cuLearn: https://www.carleton.ca/culearn/ (Fall 2015).

from SimpleGraphics import *

#take user input
while True:
    try:
        xInput = int(input("Input X Coordinate Please : "))
        yInput = int(input("Input Y Coordinate Please : "))
        break
    except ValueError:
        print("Value must be a whole number")

#Create head
setColor("yellow")
ellipse(xInput, yInput, 100, 100)

#Create face
#Create eyes component
setColor("white")
ellipse(25+xInput, 25+yInput, 20, 15)
ellipse(75+xInput, 25+yInput, 20, 15)
setColor("blue")
ellipse(33+xInput, 27+yInput, 10, 10)
ellipse(83+xInput, 27+yInput, 10, 10)
#Create mouth component
setColor("firebrick2")
blob(20+xInput, 60+yInput, 60+xInput, 95+yInput, 100+xInput, 60+yInput, 60+xInput, 65+yInput)

#Create body
setColor("purple")
ellipse(xInput, 100+yInput, 100, 100)
rect(xInput, 150+yInput, 100, 175)

#Create legs
setColor("royal blue")
polygon(33+xInput, 325+yInput, 20+xInput, 425+yInput, xInput, 425+yInput, xInput, 435+yInput, 30+xInput, 435+yInput, 43+xInput, 325+yInput)
polygon(67+xInput, 325+yInput, 80+xInput, 425+yInput, 100+xInput, 425+yInput, 100+xInput, 435+yInput, 70+xInput, 435+yInput, 57+xInput, 325+yInput)

#Create arms
setColor("purple")
setWidth(15)
line(95+xInput, 140+yInput, 135+xInput, 300+yInput)
line(5+xInput, 140+yInput, -35+xInput, 300+yInput)
#Create hands component
ellipse(125+xInput, 285+yInput, 20, 20)
ellipse(-40+xInput, 285+yInput, 20, 20)