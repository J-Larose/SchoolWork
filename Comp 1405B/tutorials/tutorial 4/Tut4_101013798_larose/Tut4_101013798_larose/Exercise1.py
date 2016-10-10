def resetIndex(start, index, value):
    index = start
    value = 1
    return index, value

def decreaseIndex(index):
    index = index - 1
    return index

def doubleValue(value):
    value = value * 2  
    return value

def testIndexZero(index):
	return (index == 0)

def printValue(value):
	print("The value is", value)


def mainProgram():
    index = 0
    value = 0
    hasQuit = False
    while (not(hasQuit)):
        choice = int(input("Please enter a positive number (or zero to quit): "))
        if choice == 0:
            hasQuit = True
        elif choice > 0:
            index, value = resetIndex(choice, index, value)
            while (not (testIndexZero(index))):
                value = doubleValue(value)
                index = decreaseIndex(index)
            printValue(value)

# this line starts the main program, located in the function "main"
mainProgram()