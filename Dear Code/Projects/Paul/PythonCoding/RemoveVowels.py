def removeVowels(text):
	return [x for x in text if x not in "aeiouAEIOU"]
text=input("Type a String:")
print(removeVowels(text))