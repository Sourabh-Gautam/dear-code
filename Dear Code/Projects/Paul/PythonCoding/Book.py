class Book:
	def __init__(self, name, price):
		self.name=name
		self.price=price
	def __str__(self):
		return f"Name:{self.name}, Price:{self.price}"
	def __add__(self, other):
		return self.price+other.price
		
obj1=Book(input("Enter first book name: "), int(input("Enter first book price: ")))
obj2=Book(input("Enter second book name: "), int(input("Enter second book price: ")))
print(f"The total prize of books",obj1+obj2)
		