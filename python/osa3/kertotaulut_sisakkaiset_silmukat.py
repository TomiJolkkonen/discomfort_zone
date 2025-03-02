luku = int(input("Anna luku: "))
laskuri1 = 1
while laskuri1 <= luku:
    laskuri2 = 1
    while laskuri2 <= luku:
        print(f"{laskuri1} x {laskuri2} = {laskuri1*laskuri2}")
        laskuri2 += 1
    laskuri1 += 1