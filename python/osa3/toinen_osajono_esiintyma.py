jono = input("Anna merkkijono: ")
osajono = input("Anna osajono: ")
 
kohta1 = jono.find(osajono)
kohta2 = -1
if kohta1 != -1:
    jono = jono[kohta1+len(osajono):]
    kohta2 = jono.find(osajono)
 
if kohta2 == -1:
    print("Osajono ei esiinny merkkijonossa kahdesti.")
else:
    print("Osajonon toinen esiintymä on kohdassa " + str(kohta1+len(osajono)+kohta2) +  ".")
 
