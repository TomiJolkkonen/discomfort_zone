sana = input("Sana: ")
merkki = input("Merkki: ")
 
kohta = sana.find(merkki)
if kohta!=-1 and len(sana)>=kohta+3:
    print(sana[kohta:kohta+3])