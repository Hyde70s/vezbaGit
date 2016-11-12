package klase;

public class KulturnaManifestacija {
	
	private int id;
	private String naziv;
	private int brojPosetilaca;
	private Grad grad;
	
	public KulturnaManifestacija() {
		super();
	}

	public KulturnaManifestacija(int id, String naziv, int brojPosetilaca, Grad grad) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.brojPosetilaca = brojPosetilaca;
		this.grad = grad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getBrojPosetilaca() {
		return brojPosetilaca;
	}

	public void setBrojPosetilaca(int brojPosetilaca) {
		this.brojPosetilaca = brojPosetilaca;
	}

	public Grad getGrad() {
		return grad;
	}

	public void setGrad(Grad grad) {
		this.grad = grad;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Kulturna manifestacija " + this.id + " " + this.naziv + 
				" se odrzava u gradu " + this.grad + " i ima " + this.brojPosetilaca + " posetilaca");
		return sb.toString();
	}
	
	public String toFileRepresentation(){
		StringBuilder sb = new StringBuilder(this.id +";"+ this.naziv + ";" + this.brojPosetilaca + ";" +
				this.grad);
		return sb.toString();
	}

}
