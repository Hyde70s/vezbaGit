package meniji;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import klase.Grad;
import pomocne.klase.PomocneKlase;

public class MeniGrad {
	
	public static HashMap<Integer, Grad> gradovi = new HashMap<Integer, Grad>();
	
	public static void ispisiMeni() {
		System.out.println("Meni za rad sa gradovima - opcije:");
		System.out.println("0. Povratak u glavni meni");
		System.out.println("1. Prikaz svih gradova");
		System.out.println("2. Unos novog grada");
		System.out.println("3. Izmena grada");
		System.out.println("4. Brisanje grada");
	}

	public static void meniGrad() {
		int opcija = -1;
		while(opcija != 0) {
			MeniGrad.ispisiMeni();;
			System.out.println("Unesite opciju:");
			opcija = PomocneKlase.ceoBroj();
			switch(opcija) {
				case 0:
					break;
				case 1:
					prikazSvihGradova();
					break;
				case 2:
					unosNovogGrada();
					break;
				case 3:
					izmenaGrada();
					break;
				case 4:
					brisanjeGrada();
					break;
				default:
					System.out.println("Uneli ste nepostojecu opciju");
			}
		}
	}
	
	public static void prikazSvihGradova() {
		for(Grad grad : gradovi.values()) {
			System.out.println(grad);
		}
	}
	
	public static void unosNovogGrada() {
		System.out.print("Unesite postanski broj:");
		int ptt = PomocneKlase.ceoBroj();
		while(gradovi.containsKey(ptt)){
			System.out.println("Grad sa postanskim brojem "+ ptt + " vec postoji");
			System.out.print("Unesite postanski broj:");
			ptt = PomocneKlase.ceoBroj();
		}
		String ime;
		System.out.println("Unesite ime grada:");
		ime = PomocneKlase.tekst();
		Grad grad = new Grad(ptt, ime);
		gradovi.put(ptt, grad);
		System.out.println("Grad je uspesno unet");
	}
	
	public static void izmenaGrada() {
		System.out.println("Unesite postanski broj grada:");
		int ptt = PomocneKlase.ceoBroj();
		if(gradovi.containsKey(ptt)) {
			System.out.println("Unesite novo ime za grad:");
			String ime = PomocneKlase.tekst();
			Grad grad = new Grad(ptt, ime);
			gradovi.put(ptt, grad);
			System.out.println("Grad je uspesno izmenjen");
		} else {
			System.out.println("Uneli ste nepostojeci postanski broj");
		}
	}
	
	public static void brisanjeGrada() {
		System.out.println("Unesite postanski broj grada:");
		int ptt = PomocneKlase.ceoBroj();
		if(gradovi.containsKey(ptt)) {
			Grad grad = gradovi.get(ptt);
			gradovi.remove(ptt, grad);
			System.out.println("Grad je uspesno obrisan");
		} else {
			System.out.println("Uneli ste nepostojeci postanski broj");
		}
	}
	
	static void citajIzFajlaGradove(File dokument) throws IOException {
		if(dokument.exists()){
			BufferedReader in = new BufferedReader(new FileReader(dokument));
			in.mark(1);
			if(in.read()!='\ufeff'){
				in.reset();
			}
			String s;
			while((s = in.readLine()) != null) {
				String[] tokeni = s.split(";");
				int ptt = Integer.parseInt(tokeni[0]);
				String naziv = tokeni[1];
				Grad grad = new Grad(ptt, naziv);
				gradovi.put(ptt, grad);
			}
			in.close();
		} else {
			System.out.println("Ne postoji fajl!");
		}
	}
	
	static void pisiUFajlGradove(File dokument) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(dokument));
		for (Grad grad : gradovi.values()) {
			out.println(grad.toFileRepresentation());
		}
		
		out.flush();
		out.close();
	}

}
