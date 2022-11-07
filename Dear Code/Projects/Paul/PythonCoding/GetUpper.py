def get_upper(text):
	return [x.upper() for x in text if x.lower() not in 'aeiou']
text=input("Enter a String:")
print(get_upper(text))