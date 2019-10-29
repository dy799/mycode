package com.duy.tieuluan.Model;

public class Tenshop {
    public int Id;
    public String Tenshop;
    public String Hinhshop;

    public Tenshop(int id, String tenshop, String hinhshop) {
        Id = id;
        Tenshop = tenshop;
        Hinhshop = hinhshop;
    }

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
}
