/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Koneksi {
    //Deklarasi atribut untuk koneksi JDBC
    static final String URL ="jdbc:mysql://localhost/tubespbo";
    static final String USER = "root";
    static final String PASSWORD = "";

    //Object yang diperlukan untuk mengelola basis data
    public static Connection conn;

    public void koneksi(){
        //Melakukan koneksi ke database
        try{
            //Cek driver yang dipakai
            Class.forName("com.mysql.jdbc.Driver");

            //koneksi driver ke database
            conn = DriverManager.getConnection(URL,USER, PASSWORD);
            
        } catch (ClassNotFoundException | SQLException e){
            //Jika gagal konek ke database
            System.out.println("Koneksi Gagal " + e.getMessage());
        }
    }
}
