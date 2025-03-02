leveys = int(input("Leveys: "))
korkeus = int(input("Korkeus: "))
 
n = 0
while n < korkeus:
    print("#" * leveys)
    n += 1


mjono = " "

while mjono != "":
    mjono = input("Anna merkkijono: ")
    if mjono == "":
        break
    print(mjono)
    print("-" * len(mjono))


merkkijono = input("Sana: ")

tahtijono = 20 - len(merkkijono)

tulos = "*" * tahtijono + merkkijono

print(tulos)