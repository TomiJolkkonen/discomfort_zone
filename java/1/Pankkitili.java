class Pankkitili { //pankkitilin metodi
	
	private String tilinumero, tilinOmistaja;
	private double saldo;
	
	public String gettilinumero() { //tasta saa tilinumeron
		
			return tilinumero;
		}
	
	public String gettilinOmistaja() { //tasta saa tilin omistajan nimen
		
			return tilinOmistaja;
		}	
		
	public double getsaldo() { //tasta saa saldon
		
			return saldo;
		}
		
	public void settilinOmistaja(String tilinOmistaja) { //tanne laitetaan tilin omistaja, vahan turha metodi
		
			this.tilinOmistaja=tilinOmistaja;
		}
		
	public void settilinumero(String tilinumero) { //tanne muutetaan tilinumero, vahan turha metodi
		
			this.tilinumero=tilinumero;
		}
		
	public void setsaldo(double saldo) { //tanne muutetaan saldoa, hyodyllinen metodi
		
			this.saldo=saldo;
		}
}
