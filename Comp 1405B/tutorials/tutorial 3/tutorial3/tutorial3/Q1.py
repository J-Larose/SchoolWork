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
while True:
    while True:
        try:
            number = takeInput("please enter a number from 1 to 9", int, ValueError)
            assert(number>=1)
            assert(number<=9)   
            break
        except AssertionError:
            print("it must be 1-9")

    for x in range(1, number+1):
        for y in range(1, x+1):
            print(x, end="")
        print()
    if input("would you like to make annother?(y/n) ")=="y":
        break