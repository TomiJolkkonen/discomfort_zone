luku = int(input("Luku: "))
 
vasen = 1
oikea = luku
 
while vasen < oikea:
    print(vasen)
    print(oikea)
    vasen += 1
    oikea -= 1
 
if vasen == oikea:
    print(vasen)