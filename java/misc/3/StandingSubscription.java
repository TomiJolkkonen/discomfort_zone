public class StandingSubscription extends Subscription {
    private int alennus;

    public StandingSubscription(String tilattuLehti, String tilaajanNimi, String tilaajanOsoite, double kuukausihinta, int alennus) {
       super(tilattuLehti, tilaajanNimi, tilaajanOsoite, kuukausihinta);
       this.alennus = alennus;
    }

    public int getAlennus() { //getterit ja setterit
        return alennus;
    }
    public void setAlennus(int alennus) {
        this.alennus = alennus;
    }



    public void printInvoice() { //lasku

        System.out.printf("%-25s%10s\n", "Tilauksen tyyppi: ", "Kesto");
        System.out.printf("%-25s%10s\n", "Lehti:", this.getTilattuLehti());
        System.out.printf("%-25s%10s\n","Tilaaja:", this.getTilaajanNimi());
        System.out.printf("%-25s%10s\n","Toimitusosoite:", getTilaajanOsoite());
        System.out.printf("%-25s%10d\n", "Laskutettavat kuukaudet:",12);
        System.out.printf("%-25s%10.2f\n\n","Laskun summa:", 
                (this.getKuukausiHinta()*12)*((double)(100-this.alennus)/100));
    }

}
