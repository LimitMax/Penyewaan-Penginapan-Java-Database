/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import ErrorHandling.ErrorHandling;

public class HitungSewa extends PenginapanEntity{  
    //Constructor
    public HitungSewa(){
    }
    
    //Pilih jenis kamar
    public String jenisKamar() throws ErrorHandling {
        switch (getJenis()) {
            case 1:
                return "Standard Room";
            case 2:
                return "Twin Room";
            case 3:
                return "Deluxe Room";
            default:
                throw new ErrorHandling();
        }
    }
       
    //Harga kamar
    public int hargaKamar(){
      switch (getJenis()) {
          case 1:
              return 125000;
          case 2:
              return 200000;
          case 3:
              return 450000;
          default:
              return 0;
      }
    }

    //Hitung Total harga
    public int hitungTotal(){
        int total;
        total = hargaKamar()*getLama();
        return total;
    }
    
}
