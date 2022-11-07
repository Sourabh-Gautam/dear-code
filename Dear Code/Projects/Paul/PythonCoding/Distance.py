class Distance:
	def __init__(self, feet, inches):
		self.feet=feet
		self.inches=inches
		
	def __str__(self):
		return f"Feet: {self.feet}, Inch: {self.inches}"

	def __add__(self, other):
		totalfeet=self.feet+other.feet
		totalinch=self.inches+other.inches
		if totalinch>=12:
			totalfeet=totalfeet+totalinch//12
			totalinch=totalinch%12
		return Distance(totalfeet, totalinch)
	
obj1=Distance(9,12)
obj2=Distance(9,12)
print(obj1+obj2)