# Speaking pets in Python
class Pet:
    def speak(self): pass


class Cat(Pet):
    def speak(self):
        print("meow!")


class Dog(Pet):
    def speak(self):
        print("woof!")

def command(pet):
    pet.speak()

pets = [ Cat(), Dog() ] # (1)

for pet in pets: # (2)
    command(pet)