l=[]
str=input("enter a string")
for a in str:
	if 47<ord(a)<59:
		l.append(a)
print(l)