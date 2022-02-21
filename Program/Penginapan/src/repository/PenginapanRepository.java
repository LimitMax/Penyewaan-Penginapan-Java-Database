/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;
import Entity.PenginapanEntity;
import Koneksi.Koneksi;

public interface PenginapanRepository {
    //Add koneksi
    Koneksi koneksi = new Koneksi();
    
    //Interface
    public void viewPenginapan();
    
    public void addPenginapan(PenginapanEntity penginapan);
    
    public void deletePenginapan(PenginapanEntity penginapan);
    
    public void updatePenginapan(PenginapanEntity penginapan);
}
