g_value = 0
g_index = 0

def resetIndex(start):
	global g_index, g_value
	g_index = start
	g_value = 1

def decreaseIndex():
	global g_index
	g_index = g_index - 1

def doubleValue():
	global g_value
	g_value = g_value * 2

def testIndexZero():
	return (g_index == 0)

def printValue():
	print("The value is", g_value)


def mainProgram():
	hasQuit = False
	while (not(hasQuit)):
		choice = int(input("Please enter a positive number (or zero to quit): "))
		if choice == 0:
			hasQuit = True
		elif choice > 0:
			resetIndex(choice)
			while (not (testIndexZero())):
				doubleValue()
				decreaseIndex()
			printValue()

# this line starts the main program, located in the function "main"
mainProgram()