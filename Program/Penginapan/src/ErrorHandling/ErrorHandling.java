/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ErrorHandling;


public class ErrorHandling extends Exception{
    //Penanganan Error jika jenis kamar tidak tersedia
    @Override
     public String getMessage(){
         System.out.println("");
         return "Jenis Kamar Tidak Tersedia";
     }
}
