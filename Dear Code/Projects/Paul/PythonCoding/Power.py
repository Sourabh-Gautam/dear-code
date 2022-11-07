class Power:
	def __init__(self, name, price):
		self.name=name
		self.price=price
	def __rpow__(self, other):
		return other**self.price
o2=Power("English", 2)
print(25**o2)