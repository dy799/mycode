package com.duy.tieuluan.Model;

public class Tenshop {
    public int Id;
    public String Tenshop;
    public String Hinhshop;
    public int Gia;
    public String Motafd;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTenshop() {
        return Tenshop;
    }

    public void setTenshop(String tenshop) {
        Tenshop = tenshop;
    }

    public String getHinhshop() {
        return Hinhshop;
    }

    public void setHinhshop(String hinhshop) {
        Hinhshop = hinhshop;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int gia) {
        Gia = gia;
    }

    public String getMotafd() {
        return Motafd;
    }

    public void setMotafd(String motafd) {
        Motafd = motafd;
    }

    public Tenshop(int id, String tenshop, String hinhshop, int gia, String motafd) {
        Id = id;
        Tenshop = tenshop;
        Hinhshop = hinhshop;
        Gia = gia;
        Motafd = motafd;
    }
}
