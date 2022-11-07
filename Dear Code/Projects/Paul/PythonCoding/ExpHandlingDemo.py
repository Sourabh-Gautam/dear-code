while True:
	try:
		fn=int(input("Enter first number: "))
		sn=int(input("Enter second number: "))
		div=fn/sn
		print("The Division is ",div)
		break
	except ValueError:
		print("Please enter numeric values only. Try again!")
	except ZeroDivisionError:
		print("Denominator 0 not allowed. Please enter non-zero denominator. Try again!")