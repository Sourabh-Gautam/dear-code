def largest(*name):
	max=0
	for s in name:
		if len(s)>max:
			max=len(s)
			str=s
	return max,s
lenth,name=largest("december","march","july")
print(length,name)

