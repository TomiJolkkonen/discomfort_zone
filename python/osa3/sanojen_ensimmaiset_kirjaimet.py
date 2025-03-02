lause = input("Anna lause: ")

for sana in lause.split():
    print(sana[0])

# tai

lause = input("Anna lause: ")
 
# Lisätään alkuun välilyönti, jotta käsittely helpottuu
lause = " " + lause
 
# Etsitään kohdat, joita ennen on välilyönti
kohta = 1
while kohta < len(lause):
    if lause[kohta-1] == " " and lause[kohta] != " ":
        print(lause[kohta])
    kohta += 1