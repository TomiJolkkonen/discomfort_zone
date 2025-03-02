def  keskiarvo(luku1, luku2, luku3):
    vastaus = (luku1 + luku2 + luku3) / 3
    print(vastaus)
 
if __name__ == "__main__":
     keskiarvo(1, 2, 3)


def tulosta_monesti(merkkijono, kertaa):
    while kertaa > 0:
        print(merkkijono)
        kertaa -= 1
    
if __name__ == "__main__":
    tulosta_monesti("python", 5)
# tee ratkaisu tähän


def risunelio(koko):
    rivit = koko
    while rivit > 0:
        print("#" * koko)
        rivit -= 1
        
if __name__ == "__main__":
    risunelio(5)
# tee ratkaisu tänne


