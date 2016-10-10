import math
days = int(input("how many days?"))
print ("that is", math.floor(days/365), "years,", math.floor((days%365)/30), "months and", math.floor(((days%365)%30)/7), "weeks and", ((days%365)%30)%7, "days" )