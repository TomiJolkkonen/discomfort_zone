lahja = float(input("Lahjan suuruus? "))

if lahja >= 5000 and lahja <= 24999:
    vero = 100 + (lahja - 5000) * 0.08
    print(f"Vero: {vero} euroa")
elif lahja > 25000 and lahja < 54999:
    vero = 1700 + (lahja - 25000) * 0.1
    print(f"Vero: {vero} euroa")
elif lahja > 55000 and lahja < 199999:
    vero = 4700 + (lahja - 55000) * 0.12
    print(f"Vero: {vero} euroa")
elif lahja > 200000 and lahja < 999999:
    vero = 22100 + (lahja - 200000) * 0.15
    print(f"Vero: {vero} euroa")
elif lahja >= 1000000:
    vero = 142100 + (lahja - 1000000) * 0.17
    print(f"Vero: {vero} euroa")
else:
    print("Ei veroa!")