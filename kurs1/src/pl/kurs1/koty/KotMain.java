package pl.kurs1.koty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class KotMain {

	static Scanner inputScanner = new Scanner(System.in);
	static KotDAO listaKotow = new KotDAO();
	
	
	public static void main(String[] args){
	
		
		int menuFlag = 0;
		Pattern wzorzecMenu = Pattern.compile("[1-3]{1}");
		String menuWybor;
		
		
		do {
			System.out.println("Menu: \n 1.Dodaj kota \n 2.Wypisz kota \n 3.Wyjœcie");
			menuWybor = getUserInput();
			if(wzorzecMenu.matcher(menuWybor).matches()) {
				menuFlag = 1;
			}	
		
		if(menuWybor.equals("1")) {
			dodawanieKotow();
		}
		else if (menuWybor.equals("2")){
			if(listaKotow.lista.size() == 0 ) {
				System.out.println("Lista jest pusta");
				System.exit(0);
			}
			System.out.println("Którego kota chcesz wybraæ?");
			for (Kot petla : listaKotow.lista) {
				System.out.println(petla.getID() + ": " + petla.getImie());
			}
			String kotWybor = getUserInput();
			Pattern wzorzecWyborKota = Pattern.compile("[0-9]+");
			if(wzorzecWyborKota.matcher(kotWybor).matches()) {
				int kotWyborInt = Integer.parseInt(kotWybor);
				Kot wybranyKot = listaKotow.lista.get(kotWyborInt);
				System.out.println("Wybrany kot to: " + wybranyKot.przedstawSie());
			} else {
				System.out.println("Nie znaleziono kota o tym numerze");
			}	
	} else if (menuWybor.equals("3")){
		System.exit(0);
	}
	} while (!menuWybor.equals("3"));
	}
		
	private static void dodawanieKotow() {
		
		Kot kot1 = new Kot();
		System.out.println("Give name of a cat");
		kot1.setImie(getUserInput());
		
		System.out.println("Give owner");
		kot1.setOpiekun(getUserInput());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Pattern wzorzecDaty = Pattern.compile("[0-9]{4}.[0-1]?[0-9].[0-3]?[0-9]");
		do {
			System.out.println("Give birt-date of a cat (rrrr.mm.dd)");
			String dataInput = getUserInput();
			if(wzorzecDaty.matcher(dataInput).matches()) {
				try {
					kot1.setDataUrodzenia(sdf.parse(dataInput));
				}catch (ParseException pe) {
					System.out.println("Date has not appropriate format");
				}
			}
		} while (kot1.getDataUrodzenia() == null);
		
		
		Pattern wzorzecWagi = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        String wagaWczytana;
        int waga = 0;
        do {
            System.out.print("Podaj wagê kota: ");
            wagaWczytana = getUserInput();
            
            if (wzorzecWagi.matcher(wagaWczytana).matches()) {
                kot1.setWaga(Float.valueOf(wagaWczytana));
                waga = 1;
            }
        } while (waga == 0);
		
		listaKotow.dodajKota(kot1);
		
	}
	
	public static String getUserInput(){
		return inputScanner.nextLine().trim();
	}
}
