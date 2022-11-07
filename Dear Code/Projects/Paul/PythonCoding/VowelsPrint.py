lobj=list(filter(lambda c:True if c in "aeiouAEIOU" else False, input("Enter your name: ")))
if lobj!=[]:
	print(lobj)
else:
	print("No vowels in your name")