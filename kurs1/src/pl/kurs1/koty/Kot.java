package pl.kurs1.koty;

import java.util.Date;

public class Kot {

	private String imie;
	private Date dataUrodzenia;
	private float waga;
	private String opiekun;
	private static int statID;
	private int ID;
	
	public Kot() {
		statID++;
		this.ID = statID -1;
	}
	
	
	public String getImie(){
		return imie;
	}
	public void setImie(String imie){
		this.imie = imie;
	}
	
	public Date getDataUrodzenia(){
		return dataUrodzenia;
	}
	public void setDataUrodzenia(Date dataUrodzenia){
		this.dataUrodzenia = dataUrodzenia;
	}
	
	public float getWaga(){
		return waga;
	}
	public void setWaga(float waga){
		this.waga = waga;
	}
	
	public String getOpiekun(){
		return opiekun;
	}
	public void setOpiekun(String opiekun){
		this.opiekun = opiekun;
	}
	
	public int getID() {
		return ID;
	}

	
	
	public String przedstawSie(){
		return this.imie + " " + this.opiekun + " " + this.dataUrodzenia;
	}
}
