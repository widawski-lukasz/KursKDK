package pl.kurs1.koty;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.lang.Float;
import java.lang.NumberFormatException;

public class KotMain {

static Scanner inputScanner = new Scanner(System.in);
	
	
	public static void main(String[] args){
		Kot kot1 = new Kot();
		
		System.out.println("podaj imie kota");
		kot1.setImie(getUserInput());
		
		System.out.println("Podaj opiekuna");
		kot1.setOpiekun(getUserInput());
		
		System.out.println("Podaj date urodzenia kota (rrrr.mm.dd)");
		kot1.setDataUrodzenia(getDate());
		
		System.out.println("Give weight of a cat");
		kot1.setWaga(getFloat());
		
		System.out.println(kot1.przedstawSie());
	}
	
	public static String getUserInput(){
		return inputScanner.nextLine().trim();
	}
	
	public static Date getDate(){
		Date dataOut = null;
		String dataString = inputScanner.nextLine().trim();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		try{
			dataOut = sdf.parse(dataString);
		}catch (ParseException pe){
			System.out.println("Niepoprawny format daty");
		}
		return dataOut;	
	}
	
	public static float getFloat(){
		float weightFloat=0;
		try{	
			weightFloat = Float.valueOf(getUserInput());
		}catch (NumberFormatException nfe){
			System.out.println("Weight has not appropriate format");
		}
		return weightFloat;
	}
}
