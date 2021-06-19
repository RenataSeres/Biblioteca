package model;

public class Imprumut {
    private Carti carti;
    private Clienti clienti;
    private int data_imprumut;
    private int data_retur;

    public Imprumut(Carti carti, Clienti clienti, int data_imprumut, int data_retur) {
        this.carti = carti;
        this.clienti = clienti;
        this.data_imprumut = data_imprumut;
        this.data_retur = data_retur;
    }

    public Carti getCarti() {
        return carti;
    }

    public void setCarti(Carti carti) {
        this.carti = carti;
    }

    public Clienti getClienti() {
        return clienti;
    }

    public void setClienti(Clienti clienti) {
        this.clienti = clienti;
    }

    public int getData_imprumut() {
        return data_imprumut;
    }

    public void setData_imprumut(int data_imprumut) {
        this.data_imprumut = data_imprumut;
    }

    public int getData_retur() {
        return data_retur;
    }

    public void setData_retur(int data_retur) {
        this.data_retur = data_retur;
    }
}
