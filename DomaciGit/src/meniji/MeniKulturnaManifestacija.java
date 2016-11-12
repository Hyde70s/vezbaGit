package meniji;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import klase.Grad;
import klase.KulturnaManifestacija;
import pomocne.klase.PomocneKlase;

public class MeniKulturnaManifestacija {
	
	public static HashMap<Integer, KulturnaManifestacija> kulturneManifestacije =
			new HashMap<Integer, KulturnaManifestacija>();
	
	public static void ispisiMeni() {
		System.out.println("Meni za rad sa kulturnim manifestacijama - opcije:");
		System.out.println("0. Povratak u glavni meni");
		System.out.println("1. Prikaz svih kulturnih manifestacija");
		System.out.println("2. Unos nove kulturne manifestacije");
		System.out.println("3. Izmena kulturne manifestacije");
		System.out.println("4. Brisanje kulturne manifestacije");
		System.out.println("5. Pretraga kulturnih manifestacija po identifikatoru");
		System.out.println("6. Prikaz kulturne manifestacije sa najvecim brojem posetilaca");
		System.out.println("7. Prikaz kulturnih manifestacija koje su se odrzale u istom gradu");
	}
	
	public static void meniKulturnaManifestacija() {
		int opcija = -1;
		while(opcija != 0) {
			MeniKulturnaManifestacija.ispisiMeni();;
			System.out.println("Unesite opciju:");
			opcija = PomocneKlase.ceoBroj();
			switch(opcija) {
			case 0:
				break;
			case 1:
				prikazSvihKulturnihManifestacija();
				break;
			case 2:
				unosNoveKulturneManifestacije();
				break;
			case 3:
				izmenaKulturneManifestacije();
				break;
			case 4:
				brisanjeKulturneManifestacije();
				break;
			case 5:
				pretragaKulturneManifestacijePoIdentifikatoru();
				break;
			case 6:
				break;
			case 7:
				prikazKulturnihManifestacijaIzIstogGrada();
				break;
			default:
				System.out.println("Uneli ste nepostojecu opciju");
			}
		}
	}

	public static void prikazSvihKulturnihManifestacija() {
		for(KulturnaManifestacija kulturnaManifestacija : kulturneManifestacije.values()) {
			System.out.println(kulturnaManifestacija);
		}
	}

	public static void unosNoveKulturneManifestacije() {
		System.out.print("Unesite id:");
		int id = PomocneKlase.ceoBroj();
		while(kulturneManifestacije.containsKey(id)){
			System.out.println("Kulturna manifestacija sa id-em "+ id + " vec postoji");
			System.out.print("Unesite id:");
			id = PomocneKlase.ceoBroj();
		}
		String ime;
		System.out.println("Unesite ime:");
		ime = PomocneKlase.tekst();
		System.out.println("Unesite broj posetilaca:");
		int brojPosetilaca = PomocneKlase.ceoBroj();
		System.out.println("Unesite postanski broj grada:");
		int ptt = PomocneKlase.ceoBroj();
		while(!MeniGrad.gradovi.containsKey(ptt)){
			System.out.println("Grad sa postanskim brojem "+ ptt + " ne postoji");
			System.out.print("Unesite postanski broj grada:");
			ptt = PomocneKlase.ceoBroj();
		}
		Grad grad = MeniGrad.gradovi.get(ptt);
		KulturnaManifestacija kulturnaManifestacija = new KulturnaManifestacija(id, ime, brojPosetilaca, grad);
		kulturneManifestacije.put(id, kulturnaManifestacija);
		System.out.println("Kulturna manifestacija je uspesno uneta");
	}

