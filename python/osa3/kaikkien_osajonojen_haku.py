sana = input("Sana: ")
merkki = input("Merkki: ")
 
kohta = 0
 
while kohta + 3 <= len(sana):
    if sana[kohta] == merkki:
        print(sana[kohta:kohta+3])
    kohta += 1
 