
package perpustakaan;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ModelBuku {
    //mengkoneksikan database. model berisi query2
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/praktikum_perpus";    //nama database
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;        //untuk penggunaan query
    
    public ModelBuku() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    public void insertBuku(String kdbuku, String nmbuku, String nmpengarang, String nmpenerbit, String thnterbit){
        try{
            String query = "INSERT INTO `buku`(`kdbuku`, `nmbuku`, `nmpengarang`, `nmpenerbit`, `thnterbit`) VALUES ('"+kdbuku+"', '"+nmbuku+"','"+nmpengarang+"','"+nmpenerbit+"','"+thnterbit+"')";
            //String `"+string+"` , kalau int "+int+"
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query); //execute query nya
            System.out.println("Berhasil Ditambahkan");
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
        } catch(Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    
    public String[][] readBuku() { //dua dimensi(baris-kolom)
        try{
            int jmldata = 0;        //menampung jml data sebanyak jml data yang ada, defaultnya 0
            String data[][] = new String[getBanyakData()][6];   //menampung array, barisnya isinya di getBanyakData, kolomnya itu atribute
            String query = "Select * from `buku`";
            ResultSet resultset = statement.executeQuery(query);
            while(resultset.next()) {
                int nomer = jmldata+1;
                int kdbuku = resultset.getInt("kdbuku");
                
                data[jmldata][0] = Integer.toString(nomer);
                data[jmldata][1] = Integer.toString(kdbuku);
                data[jmldata][2] = resultset.getString("nmbuku");
                data[jmldata][3] = resultset.getString("nmpengarang");
                data[jmldata][4] = resultset.getString("nmpenerbit");
                data[jmldata][5] = resultset.getString("thnterbit");
                jmldata= jmldata+1;
        }
            return data;
    } catch(SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
    }
}
    public int getBanyakData() {
        int jmldata = 0;
        try{
            statement = (Statement) koneksi.createStatement();
            String query = "Select * from `buku`";
            ResultSet resultset = statement.executeQuery(query);
            while(resultset.next()) {
                jmldata++;
            }
            return jmldata;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    
    public String[][] searchBuku(String cari) {
        try{
            int jmldata = 0;
            String query = "SELECT * FROM `buku` where nmbuku like '%"+cari+"%'";
            ResultSet resultset = statement.executeQuery(query);
            
            String data[][] = new String[getBanyakData()][8];
            while(resultset.next()) {
                int kdbuku = resultset.getInt("kdbuku");
                
                data[jmldata][1] = Integer.toString(kdbuku);
                data[jmldata][2] = resultset.getString("nmbuku");
                data[jmldata][3] = resultset.getString("nmpengarang");
                data[jmldata][4] = resultset.getString("nmpenerbit");
                data[jmldata][5] = resultset.getString("thnterbit");
                jmldata++;
            }
            return data;
            
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void deleteBuku(String kdbuku) {
        try{
            String query = "DELETE FROM `buku` WHERE kdbuku = "+kdbuku+"";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        } catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
