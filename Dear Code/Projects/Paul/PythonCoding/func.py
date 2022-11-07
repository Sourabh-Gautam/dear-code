import math
def calculate(radius):
	if(radius<0):
		return "Cannot perforn caculation"
	a=math.pi*math.pow(radius,2)
	c=math.tau*radius
	return a,c
r=int(input("Enter radius:"))
t=calculate(r)
print("result is",t)