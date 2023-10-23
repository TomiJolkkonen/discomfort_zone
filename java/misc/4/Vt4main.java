import java.util.Scanner;

public class Vt4main {

    public static void main (String[] args) {
		
		Scanner lukija = new Scanner(System.in);

        double value;
        Property property;
        InsuranceInfo insuranceInfo;
        InsInfoContainer container = new InsInfoContainer();

        for (int i=0; i<5; i++) {
            property = new Property(null, null);

            System.out.println("Anna kiinteiston tyyppi: ");
            property.setType(lukija.nextLine());

            System.out.println("Anna kiinteiston sijaintipaikka: ");
            property.setLocation(lukija.nextLine());

			System.out.println("Anna kiinteistön arvo desimaalilukuna: ");
			value = Double.parseDouble(lukija.nextLine());

            }
           
            insuranceInfo = new InsuranceInfo(property, value);
  
            container.add(insuranceInfo);
        }
        
        container.printContents();   
        
    }
}
