/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psbd.projekt.classes;

/**
 *
 * @author Michal
 */
public class Klient {

    private int id = 0;
    private String imie = null;
    private String nazwisko = null;
    private String e_mail = null;
    private String nr_dowodu;
    private int liczba_pobytow;

    private static Klient instane = new Klient();

    Klient() {

    }
    
    public int getIloscPobytow(){
        return liczba_pobytow;
    }

    public void setDane(int id, String e_mail, String imie, String nazwisko) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.e_mail = e_mail;
    }

    public void setDaneFull(int id, String imie, String nazwisko, String e_mail, String nr_dowodu, int liczba_pobytow) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.e_mail = e_mail;
        this.nr_dowodu = nr_dowodu;
        this.liczba_pobytow = liczba_pobytow;
    }

    public void clearUser() {
        this.id = 0;
        this.imie = null;
        this.nazwisko = null;
        this.e_mail = null;
        this.nr_dowodu = null;
        this.liczba_pobytow = 0;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public int getId() {
        return id;
    }

    public void setImieNazwisko(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public static Klient getInstance() {
        return instane;
    }

    public boolean isZalogowany() {
        if(id == 0){
            return false;
        }else{
            return true;
        }
    }
}
