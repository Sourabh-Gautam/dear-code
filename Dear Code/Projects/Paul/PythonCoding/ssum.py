sum=0
while(True):
	a=int(input("Enter the no.:"))
	if(a<0):
		continue
	if(a==0):
		print("Sum is ",sum)
		break
	sum=sum+a