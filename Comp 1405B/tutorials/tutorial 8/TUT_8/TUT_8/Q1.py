def InsertSort(list):
    for i in range(1,len(list)):
        j = i-1
        while j>=0 and list[i]<list[j]:
            buff = list[i]
            list[i]=list[j]
            list[j]=buff
    print(list)
    return list
InsertSort([2,3,8,3,6,7])