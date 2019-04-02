package pl.kurs1.koty;

import java.util.List;
import java.util.ArrayList;


public class KotDAO {

	List<Kot> lista;
	
	public KotDAO() {
		this.lista = new ArrayList<Kot>();
	}
	
	public void dodajKota(Kot kot1) {
		lista.add(kot1);
		System.out.println("Dodano kota o numerze: " + kot1.getID());
	}
}
