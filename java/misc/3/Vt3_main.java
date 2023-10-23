import java.util.Scanner;

public class Vt3_main {
    
    static public void main (String[] args) {
		
		Scanner lukija = new Scanner(System.in);

        Subscription tilaus = null;
        String luettu = null;
        String tilauksenTyyppi = null;
        String tilattuLehti;
        String tilaajanNimi;
        String tilaajanOsoite;
        double kuukausihinta;
        int kesto;
        int alennus;


		System.out.println("Tervetuloa tilaamaan lehti! ");
        System.out.println("Anna tilauksen tyyppi (tavallinen/kesto):");
        tilauksenTyyppi = lukija.nextLine();
        
		System.out.println("Mika on lehtitilauksen kuukausihinta (0-100)");
        kuukausihinta = Double.parseDouble(lukija.nextLine());
        
        System.out.println("Anna lehden nimi:");
        tilattuLehti = lukija.nextLine();

        System.out.println("Anna tilaajan nimi:");
        tilaajanNimi = lukija.nextLine();
        
        System.out.println("Anna tilaajan osoite:");
        tilaajanOsoite = lukija.nextLine();
        
        if (tilauksenTyyppi.matches("tavallinen")) {
            System.out.println("Anna tilattujen kuukausien maara: ");
            kesto = Integer.parseInt(lukija.nextLine());
            tilaus = new RegularSubscription(tilattuLehti, tilaajanNimi, tilaajanOsoite, kuukausihinta, kesto);
        }
        if (tilauksenTyyppi.matches("kesto")) {
            System.out.println("Anna alennusprosentti (0-100): ");
            alennus = Integer.parseInt(lukija.nextLine());
            tilaus = new StandingSubscription(tilattuLehti, tilaajanNimi, tilaajanOsoite, kuukausihinta, alennus);
        }
        
        printSubscriptionInvoice(tilaus);

    }

    public static void printSubscriptionInvoice (Subscription sub) {
        if (sub instanceof RegularSubscription) {
            RegularSubscription tilaus = (RegularSubscription) sub;
            tilaus.printInvoice();
        }
        else if (sub instanceof StandingSubscription) {
            StandingSubscription tilaus = (StandingSubscription) sub;
            tilaus.printInvoice();
        }
        
        else {
            System.out.println("Virhe");
        }
    }

}
