merkkijono = input("Anna merkkijono: ")
 
pituus = 1
while pituus <= len(merkkijono):
    print(merkkijono[0:pituus])
    pituus += 1

merkkijono = input("Anna merkkijono: ")
 
alku = len(merkkijono) - 1
while alku >= 0:
    print(merkkijono[alku:])
    alku -= 1