#Collier, R. "Lectures Notes for COMP1405B � Introduction to Computer Science I" [PDF document]. Retrieved
#from cuLearn: https://www.carleton.ca/culearn/ (Fall 2015).

#Python 3.5.0 documentation. (2015-09-29) Retrived from https://docs.python.org/3/

print("===============\n  Caesar Encoding \n===============\n")

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

#take input of coded string
cypherString = takeInput("Please type the string to be decoded: ", str, None)
cypherString = cypherString.upper()

while True:
    #if key is known or not
    keyKnown = takeInput("Do you know the integer that was used to encode this? ", str, None)
    if keyKnown=="y" or keyKnown=="yes":
        #take and verify key
        while True:
            try:
                key = takeInput("Please enter an integer between 1 and 25: ", int, ValueError)
                assert(key>0)
                assert(key<26)
                break
            except AssertionError:
                print("Please enter a valid value between 1 and 25")
        #initialise uncoded string    
        plainString= ""
        #for each letter in coded string, subtract key to get uncoded letter
        for x in range(0, len(cypherString)):
            #if coded letter is not a letter, keep it the same
            if ord(cypherString[x])>90 or ord(cypherString[x])<65:
                plainString += cypherString[x]
            #if need have wraparound, add 26
            elif (ord(cypherString[x])-key)<65:
                plainString += chr(ord(cypherString[x])-key+26)
            #else subtract key and add the new letter to the uncoded string
            else:
                plainString += chr(ord(cypherString[x])-key)
        #print uncoded string and end 
        print("Plaintext : ", plainString)
        break
    #if key is not known
    elif keyKnown=="n"or keyKnown=="no":
        #try with every possible key (1-26)
        for key in range(1, 26):
            plainString= ""

            for x in range(0, len(cypherString)):
                #if coded letter is not a letter, keep it the same
                if ord(cypherString[x])>90 or ord(cypherString[x])<65:
                    plainString += cypherString[x]
                #if need have wraparound, add 26
                elif (ord(cypherString[x])-key)<65:
                    plainString += chr(ord(cypherString[x])-key+26)
                #else subtract key and add the new letter to the uncoded string
                else:
                    plainString += chr(ord(cypherString[x])-key)
            #print uncoded string 
            print("Possible Plaintext : ", plainString)
        #end
        break
    #invalid input for keyKnown
    else:
        print("please enter a valid reponse")