package klase;

public class Grad {
	
	private int pttBroj;
	private String naziv;
	
	public Grad() {
		super();
	}

	public Grad(int pttBroj, String naziv) {
		super();
		this.pttBroj = pttBroj;
		this.naziv = naziv;
	}

	public int getPttBroj() {
		return pttBroj;
	}

	public void setPttBroj(int pttBroj) {
		this.pttBroj = pttBroj;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Grad " + this.naziv + " ima postanski broj " + this.pttBroj);
		return sb.toString();
	}
	
public String toFileRepresentation(){
		StringBuilder sb = new StringBuilder(this.pttBroj +";"+ this.naziv);
		return sb.toString();
	}

}
