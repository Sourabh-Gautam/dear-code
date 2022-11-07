def get_numbers(mylist):
	return [x for x in mylist if type(x) is int]
print(get_numbers([1,4,'paul',9]))