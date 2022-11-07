l3=[]
l1=input("Enter list 1:").split()
l2=input("Enter list 2:").split()
for a in l1:
	if a in l2:      
		l3.append(a)
print(l3)
print(type(l1))
