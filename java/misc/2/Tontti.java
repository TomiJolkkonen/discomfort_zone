public class Tontti{

	private String tontinNimi; 
	private String tontinKoordinaatit;
	private int tontinPintaAla;
	private Rakennus rakennus;

// konstruktori
	public Tontti(){
		tontinNimi = " ";
		tontinKoordinaatit = " ";
		tontinPintaAla = 0;
		rakennus = null;
	}
	
	public Tontti(String tontinNimi, String tontinKoordinaatit, int tontinPintaAla) {
		this.tontinNimi = tontinNimi;
		this.tontinKoordinaatit = tontinKoordinaatit;
		this.tontinPintaAla = tontinPintaAla;
		rakennus = null;
	}

// getterit ja setterit

	public void setTontinNimi(String tontinNimi) {
		this.tontinNimi = tontinNimi;
	}
	
	public String getTontinNimi() {
		return this.tontinNimi;
	}
	
	public void setTontinKoordinaatit(String tontinKoordinaatit) {
		this.tontinKoordinaatit = tontinKoordinaatit;
	}
	
	public String getTontinKoordinaatit() {
		return this.tontinKoordinaatit;
	}
	
	public int getTontinPintaAla(){
		return this.tontinPintaAla;
	}
	
	
// rakennus tontille ja asukkaat rakennukseen

	public void setRakennusTontille (Rakennus rakennus) {
		this.rakennus = rakennus;
	}
	
	public Rakennus getRakennusTontilta() {
		return this.rakennus;
	}
	
	public void setAsukasRakennukseen(Asukkaat asukkaat) {
		this.rakennus.setAsukkaat(asukkaat);
   }
   
   public Asukkaat getAsukasRakennuksesta() {
      return rakennus.getAsukkaat();
   }
   
   public void tulostaTontti(){
	   System.out.println("Tässä meillä on " + tontinNimi + " .");
	   System.out.println("Tontin koordinaatit ovat " + tontinKoordinaatit);
	   System.out.println("Tontin pinta-ala on " + tontinPintaAla + " m2.");
	   rakennus.printRakennus();
	}
   	
}
