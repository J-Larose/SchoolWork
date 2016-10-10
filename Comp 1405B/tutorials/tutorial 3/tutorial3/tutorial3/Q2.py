
while True:
    operation = input("whould you like to add substract multiply or divide")
    while True:
        try:
            int1 = int(input("first int"))
            int2 = int(input("second int")) 
            break
        except ValueError:
            print("use ints")
    if operation=="a" or operation=="add":
        print(int1+int2)
    elif operation=="s" or operation=="subtract":
        print(int1-int2)
    elif operation=="d" or operation=="divide":
        print(int1/int2)
    elif operation=="m" or operation=="multiply":
        print(int1*int2)
