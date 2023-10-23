public class Asukkaat{
	
	private String asukkaanNimi;
	private String asukkaanSyntymaAika;
	

// konstruktori
	public Asukkaat(){
		this.asukkaanNimi = null;
		this.asukkaanSyntymaAika = null;
	}

	public Asukkaat(Asukkaat asukkaat) {
		this.asukkaanNimi = asukkaat.asukkaanNimi;
		this.asukkaanSyntymaAika = asukkaat.asukkaanSyntymaAika;
	}
		
	public Asukkaat(String asukkaanNimi, String asukkaanSyntymaAika) {
		this.asukkaanNimi = asukkaanNimi;
		this.asukkaanSyntymaAika = asukkaanSyntymaAika;
	}

	
// getterit ja setterit
	public void setAsukkaanNimi(String asukkaanNimi) {
		this.asukkaanNimi = asukkaanNimi;
	}
	
	public String getAsukkaanNimi() {
		return this.asukkaanNimi;
	}
	
	public void setAsukkaanSyntymaAika(String asukkaanSyntymaAika) {
		this.asukkaanSyntymaAika = asukkaanSyntymaAika;
	}

	public String getAsukkaanSyntymaAika() {
		return this.asukkaanSyntymaAika;
	}
	public String toString(){
		return this.asukkaanNimi + ". Hanen syntymaaikansa on " + this.asukkaanSyntymaAika + " .";
   }

	
}
