package meniji;

import java.io.File;
import java.io.IOException;

import pomocne.klase.PomocneKlase;

public class GlavniMeni {
	
	public static void ispisiMeni() {
		System.out.println("Glavni meni - opcije:");
		System.out.println("0. Kraj rada");
		System.out.println("1. Rad sa gradovima");
		System.out.println("2. Rad sa kulturnim manifestacijama");
	}

	public static void main(String[] args) throws IOException {
		
		String sP = System.getProperty("file.separator");
		
		File gradoviFajl = new File("."+sP+"data"+sP+"gradovi.csv");
		MeniGrad.citajIzFajlaGradove(gradoviFajl);
		
		File kulturneManifestacijeFajl = new File("."+sP+"data"+sP+"kulturneManifestacije.csv");
		MeniKulturnaManifestacija.citajIzFajlaKulturneManifestacije(kulturneManifestacijeFajl);
		
		int opcija = -1;
		while(opcija != 0) {
			GlavniMeni.ispisiMeni();
			System.out.println("Unesite opciju:");
			opcija = PomocneKlase.ceoBroj();
			switch(opcija) {
				case 0:
					break;
				case 1:
					MeniGrad.meniGrad();
					break;
				case 2:
					MeniKulturnaManifestacija.meniKulturnaManifestacija();
					break;
				default:
					System.out.println("Uneli ste nepostojecu opciju");
			}
		}
		
		MeniGrad.pisiUFajlGradove(gradoviFajl);
		MeniKulturnaManifestacija.pisiUFajlKulturneManifestacije(kulturneManifestacijeFajl);
		
	}

}
