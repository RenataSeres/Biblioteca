package model;

import java.util.Date;

public class Carti {
    private int id;
    private String denumire;
    private Autor autor;
    private Genuri genuri;
    private String editura;
    private Date an_aparitie;

    public Carti() {
    }

    public Carti(int id, String denumire, Autor autor, Genuri genuri, String editura, Date an_aparitie) {
        this.id = id;
        this.denumire = denumire;
        this.autor = autor;
        this.genuri = genuri;
        this.editura = editura;
        this.an_aparitie = an_aparitie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Genuri getGenuri() {
        return genuri;
    }

    public void setGenuri(Genuri genuri) {
        this.genuri = genuri;
    }

    public String getEditura() {
        return editura;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

    public Date getAn_aparitie() {
        return an_aparitie;
    }

    public void setAn_aparitie(Date an_aparitie) {
        this.an_aparitie = an_aparitie;
    }

    public void setId() {
    }

    @Override
    public String toString() {
        return "Carti{" +
                "denumire='" + denumire + '\'' +
                ", autor=" + autor +
                ", genuri=" + genuri +
                ", editura='" + editura + '\'' +
                ", an_aparitie=" + an_aparitie +
                '}';
    }
}
