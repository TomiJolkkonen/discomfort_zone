asti = int(input("Mihin asti: "))
luku = 1
summa = 0
lauseke = ""

while summa + luku <= asti:
    summa += luku
    lauseke += f"{luku} + "
    luku += 1

if summa < asti:
    summa += luku
    lauseke += f"{luku}"

lauseke = lauseke.rstrip(" + ")

print(f"Laskettiin {lauseke} = {summa}")