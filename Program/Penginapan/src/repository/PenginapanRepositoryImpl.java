/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import Entity.HitungSewa;
import Koneksi.Koneksi;
import Entity.PenginapanEntity;
import java.sql.*;
import java.util.Scanner;
import ErrorHandling.ErrorHandling;

public class PenginapanRepositoryImpl implements PenginapanRepository {
    
    //Panggil object PenginapanEntity
    HitungSewa tes = new HitungSewa();
    
    //Menu view Data PenginapanEntity
    @Override
    public void viewPenginapan() {
        //panggil koneksi
        koneksi.koneksi();
        
        //Menu Tampil Penyewaan
        System.out.println("==================================================");
        System.out.println("||                  Data Penyewa                ||");
        System.out.println("==================================================");
        
        //perintah menampilkan data buku
        String sql = "SELECT * FROM penginapan";
        
        try{
            //Object statement dan result 
            Statement stmt;
            ResultSet rs;
            
            //Object statement untuk melakukan query ke database
            stmt = Koneksi.conn.createStatement();
            
            //query ditampung di result statement
            rs = stmt.executeQuery(sql);
            
            //Menampilkan data dari seluruh tabel penginapan
            while(rs.next()){
                System.out.println("Kode Penyewaan     : "+rs.getString("kd_pemesanan"));
                System.out.println("Nama               : "+rs.getString("nama"));
                System.out.println("Alamat             : "+rs.getString("alamat"));
                System.out.println("Jenis kamar        : "+rs.getString("jenis_kamar"));
                System.out.println("Tarif              : "+rs.getString("harga"));
                System.out.println("Lama Menginap      : "+rs.getString("lama"));
                System.out.println("Total              : "+rs.getString("total"));
                System.out.println("==================================================");
            }     
            stmt.close();
            
        } catch (SQLException e){
            System.out.println("Koneksi Gagal");
        }   
    }

