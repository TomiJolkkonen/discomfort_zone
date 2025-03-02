while True:
    luku = int(input("Anna luku: "))
    if luku <= 0:
        break
 
    kertoma = 1
    uusi = 1
    while uusi <= luku:
        kertoma *= uusi
        uusi += 1
 
    print(f"Luvun {luku} kertoma on {kertoma}")
 
print("Kiitos ja moi!")