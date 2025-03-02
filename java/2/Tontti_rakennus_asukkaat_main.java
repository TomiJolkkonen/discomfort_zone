import java.util.Scanner;

class Tontti_rakennus_asukkaat_main {

	private static final Scanner lukija = new Scanner(System.in);
	
		public static void main(String [] args) {
      
			Tontti tontti;
			Rakennus rakennus;
			Asukkaat asukkaat;
      
			System.out.println("Hei! Syötetään seuraavaksi tontin, rakennuksen ja sen asukkaiden tiedot.");  //tontin tiedot talteen
			System.out.println("Minkä on tontin nimi: ");
			String tontinNimi = lukija.nextLine();
      
			System.out.println("Mitkä ovat tontin koordinaatit (muodossa 00.000-E ja 00.000-N): ");
			String tontinKoordinaatit = lukija.nextLine();
      
			System.out.println("Mikä on tontin pinta-ala (kokonaislukuna): ");
			int tontinPintaAla = Integer.parseInt(lukija.nextLine());
			if (tontinPintaAla <= 0){
				System.out.println("Pinta-ala ei voi olla negatiivinen.");
				return;
			}
      
			tontti = new Tontti(tontinNimi, tontinKoordinaatit, tontinPintaAla);
        
			System.out.println("Ja nyt sitten rakennuksen ja sen asukkaiden vuoro."); // rakennuksen ja sen asukkaiden tiedot talteen
			System.out.println("Montako huonetta rakennuksessa on: "); 
			int rakennuksenHuoneetYhteensa = Integer.parseInt(lukija.nextLine());
			if (rakennuksenHuoneetYhteensa <= 0){
				System.out.println("Huoneita ei voi olla negatiivinen määrä.");
				return;
			}
	  
			System.out.println(" Mikä on rakennuksen pinta-ala (kokonaislukuna): ");
			int rakennuksenPintaAla = Integer.parseInt(lukija.nextLine());
			if (rakennuksenPintaAla <= 0){
				System.out.println("Pinta-ala ei vo olla negatiivinen.");
				return;
			}
	  
			rakennus = new Rakennus(rakennuksenHuoneetYhteensa, rakennuksenPintaAla);
	  
	  
			int asukasMaara;
			System.out.println("Kuka talossa asuu? ");
			String asukkaanNimi= lukija.nextLine();
          
			System.out.println("Mikä on hänen syntymäaikansa (muodossa pp.kk.vvvv)? ");
			String asukkaanSyntymaAika= lukija.nextLine();
      
			asukkaat = new Asukkaat(asukkaanNimi, asukkaanSyntymaAika);

			rakennus.setAsukkaat(asukkaat);
			tontti.setRakennusTontille(rakennus);
			tontti.tulostaTontti();
      
			/*
			System.out.println("Tontin nimi on " + tontinNimi + " ."); // tulostetaan kaikki tiedot ulos
			System.out.println("Tontti löytyy koordinaateista " + tontinKoordinaatit + " .");
			System.out.println("Sen pinta-ala on " + tontinPintaAla + " .");
      
			System.out.println("Rakennuksessa on yhteensä " + tontti.getRakennusTontilta().getRakennuksenHuoneetYhteensa() + " huonetta.");
			System.out.println("Rakennuksen pinta-ala on " + rakennuksenPintaAla + " m2.");
              
			System.out.println("Talossa asuu: " + asukkaanNimi + ", syntymäaika " + asukkaanSyntymaAika + " .");  
			*/
 
   }
}
