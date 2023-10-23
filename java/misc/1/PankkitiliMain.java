import java.util.Scanner;

class PankkitiliMain { //paaohjelma viikkotehtava 1 pankkitili
	
	public static void main(String[] args) {
		
		String tilinOmistaja, tilinumero;
		double saldo;
		int valinta;
		
		Scanner lukija = new Scanner(System.in); //otetaan scanneri kayttoon jolla talteen kayttajan vastaukset
		
		Pankkitili pt1 = new Pankkitili(); //luodaan pankkitilirakenne tyhjana
		
		System.out.println("Anna tilin omistajan nimi: "); //talletetaan tyhjaan rakenteeseen perustiedot
		pt1.settilinOmistaja(lukija.nextLine());
		
		System.out.println("Anna tilinumero (pituus 5 numeroa): ");
		pt1.settilinumero(lukija.nextLine());

		System.out.println("Anna tilin saldo: ");
		pt1.setsaldo(Integer.parseInt(lukija.nextLine()));
		
		System.out.println("Nimesi on " + pt1.gettilinOmistaja() + ", tilinumerosi on " + pt1.gettilinumero() + " ja saldosi on " + pt1.getsaldo() + "€.");

        while (true) {
    		System.out.println("");	
	    	System.out.println("Valitse: 1 Tilin tiedot 2 Otto 3 Talletus 4 Lopetus"); //perusvalikko
            valinta = Integer.parseInt(lukija.nextLine());
		
            if (valinta < 1 || valinta > 3) { //virheentarkistus seka lopetus eli nelonen samassa
                System.out.println("Loppu!");
                break;
            }
		    if (valinta == 1) { //tilitiedot
			    tilinOmistaja = pt1.gettilinOmistaja();
			    tilinumero = pt1.gettilinumero();
			    saldo = pt1.getsaldo();
			
			    System.out.println("Tililla " + tilinumero + " saldo on " + saldo + "€.");
			    continue;
		    }
		
		    if (valinta == 2) { //otto
			    tilinOmistaja = pt1.gettilinOmistaja();
			    tilinumero = pt1.gettilinumero();
			    saldo = pt1.getsaldo();
			
			    System.out.println("Tililla " + tilinumero + " saldo on " + saldo + "€. Paljonko otetaan? ");
			    double ottovalinta = Integer.parseInt(lukija.nextLine());
			
			    if (ottovalinta > saldo || ottovalinta < 0) {
				    System.out.println("Tililla ei ole tarpeeksi saldoa tai syotit negatiivisen luvun. ");
                    continue;
			    } else  if (ottovalinta < 0) {
				    System.out.println("Et voi ottaa negatiivisia arvoja. ");
			    }
				    pt1.setsaldo(pt1.getsaldo() - ottovalinta);
				    System.out.println("Otit " + ottovalinta + " € ja tilille jai " + pt1.getsaldo() + " €.");
			
			    continue;
		    }
		
		    if (valinta == 3) { //talletus
			    tilinOmistaja = pt1.gettilinOmistaja();
			    tilinumero = pt1.gettilinumero();
			    saldo = pt1.getsaldo();
			
			    System.out.println("Tililla " + tilinumero + " saldo on " + saldo + "€. Paljonko talletetaan? ");
			    double talletusvalinta = Integer.parseInt(lukija.nextLine());
			
			    if (talletusvalinta < 0) {
				    System.out.println("Et voi tallentaa negatiivisia arvoja. ");
                    continue;
			    } else {
				    pt1.setsaldo(pt1.getsaldo() + talletusvalinta);
				    System.out.println("Talletit " + talletusvalinta + " € ja tililla on nyt " + pt1.getsaldo() + " €.");
			    }
			    continue;
		    }
		}

	}
}