	public static void izmenaKulturneManifestacije() {
		System.out.println("Unesite id:");
		int id = PomocneKlase.ceoBroj();
		if(kulturneManifestacije.containsKey(id)) {
			System.out.println("Unesite novo ime:");
			String ime = PomocneKlase.tekst();
			System.out.println("Unesite nov broj posetilaca:");
			int brojPosetilaca = PomocneKlase.ceoBroj();
			System.out.println("Unesite postanski broj grada:");
			int ptt = PomocneKlase.ceoBroj();
			while(!MeniGrad.gradovi.containsKey(ptt)){
				System.out.println("Grad sa postanskim brojem "+ ptt + " ne postoji");
				System.out.print("Unesite postanski broj grada:");
				ptt = PomocneKlase.ceoBroj();
			}
			Grad grad = MeniGrad.gradovi.get(ptt);
			KulturnaManifestacija kulturnaManifestacija = new KulturnaManifestacija(id, ime, brojPosetilaca, grad);
			kulturneManifestacije.put(id, kulturnaManifestacija);
			System.out.println("Kulturna manifestacija je uspesno izmenjena");
		} else {
			System.out.println("Uneli ste nepostojeci id");
		}
	}

	public static void brisanjeKulturneManifestacije() {
		System.out.println("Unesite id:");
		int id = PomocneKlase.ceoBroj();
		if(kulturneManifestacije.containsKey(id)) {
			KulturnaManifestacija kulturnaManifestacija = kulturneManifestacije.get(id);
			kulturneManifestacije.remove(id, kulturnaManifestacija);
			System.out.println("Kulturna Manifestacija je uspesno obrisana");
		} else {
			System.out.println("Uneli ste nepostojeci id");
		}
	}
	
	public static KulturnaManifestacija pretragaKulturneManifestacijePoIdentifikatoru() {
		KulturnaManifestacija kulturnaManifestacija = null;
		System.out.println("Unesite id:");
		int id = PomocneKlase.ceoBroj();
		if(kulturneManifestacije.containsKey(id)) {
			kulturnaManifestacija = kulturneManifestacije.get(id);
			System.out.println("Trazena kulturna manifestacija je:" + kulturnaManifestacija);
		} else {
			System.out.println("Uneli ste nepostojeci id");
		}
		return kulturnaManifestacija;
	}
	
	public static void prikazKulturnihManifestacijaIzIstogGrada() {
		System.out.println("Unesite grad:");
		String grad = PomocneKlase.tekst();
		boolean postoji = false;
		for(KulturnaManifestacija kulturnaManifestacija : kulturneManifestacije.values()) {
			if(kulturnaManifestacija.getGrad().equals(grad)) {
				System.out.println(kulturnaManifestacija);
				postoji = true;;
			}
		}
		if(!postoji) {
			System.out.println("Uneli ste nepostojeci grad");
		}
	}

	static void citajIzFajlaKulturneManifestacije(File dokument) throws IOException {
		if(dokument.exists()){
			BufferedReader in = new BufferedReader(new FileReader(dokument));
			in.mark(1);
			if(in.read()!='\ufeff'){
				in.reset();
			}
			String s;
			while((s = in.readLine()) != null) {
				String[] tokeni = s.split(";");
				int id = Integer.parseInt(tokeni[0]);
				String naziv = tokeni[1];
				int brojPosetilaca = Integer.parseInt(tokeni[2]);
				String nazivGrada = tokeni[4];
				int ptt = 0;
				for(Grad grad1 : MeniGrad.gradovi.values()) {
					if(grad1.getNaziv().equals(nazivGrada)) {
						ptt = grad1.getPttBroj();
					}
				}
				Grad grad = new Grad(ptt, nazivGrada);
				KulturnaManifestacija kulturnaManifestacija = new KulturnaManifestacija(id, naziv, brojPosetilaca, grad);
				kulturneManifestacije.put(id, kulturnaManifestacija);
			}
			in.close();
		} else {
			System.out.println("Ne postoji fajl!");
		}
	}

	static void pisiUFajlKulturneManifestacije(File dokument) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(dokument));
		for (KulturnaManifestacija kulturnaManifestacija : kulturneManifestacije.values()) {
			out.println(kulturnaManifestacija.toFileRepresentation());
		}

		out.flush();
		out.close();
	}

}
