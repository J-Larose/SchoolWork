class Pet(object):
    petTypes = ["cat", "dog", "bird"]
    def __init__(self, name, type, age):
        self.__name = name
        self.__type = type
        self.__age = age
        self.__bill = 0

    def growOlder(self):
        self.__age += 1
    def addToBill(self, num):
        self.__bill += num
    def getName(self):
        return self.__name
    def setName(self, name):
        self.__name = name
    def getType(self):
        return self.__type
    def setType(self, type):
        if type in petTypes:
            self.__type = type
        else:
            return "ERR: not on list"
    def getAge(self):
        return self.__age
    def getBill(self):
        return self.__bill
