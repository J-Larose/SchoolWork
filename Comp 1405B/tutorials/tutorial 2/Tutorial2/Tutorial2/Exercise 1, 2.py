
#define input function with error checking
def takeInput(prompt, cast, errorType):
    while True:
        try:
            return cast(input(prompt))
            break
        except errorType:
            print("Please enter a valid value")

#take various inputs using takeInput function
name = takeInput("What is your name? ", str, None)
studentNumber = takeInput("What is your student number? ", int, ValueError)

percentage = takeInput("What is the percentage grade recieved? ", int, ValueError)

#output grade based on input percentage
if percentage>=80:
    print ("You have recived a A rage")
    if percentage>=90:
        print   ("You have recived an A+")
    elif percentage>=85:
        print   ("You have recived an A")
    elif percentage>=80:
        print   ("You have recived an A-")
elif percentage>= 70:
    print("You have recived a B rage")
    if percentage>=77:
        print   ("You have recived a B+")
    elif percentage>=73:
        print   ("You have recived a B")
    elif percentage>=70:
        print("You have recived a B-")
elif percentage>=60:
    print("You have recived a C rage")
    if percentage>=67:
        print   ("You have recived a C+")
    elif percentage>=63:
        print   ("You have recived a C")
    elif percentage>=60:
        print   ("You have recived a C-")
elif percentage>=50:
    print("You have recived a D rage")
    if percentage>=57:
        print   ("You have recived a D+")
    elif percentage>=53:
        print   ("You have recived a D")
    elif percentage>=50:
        print("You have recived a D-")   
else:
    print("You have recived an F")