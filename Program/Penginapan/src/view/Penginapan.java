/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import Entity.HitungSewa;
import java.util.Scanner;
import repository.PenginapanRepositoryImpl;

/**
 *
 * @author Fix
 */

public class Penginapan {
     public static void main(String[] args) {
        //Panggil object
        Scanner input = new Scanner(System.in);
        //Hitung tes = new Hitung();
        HitungSewa entity = new HitungSewa();
        PenginapanRepositoryImpl menu = new PenginapanRepositoryImpl();
        
        //
        String ulg = "y";
        while (ulg.equalsIgnoreCase("y")) {
            //Menu
            System.out.println("=============================");
            System.out.println("|| Program Sewa Penginapan ||");
            System.out.println("=============================");
            System.out.println("||           MENU          ||");
            System.out.println("=============================");
            System.out.println("|| 1. View Data Penyewa    ||");
            System.out.println("|| 2. Add  Data Penyewa    ||");
            System.out.println("|| 3. Update Data Penyewa  ||");
            System.out.println("|| 4. Delete Data Penyewa  ||");
            System.out.println("|| 0. Close Program        ||");
            System.out.println("=============================");
            System.out.print("Masukan pilihan : ");
            int pil = input.nextInt();
            System.out.println("");
            
            //
            switch(pil){
                case 0: {
                  System.exit(0);
                break;
               }
                
                case 1: {
                   menu.viewPenginapan();
                   break;
               }

               case 2: {   
                   menu.addPenginapan(entity);
                   break;
               }

               case 3: {
                   menu.updatePenginapan(entity);
                   break;
               }

               case 4: {
                   Scanner input3 = new Scanner(System.in);
                   System.out.println("==================================================");
                   System.out.println("||           Menu Delete Data Penyewa           ||");
                   System.out.println("==================================================");
                   System.out.print("  Masukan Kode Pemesanan (Delete): ");
                   entity.setKd_penyewaan(input3.nextLine());
                   menu.deletePenginapan(entity);
                   break;
               }
              
           }
            
            System.out.print("Apakah anda ingin mengulang (y/t)? ");
            ulg = input.next();
        }
       
    }
}
