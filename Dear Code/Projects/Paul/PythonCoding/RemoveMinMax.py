def remove_min_max(mylist):
	a=min(mylist)
	b=max(mylist)
	return [x for x in mylist if x!=a and x!=b]
mylist=[2,43,6,34,55,12,89]
print(remove_min_max(mylist))