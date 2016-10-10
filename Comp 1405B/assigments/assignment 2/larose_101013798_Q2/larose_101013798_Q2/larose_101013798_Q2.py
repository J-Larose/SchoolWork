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
#take and verify key int
while True:
    try:
        key = takeInput("Please enter an integer between 1 and 25: ", int, ValueError)
        assert(key>0)
        assert(key<26)
        break
    except AssertionError:
        print("Please enter a valid value")
#initialise and print alphabet
plainAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
print("Plaintext Alphabet : ",plainAlphabet)
#initialise and populate coded alphabet
cypherAlphabet = ""
for x in range(0, len(plainAlphabet)):
    if (ord(plainAlphabet[x])+key)>90:
        cypherAlphabet += chr(ord(plainAlphabet[x])+key-26)
    else:
        cypherAlphabet += chr(ord(plainAlphabet[x])+key)
#print cypertxt alphabet
print("Ciphertext Alphabet : ",cypherAlphabet)

#take text to be coded, set it to uppercase, and print it in upper
plainString = takeInput("Please type the string to be encoded : ", str, None)
plainString = plainString.upper()
print("Plaintext : ", plainString)

#initialse and populate cyphered string
cypherString= ""    
for x in range(0, len(plainString)):
    if ord(plainString[x])>90 or ord(plainString[x])<65:
        cypherString += plainString[x]
    elif (ord(plainString[x])+key)>90:
        cypherString += chr(ord(plainString[x])+key-26)
    else:
        cypherString += chr(ord(plainString[x])+key)
#print coded string
print("Ciphertext : ",cypherString)