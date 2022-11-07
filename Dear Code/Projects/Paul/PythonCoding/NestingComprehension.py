def nestingComprehension(mylist):
	return [y for x in mylist for y in x if y%2==0 or y%3==0]
mylist=[1,2,3],[4,5,6],[7,8,9]
print(nestingComprehension(mylist))