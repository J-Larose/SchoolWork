import math
side1 = int(input("what is the first side"))
side2 = int(input("what is the seccond side"))

print ("the radius is", math.sqrt(math.pow(side1, 2) + math.pow(side2, 2)))
print ("the diameter is", (math.sqrt(math.pow(side1, 2) + math.pow(side2, 2)))*2)
print ("circumference is", 2*math.pi*(math.sqrt(math.pow(side1, 2) + math.pow(side2, 2))))
print ("area is", math.pi*(math.sqrt(math.pow(side1, 2) + math.pow(side2, 2))))