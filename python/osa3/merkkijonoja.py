mjono = input("Anna merkkijono: ")
print("Ensimmäinen: " + mjono[0])
print("Viimeinen: " + mjono[-1])

kohta = 0
while kohta < len(mjono):
    print(mjono[kohta])
    kohta += 1

# Lopusta alkuun
mjono = input("Anna merkkijono: ")
kohta = len(mjono)-1
while kohta > -1:
    print(mjono[kohta])
    kohta -= 1

# Toinen ja toiseksi viimeinen
sana = input("Anna sana: ")

toinen_merkki = sana[1]
toiseksi_viimeinen_merkki = sana[len(sana)-2]

if toinen_merkki != toiseksi_viimeinen_merkki:
    print("Toinen ja toiseksi viimeinen kirjain eroavat")
else:
    print(f"Toinen ja toiseksi viimeinen kirjain on {toinen_merkki}")

# Risuaitaviiva
leveys = int(input("Leveys: "))
risuaita = "#"

while leveys > 0:
    print(risuaita, end="")
    leveys -= 1

