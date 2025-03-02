vuosi = int(input("Anna vuosi: "))

if vuosi % 4 != 0:
    print("Vuosi ei ole karkausvuosi.")
elif vuosi % 100 == 0:
    if vuosi % 400 == 0:
        print("Vuosi on karkausvuosi.")
    else:
        print("Vuosi ei ole karkausvuosi.")
else:
    print("Vuosi on karkausvuosi.")


"""
Milloin on seuraava karkausvuosi?-ohjelma

vuosi = int(input("Vuosi: "))

while True:
    vuosi += 1  # Lisätään vuoteen 1
    if (vuosi % 4 == 0 and vuosi % 100 != 0) or (vuosi % 400 == 0):
        print(f"Seuraava karkausvuosi on {vuosi}")
        break



# Kerätään yhteen merkkijonoon kaikki käyttäjän syöttämät pin-koodit

tunnukset = ""
yritykset = 0

while True:
    tunnus = input("Anna PIN-koodi: ")
    yritykset += 1
    tunnukset += tunnus + ", "
    # ...
"""