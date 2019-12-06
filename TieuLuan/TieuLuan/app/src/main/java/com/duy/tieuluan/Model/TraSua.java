package com.duy.tieuluan.Model;

public class TraSua {
    public int Id;
    public String Tendoan;
    public String tencuahang;
    public String gia;
    public String diachi;

    public TraSua(int id, String tendoan, String tencuahang, String gia, String diachi) {
        Id = id;
        Tendoan = tendoan;
        this.tencuahang = tencuahang;
        this.gia = gia;
        this.diachi = diachi;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTendoan() {
        return Tendoan;
    }

    public void setTendoan(String tendoan) {
        Tendoan = tendoan;
    }

    public String getTencuahang() {
        return tencuahang;
    }

    public void setTencuahang(String tencuahang) {
        this.tencuahang = tencuahang;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