    //Menu Tambah data PenginapanEntity
    @Override
    public void addPenginapan(PenginapanEntity penginapan) {
        //panggil koneksi
        koneksi.koneksi();
        
        //Ambil Object Scanner
        Scanner input2 = new Scanner(System.in);
        
        //Menu Tambah Data
        System.out.println("==================================================");
        System.out.println("||           Menu Tambah Data Penyewa           ||");
        System.out.println("==================================================");
        System.out.print("  Masukkan Kode Pemesanan       : ");
        tes.setKd_penyewaan(input2.nextLine());
        System.out.print("  Masukkan Nama Pemesan         : ");
        tes.setNama(input2.nextLine());
        System.out.print("  Masukan Alamat Pemesan        : ");
        tes.setAlamat(input2.nextLine());

        //Pilih Jenis Kamar
        System.out.println("  Pilih Jenis Kamar");
        System.out.println("  1. Standard Room Rp 125.000/malam");
        System.out.println("  2. Twin Room     Rp 200.000/malam");
        System.out.println("  3. Deluxe Room   Rp 450.000/malam");
        System.out.print("  Jenis kamar yang dipesan      : ");
        tes.setJenis(input2.nextInt());

        //Input Lama Menginap
        System.out.print("  Masukkan lama menginap (Malam): ");
        tes.setLama(input2.nextInt()); 
        
        //perintah untuk menambahkan data penginapan
        String sql = "INSERT INTO penginapan(kd_pemesanan,nama,alamat,jenis_kamar,lama,harga,total) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try{
            //Object PreparedStatement
            PreparedStatement tambah;
            
            //Menggunakan object PreparedStatement untuk query
            tambah = Koneksi.conn.prepareStatement(sql);
            tambah.setString(1, tes.getKd_penyewaan());
            tambah.setString(2, tes.getNama());
            tambah.setString(3, tes.getAlamat());
            
            //Cek apakah jenis kamar tersedia atau tidak
            try {
                tambah.setString(4, tes.jenisKamar());
            } catch (ErrorHandling e) {
                System.out.println(e.getMessage());
            }
            
            tambah.setInt(5, tes.getLama());
            tambah.setInt(6, tes.hargaKamar());
            tambah.setInt(7, tes.hitungTotal());
            int i = tambah.executeUpdate();
            
            //Jika berhasil akan menampilkan
            System.out.println("");
            System.out.println("==================================================");
            System.out.println("||     " + i + "     Data berhasil ditambahkan          ||");
            System.out.println("==================================================");
            System.out.println("");
            tambah.close();
            
        }catch(SQLException e){
            System.out.println("");
            System.out.println("Tambah Data Gagal " + e.getMessage());
        }
    }

    //Menu Tambah data PenginapanEntity
    @Override
    public void deletePenginapan(PenginapanEntity penginapan) {
        //panggil koneksi
        koneksi.koneksi();
        
        //perintah untuk delete penginapan
        String sql = "DELETE FROM penginapan WHERE kd_pemesanan = ?";
        
        try{
            //Object PreparedStatement
            PreparedStatement hapus;
            
            //Menggunakan object statement hapus untuk melakukan query penghapusan
            hapus = Koneksi.conn.prepareStatement(sql);
            hapus.setString(1, penginapan.getKd_penyewaan());
            int i = hapus.executeUpdate();
            
            //Jika berhasil akan menampilkan
            System.out.println("");
            System.out.println("==================================================");
            System.out.println("||      " + i + "      Data Berhasil Di HAPUS           ||");
            System.out.println("==================================================");
            hapus.close();
            
        }catch (SQLException e){
            System.out.println("");
            System.out.println("Hapus Data Failed " + e.getMessage());
        }
    }

    //Menu Update data PenginapanEntity
    @Override
    public void updatePenginapan(PenginapanEntity penginapan) {
        //Panggil koneksi
        koneksi.koneksi();
        
         //Ambil Object Scanner
        Scanner input4 = new Scanner(System.in);
        
        //Menu Tambah Data
        System.out.println("==================================================");
        System.out.println("||           Menu Update Data Penyewa           ||");
        System.out.println("==================================================");
        System.out.print("  Masukkan Kode Pemesanan (Edit): ");
        tes.setKd_penyewaan(input4.nextLine());
        System.out.print("  Masukkan Nama Pemesan         : ");
        tes.setNama(input4.nextLine());
        System.out.print("  Masukan Alamat Pemesan        : ");
        tes.setAlamat(input4.nextLine());

        //Pilih Jenis Kamar
        System.out.println("  Pilih Jenis Kamar");
        System.out.println("  1. Standard Room Rp 125.000/malam");
        System.out.println("  2. Twin Room     Rp 200.000/malam");
        System.out.println("  3. Deluxe Room   Rp 450.000/malam");
        System.out.print("  Jenis kamar yang dipesan      : ");
        tes.setJenis(input4.nextInt());
        
        //Input Lama Menginap
        System.out.print("  Masukkan lama menginap (Malam): ");
        tes.setLama(input4.nextInt());  
        
        //perintah untuk UPDATE data penginapan
        String sql = "UPDATE penginapan SET nama = ? , "
                + "alamat = ? ,jenis_kamar = ?, lama = ?, harga = ?, total = ? "
                + "WHERE kd_pemesanan = ?";

        
        try {
            //Object PreparedStatement
            PreparedStatement update;
            
            //Menggunakan object PreparedStatement untuk query
            update = Koneksi.conn.prepareStatement(sql);
            update.setString(1, tes.getNama());
            update.setString(2, tes.getAlamat());
            
            //Cek apakah jenis kamar tersedia atau tidak
            try {
                update.setString(3, tes.jenisKamar());
            } catch (ErrorHandling e) {
                System.out.println(e.getMessage());
            }
            
            update.setInt(4, tes.getLama());
            update.setInt(5, tes.hargaKamar());
            update.setInt(6, tes.hitungTotal());
            update.setString(7, tes.getKd_penyewaan());
            int i = update.executeUpdate();
            
            //Jika berhasil akan menampilkan
            System.out.println("");
            System.out.println("==================================================");
            System.out.println("||      " + i + "      Data Berhasil Di UPDATE          ||");
            System.out.println("==================================================");
            System.out.println("");
            update.close();

        } catch (SQLException e) {
            System.out.println("");
            System.out.println("Update Data Gagal " + e.getMessage());
        }
         
    }
    
}
