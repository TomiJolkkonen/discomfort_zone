public class RegularSubscription extends Subscription {
    private int kesto;

    public RegularSubscription(String tilattuLehti, String tilaajanNimi, String tilaajanOsoite, double kuukausihinta, int kesto) {
       super(tilattuLehti, tilaajanNimi, tilaajanOsoite, kuukausihinta);
       this.kesto = kesto;
    }

    public int getKesto() { //getterit ja setterit
        return this.kesto;
    }
    public void setKesto(int kesto) {
        this.kesto = kesto;
    }


    public void printInvoice() { //lasku

        System.out.printf("%-25s%10s\n", "Tilauksen tyyppi: ", "Normaali");
        System.out.printf("%-25s%10s\n", "Lehti:", this.getTilattuLehti());
        System.out.printf("%-25s%10s\n","Tilaaja:", this.getTilaajanNimi());
        System.out.printf("%-25s%10s\n","Toimitusosoite:", getTilaajanOsoite());
        System.out.printf("%-25s%10d\n", "Laskutettavat kuukaudet:",this.getKesto());
        System.out.printf("%-25s%10.2f\n\n","Laskun summa:", 
                this.getKuukausiHinta()*this.kesto);
    }

 }   
    
