"""
# Lause (statement) tarkoittaa ohjelman osaa, joka suorittaa jonkin toiminnon
# Esim print("Moi!") on lause, joka tulostaa rivin tekstiä, luku = 2 on lause, joka asettaa muuttujalle arvon

# Lohko (block) on joukko peräkkäin sijoitettuja lauseita samalla tasolla ohjelman rakenteessa
# Pythonissa lohko ilmaistaan sisennyksellä

# Lauseke (expression) on koodin osa, jolla on ojokin tyyppi
# esim 2 + 4 + 3, "abc" + "de", 11 / 2
# koska lausekkeella on arvo, voi sen sijoittaa muuttujaan

# Funktio (function) suorittaa jonkin toiminnon (ja joskus palauttaa arvon), sillä voi olla yksi tai useampi parametri (parameter) suluissa
# Funktio suoritetaan, kun sitä kutsutaan funktion nimellä ja sen parametreilla
# print on funktio, input on funktio

# Tyyppi (type) tarkoittaa, millainen jokin koodissa esiintyvä arvo on, esim. merkkijono, kokonaisluku jne

nimi = "Anna"
tulos = 100
print(type("Anna"))
print(type(100))

# Syntaksi (syntax) määrittää, miten ohjelman koodi tulee kirjoittaa
# Jokaisella ohjelmointikielellä on oma syntaksinsa
# Esim. Pythonin syntaksiin kuuluu, että if-lauseen aloitusrivin lopussa on kaksoispiste,
# ja ehtoon kuuluva koodi on sisennetty

# Debuggaaminen on bugien syiden selvittämistä
# Esim debug-tulostukset koodissa, eli print-komentoja, joilla koodissa tapahtuu haluttuja asioita
# Joskus auttaa kovakoodata ongelman aiheuttavat syötteet suoraan koodiin

# if else, onko luku parillinen
luku = int(input("Anna luku: "))

if luku % 2 == 0:
    print("Luku on parillinen")
else:
    print("Luku on pariton")

# Salasana
oikea = "kissa"
salasana = input("Anna salasana: ")

if salasana == oikea:
    print("Tervetuloa")
else:
    print("Pääsy kielletty")

# Vaihtoehtoiset haarat: elif

maalit_koti = int(input("Kotijoukkueen maalimäärä: "))
maalit_vieras = int(input("Vierasjoukkueen maalimäärä: "))

if maalit_koti > maalit_vieras:
    print("Kotijoukkue voitti!")
elif maalit_vieras> maalit_koti:
    print("Vierasjoukkue voitti!")
else:
    print("Tasapeli!")
"""

# else-haara ei ole pakollinen, jos on elif-haaroja
# merkkijonojen suuruusjärjestys: a tulee ennen b:tä joa se tulee aakkosissa ennen, eli on pienempi
# vain englannin aakkoset, isot ja pienet kirjaimet pitää vertailla keskenään

# Loogiset operaattorit and, or, not
# and vaatii että useampi ehto pätee samaan aikaan, or vaatii että yksi tai useampi pätee
# x >= a and x <= b on sama asia kuin a <= x <= b 
"""
# Sisäkkäiset ehtolauseet: 
luku = int(input("Anna luku: "))

if luku > 0:
    if luku % 2 == 0:
        print("Luku on parillinen")
    else:
        print("Luku on pariton")
else:
    print("Luku on negatiivinen")

# muista sisennykset, if ja else-parit muodostuvat sen perusteella



# Silmukka eli toistolause, while True
while True:
    luku = int(input("Anna luku, -1 lopettaa: "))

    if luku == -1:
        break

    print(luku ** 2)

print("Kiitos ja moi!")
"""

# Silmukka ja apumuuttujat

a = 1                       
while True:                 
    print(a)                
    a += 2                  
    if a > 5 and a % 2 == 0:
        break
