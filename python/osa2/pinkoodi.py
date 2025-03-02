yritykset = 0

while True:
    tunnus = input("Anna PIN-koodi: ")
    yritykset += 1

    if tunnus == "1234":
        onnistui = True
        break

    if yritykset == 3:
        onnistui = False
        break

    # tänne tullaan jos väärin JA ei ole jo kolmea yritystä
    print("Väärin... yritä uudelleen")

if onnistui:
    print("PIN-koodi oikein!")
else:
    print("Liian monta yritystä...")