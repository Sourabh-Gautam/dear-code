def flatten(nestedList):
	return [y for x in nestedList for y in x]
nestedList=[[1,2,3],[4,5,6],[7,8,9]]
print("Before calling flatten list is",nestedList,sep="\n")
print("After calling flatten list is",flatten(nestedList))