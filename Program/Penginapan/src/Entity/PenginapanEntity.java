/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

public class PenginapanEntity {
    //Entity
    private int lama,jenis;
    private String kd_penyewaan,nama, alamat;

    //Constructor
    public PenginapanEntity(){  
    }
    
    //Getter & Setter
    public int getLama() {
        return lama;
    }

    public void setLama(int lama) {
        this.lama = lama;
    }

    public int getJenis() {
        return jenis;
    }

    public void setJenis(int jenis) {
        this.jenis = jenis;
    }

    public String getKd_penyewaan() {
        return kd_penyewaan;
    }

    public void setKd_penyewaan(String kd_penyewaan) {
        this.kd_penyewaan = kd_penyewaan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
}
