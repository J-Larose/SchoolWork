from SimpleGraphics import *

def takeInput(prompt):
    while True:
        value = str(input(prompt))
        if (value=="true"):
            return True
            break
        elif (value=="false"):
            return False
            break
        else:
            print("Please Enter True or False")

def evaluateMyCircuit(a, b, c, d, e, f, g, h, i, z):
    if b and c:
        f = True
    if d and e:
        g = True

    if f and g:
        h = True
    if not a:
        i = True

    if i or h:
        z = True

    return a, b, c, d, e, f, g, h, i, z

    print("Final is :", z)
 
def drawCurcuit(a, b, c, d, e, f, g, h, i, z):
    y = 0
    for x in [a, b, c, d, e, f, g, h, i, z]:
        if x:
            setFill("green")
        else:
            setFill("red")
        ellipse(0, 120*y, 50, 50)
        line(50, 120*y+25, 100, 120*y+25)
        y = y+1
    line(100, 25, 200, 25)

    if f:
        setFill("green")
    else:
        setFill("red")
    line(150, 205, 200, 205)
    blob(100, 145, 100, 145, 175, 205, 100, 265, 100, 265)

    if g:
        setFill("green")
    else:
        setFill("red")
    line(150, 445, 200, 445)
    blob(100, 385, 100, 385, 175, 445, 100, 505, 100, 505)

    line(200, 205, 200, 265)
    line(200, 445, 200, 385)

    if g:
        setFill("green")
    else:
        setFill("red")
    line(250, 325, 300, 325)
    blob(200, 265, 200, 265, 275, 325, 200, 385, 200, 385)

    if i:
        setFill("green")
    else:
        setFill("red")
    line(250, 25, 300, 25)
    polygon(200, 0, 200, 50, 250, 25)
    
    line(300, 25, 300, 145)
    line(300, 325, 300, 265)

    if z:
        setFill("green")
    else:
        setFill("red")
    line(250, 325, 300, 325)
    blob(300, 145, 300, 145, 375, 205, 300, 265, 300, 265, 325, 205)

    line(350, 205, 400, 205)
    ellipse(400, 180, 50, 50)

print("101013798")

a = takeInput("What is value A (in lowercase): ")
b = takeInput("What is value B (in lowercase): ")
c = takeInput("What is value C (in lowercase): ")
d = takeInput("What is value D (in lowercase): ")
e = takeInput("What is value E (in lowercase): ")
f = False
g = False
h = False
i = False
z = False

a, b, c, d, e, f, g, h, i, z = evaluateMyCircuit(a, b, c, d, e, f, g, h, i, z)
drawCurcuit(a, b, c, d, e, f, g, h, i, z)

