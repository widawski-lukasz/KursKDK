package pl.kurs1.koty;

import java.util.List;
import java.util.ArrayList;

import pl.kurs1.koty.Kot;


public class KotDAO {

	private List<Kot> lista;
	
	public KotDAO() {
		this.lista = new ArrayList<Kot>();
	}
	
	public void dodajKota(Kot kot) {
		lista.add(kot);
		System.out.println("dodano kota");
	}
}
