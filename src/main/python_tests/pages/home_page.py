def age ():
    int = float(input('Age: '))
    if int < 0:
        return 'Invalid age'
    elif int < 18:
        return 'Minor'
    elif int < 65:
        return 'Adult'
    else:
        return 'Senior'
print(age())
