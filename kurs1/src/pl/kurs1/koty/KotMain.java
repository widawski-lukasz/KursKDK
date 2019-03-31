package pl.kurs1.koty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class KotMain {

	static Scanner inputScanner = new Scanner(System.in);
	
	
	public static void main(String[] args){
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
		
		
		System.out.println(kot1.przedstawSie());
	}
	

	public static String getUserInput(){
		return inputScanner.nextLine().trim();
	}
}
