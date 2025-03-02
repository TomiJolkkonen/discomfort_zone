# luvun tulostamista
tulos = 10 * 25
print("Tulos on " + str(tulos))
print("Tulos on", tulos) # huomaa, muuttujien väliin tulee ylimääräinen välilyönti 
print(f"Tulos on {tulos}") # f-merkkijono, muuttuja aaltosulkujen sisälle

# Kokonaisluvun jakolasku, vastaus pyöristetään alaspäin kokonaisluvuksi
print (9 // 2)
# Jakojäännös
print (9 % 2)
# Potenssi
print (9 ** 2)
# Ensin potenssilaskut, sitten kerto- ja jakolaskut, lopuksi yhteen- ja vähennyslaskut, sulut muuttaa laskujärjestystä
# Operaattori on laskutoimitus eli +, -, *, /, millä operoidaan
# Operandi on luku laskutoimituksessa eli 2, 3, 5, -1.0,. mitä operoidaan
# Jakolaskun / tulos on liukuluku vaikka operandit olisivatkin kokonaislukuja
print (1 / 5)

x = 3
y = 2

print(f"/-operaattori {x/y}")
print(f"//-operaattori {x//y}")

# muunna käyttäjän syöte kokonaisluvuksi
vuosi = int(input("Minä vuonna olet syntynyt? "))
print(f"Ikäsi vuoden 2020 lopussa: {2020 - vuosi}")

# merkkijonon muunnin: str, liukuluvun: float

# summaaminen yhteen muuttujaan
summa = 0

summa += int(input("Ensimmäinen luku: "))
summa += int(input("Toinen luku: "))
summa += int(input("Kolmas luku: "))

print(f"Lukujen summa: {summa}")

# Ehtolause
ika = int(input("Kuinka vanha olet? "))

if ika > 17:
    print("Olet täysi-ikäinen!")
    print("Tässä siis sinulle ikiomaksi GTA6.")

print("Seuraava asiakas, kiitos!")

# Vertailuoperaattorit: 
# == Yhtä suuri
# != Eri suuri
# > Suurempi
# >= Suurempi tai yhtä suuri
# < Pienempi
# <= Pienempi tai yhtä suuri

# Ehtorakenteessa rivit tulee sisentää

# Ehtorakenne
a = 3
ehto = a < 5
print(ehto)
if ehto: 
    print("a on pienempi kuin 5")
    