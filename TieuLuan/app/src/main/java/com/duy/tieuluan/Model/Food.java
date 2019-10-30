package com.duy.tieuluan.Model;

public class Food {
    public int ID;
    public String Tenfood;
    public Integer Giafood;
    public String Hinhfood;
    public String Motafood;
    public int IDfood;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenfood() {
        return Tenfood;
    }

    public void setTenfood(String tenfood) {
        Tenfood = tenfood;
    }

    public Integer getGiafood() {
        return Giafood;
    }

    public void setGiafood(Integer giafood) {
        Giafood = giafood;
    }

    public String getHinhfood() {
        return Hinhfood;
    }

    public void setHinhfood(String hinhfood) {
        Hinhfood = hinhfood;
    }

    public String getMotafood() {
        return Motafood;
    }

    public void setMotafood(String motafood) {
        Motafood = motafood;
    }

    public int getIDfood() {
        return IDfood;
    }

    public void setIDfood(int IDfood) {
        this.IDfood = IDfood;
    }

    public Food(int ID, String tenfood, Integer giafood, String hinhfood, String motafood, int IDfood) {
        this.ID = ID;
        Tenfood = tenfood;
        Giafood = giafood;
        Hinhfood = hinhfood;
        Motafood = motafood;
        this.IDfood = IDfood;

    }
}