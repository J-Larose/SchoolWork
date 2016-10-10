def Factorial(n):
    if n != 0:
        x = 1
        for i in range(1, n+1):
            x *= i
        return x
    else:
        return 1

def Row(n):
    row = []
    k = 0
    while k<=n:
        x = Factorial(n)
        y = Factorial(k)
        z = (Factorial((n-k)))
        row.append(int((x/(y*z))))

        k += 1
    return row

def Main():
    num = int(input("What number do you want?"))
    n = 0
    row = [1]
    while num not in row:
        row = Row(n)
        print((" ".join(str(x) for x in row)).center(60))

        n+=1


Main()