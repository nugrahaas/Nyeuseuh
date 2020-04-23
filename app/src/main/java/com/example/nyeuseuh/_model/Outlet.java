package com.example.nyeuseuh._model;

public class Outlet {

    String id, namaOutlet, alamatOutlet, notelpOutlet;

    public Outlet(String id, String namaOutlet, String alamatOutlet, String notelpOutlet) {
        this.id = id;
        this.namaOutlet = namaOutlet;
        this.alamatOutlet = alamatOutlet;
        this.notelpOutlet = notelpOutlet;
    }

    public Outlet() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaOutlet() {
        return namaOutlet;
    }

    public void setNamaOutlet(String namaOutlet) {
        this.namaOutlet = namaOutlet;
    }

    public String getAlamatOutlet() {
        return alamatOutlet;
    }

    public void setAlamatOutlet(String alamatOutlet) {
        this.alamatOutlet = alamatOutlet;
    }

    public String getNotelpOutlet() {
        return notelpOutlet;
    }

    public void setNotelpOutlet(String notelpOutlet) {
        this.notelpOutlet = notelpOutlet;
    }

}
