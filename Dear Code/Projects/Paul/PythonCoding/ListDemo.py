a=1
sum=0
my_list=[]
while a<=5:
	ip=eval(input("Enter "+str(a)+" element: "))
	my_list.append(ip)
	sum=sum+ip
	a+=1
print("The list is:")
for a in my_list:
	print(a)
print("Sum is",sum)
	