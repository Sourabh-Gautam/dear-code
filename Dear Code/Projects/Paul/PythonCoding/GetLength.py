def getlength(text):
	return [len(x) for x in text if x.lower()!='the']
text=input("Enter a sentence:").split()
print(getlength(text))