word = input()
keyword = input()

new_word= ''
for i in word:
    if not i.isdigit():
        new_word += i
        
if keyword in new_word:
    print(1)
else:
    print(0)