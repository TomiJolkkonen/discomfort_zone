sanat = ""
sana = ""

while True:
    loppusana = sana
    sana = input("Anna sana: ")
    if sana == "loppu":
        break
    elif sana == loppusana:
        break
    sanat += sana + " "
print(sanat)


vuosi = int(input("Vuosi: "))

while True:
    vuosi += 1
    if (vuosi % 4 == 0 and vuosi % 100 != 0) or (vuosi % 400 == 0):
        print(f"Seuraava karkausvuosi on {vuosi}")
        break


sanat = ""
sana = ""

while True:
    loppusana = sana
    sana = input("Anna sana: ")
    if sana == "loppu":
        break
    elif sana == loppusana:
        break
    sanat += sana + " "
print(sanat)