package pomocne.klase;

import java.util.Comparator;
import java.util.Scanner;

import klase.KulturnaManifestacija;

public class PomocneKlase {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static int ceoBroj() {
		while(sc.hasNextInt() == false) {
			System.out.println("Niste uneli ceo broj");
			sc.nextLine();
		}
		int ceoBroj = sc.nextInt();
		sc.nextLine();
		return ceoBroj;
	}
	
	public static String tekst() {
		String tekst = "";
		while(tekst == null || tekst.equals("")) {
			tekst = sc.nextLine();
		}
		return tekst;
	}
	
	public class KulturneManifestacijePoredjenjePoImenu implements Comparator<KulturnaManifestacija>{

		int direction = 1;
		
		public KulturneManifestacijePoredjenjePoImenu(int direction) {
			if(direction!=1 && direction!=-1){
				direction = 1;
			}
			this.direction = direction;
		}

		@Override
		public int compare(KulturnaManifestacija ob1, KulturnaManifestacija ob2) {
			int retVal = 0;
			if(ob1!= null && ob2!=null){
				retVal = ob1.getNaziv().compareTo(ob2.getNaziv());
			}
			return retVal * direction;
		}
	}

}
