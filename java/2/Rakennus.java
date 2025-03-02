public class Rakennus{
	

	private int rakennuksenHuoneetYhteensa;
	private int rakennuksenPintaAla;
	private Asukkaat asukkaat;
	
// konstruktori

	public Rakennus(){
		rakennuksenHuoneetYhteensa = 0;
		rakennuksenPintaAla = 0;
		asukkaat = null;
	}
	
	public Rakennus(int rakennuksenHuoneetYhteensa, int rakennuksenPintaAla) {
		this.rakennuksenHuoneetYhteensa = rakennuksenHuoneetYhteensa;
		this.rakennuksenPintaAla = rakennuksenPintaAla;
		asukkaat = null;
	}
	
// getterit ja setterit

	public void setRakennuksenHuoneetYhteensa(int rakennuksenHuoneetYhteensa) {
		this.rakennuksenHuoneetYhteensa = rakennuksenHuoneetYhteensa;
	}
	
	public int getRakennuksenHuoneetYhteensa() {
		return this.rakennuksenHuoneetYhteensa;
	}
	
	public void setRakennuksenPintaAla(int rakennuksenPintaAla) {
		this.rakennuksenPintaAla = rakennuksenPintaAla;
	}
	
	public int getRakennuksenPintaAla() {
		return this.rakennuksenPintaAla;
	}

	public void setAsukkaat(Asukkaat asukkaat) {
		this.asukkaat = asukkaat;
	}
	
	public Asukkaat getAsukkaat() {
		return this.asukkaat;
	}
	
	public void printRakennus(){
		System.out.println("Tontin rakennuksessa on " + rakennuksenHuoneetYhteensa + " huonetta ja pinta-ala on " + rakennuksenPintaAla + " m2. Täällä asuu " + this.asukkaat.toString());
	}
	
}

	
