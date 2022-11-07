def findlargest(*a):
	max=0
	for s in a:
		if len(s)>max:
			max=len(s)
			lar=s
	return max,lar
max,lar=findlargest("Sunday")
print("The String",lar,"is largest having length",max)