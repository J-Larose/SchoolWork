def Calculate(row2):
    row1=row2[:]
    del row2[:]
    row2.append(1)
    for i in range(1, len(row1)+1):
        try:
            row2.append(row1[i]+row1[i-1])
        except:
            row2.append(1)
    return row2

def Main():
    num=int(input("what number would you like to find?"))
    row = [1]
    print(str(row[0]).center(60))
    while num not in row:
        row = Calculate(row)
        print((" ".join(str(x) for x in row)).center(60))

Main()