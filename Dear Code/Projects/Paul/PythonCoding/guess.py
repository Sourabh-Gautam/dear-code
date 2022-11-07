import random
rno=random.randint(1,10)
print(rno)
print("Welcome to the Number guessing game.\nNote: You can type 0 or negative number for quit the game.\nGuess any number between 1-10\n")
gno=int(input("Type your guessing number: "))
while(True):
	if(rno==gno):
		print("Congratulation! You guessed it right.")
		break
	if(gno<=0):
		print("Game Over!")
		break
	if(gno>rno):
		print("Number too large. Try again!\n")
	if(gno<rno):
		print("Number too small. Try again!\n")
	gno=int(input("Type your guessing number again: "))
