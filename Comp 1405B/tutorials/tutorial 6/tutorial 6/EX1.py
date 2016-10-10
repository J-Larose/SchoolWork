def In():
    ##EX1
    bi = int(input("binary int: "), 2)
    ##EX2
    bf = input("binary float: ")
    ##EX3
    di = int(input("decimal"))

    return bi, bf, di


def Out(bi, bf, di):
    ##EX1
    print(bi)
    ##EX2
    t = bf.split(".")
    df1 = bin(t[0])
    i=0
    for x in t[1]:
        df2 = pow(2, -i)*x
        if i==0:
            i=1
        else:
            i = i*2
    print(df1, ".", df2)
    ##EX3
    print(bin(di))

bi, bf, di = In()
Out(bi, bf, di)