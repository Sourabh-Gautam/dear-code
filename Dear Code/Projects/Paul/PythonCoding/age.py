import datetime
age=input("Enter your age(dd:mm:yyyy): ")
dd,mm,yyyy=age.split(":")
print("After 100 year you  will be of",datetime.datetime.now().year-int(yyyy)+100,"years")