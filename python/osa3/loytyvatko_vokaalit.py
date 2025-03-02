mjono = input("Anna merkkijono: ")
vokaalit = "aeo"
indeksi = 0
 
while indeksi < len(vokaalit):
    vokaali = vokaalit[indeksi]
    if vokaali in mjono:
        print(vokaali, "löytyy")
    else:
        print(vokaali, "ei löydy")
    indeksi += 1

