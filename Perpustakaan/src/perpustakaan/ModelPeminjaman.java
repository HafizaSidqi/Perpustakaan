
package perpustakaan;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ModelPeminjaman {
    //mengkoneksikan database. model berisi query2
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/praktikum_perpus";    //nama database
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;        //untuk penggunaan query
    
    public ModelPeminjaman() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    public void insertPinjam(String nmrpinjam, String nim, String kdbuku, String tglpinjam, String tglkembali, String nik){
        try{
            String query = "INSERT INTO `pinjam`(`nmrpinjam`, `nim`, `kdbuku`, `tglpinjam`,`tglkembali`,`nik`) VALUES ("+nmrpinjam+", '"+nim+"','"+kdbuku+"','"+tglpinjam+"','"+tglkembali+"',"+nik+")";
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
    
    
    public String[][] readPinjam() { //dua dimensi(baris-kolom)
        try{
            
            int jmldata = 0;        //menampung jml data sebanyak jml data yang ada, defaultnya 0
            String data[][] = new String[getBanyakData()][13];   //menampung array, barisnya isinya di getBanyakData, kolomnya itu atribute
            String query = "Select `pinjam`.`nmrpinjam`, `anggota`.`nim`,`anggota`.`nama`, `anggota`.`kelas`,`buku`.`kdbuku`,`buku`.`nmbuku`,`buku`.`nmpenerbit`,`tglpinjam`,`tglkembali`,`karyawan`.`nik`,`karyawan`.`nama`from `pinjam` inner join `anggota` on `anggota`.`nim`=`pinjam`.`nim` inner join `buku` on `pinjam`.`kdbuku`=`buku`.`kdbuku` inner join `karyawan` on `pinjam`.`nik`=`karyawan`.`nik`";
            ResultSet resultset = statement.executeQuery(query);
            
            while(resultset.next()) {
                int nmrpinjam = resultset.getInt("nmrpinjam");
                int nim = resultset.getInt("nim");
                int kdbuku = resultset.getInt("kdbuku");
                int nik = resultset.getInt("nik");
                
                String tglpinjam = resultset.getString("tglpinjam");
            String tglkembali = resultset.getString("tglkembali");
            Date tglminjam = (Date)Date.valueOf(tglpinjam);
            Date tglbalik = (Date)Date.valueOf(tglkembali);
                    
            long lama = Math.abs(tglminjam.getTime()-tglbalik.getTime());
            long denda = (lama-7)*1000;
                
                data[jmldata][0] = Integer.toString(nmrpinjam);
                data[jmldata][1] = Integer.toString(nim);
                data[jmldata][2] = resultset.getString("nama");
                data[jmldata][3] = resultset.getString("kelas");
                data[jmldata][4] = Integer.toString(kdbuku);
                data[jmldata][5] = resultset.getString("nmbuku");
                data[jmldata][6] = resultset.getString("nmpenerbit");
                data[jmldata][7] = resultset.getString("tglpinjam");
                data[jmldata][8] = resultset.getString("tglkembali");
                data[jmldata][9] = Integer.toString((int) lama);
                data[jmldata][10] = Integer.toString((int) denda);
                data[jmldata][11] = Integer.toString(nik);
                data[jmldata][12] = resultset.getString("nama");
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
            String query = "Select * from `pinjam`";
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
    
    public String[][] searchPinjam(String cari) {
        try{
            int jmldata = 0;
            String query = "SELECT * FROM `pinjam` inner join `anggota` on `anggota`.`nim`=`pinjam`.`nim` inner join `buku` on `pinjam`.`kdbuku`=`buku`.`kdbuku` inner join `karyawan` on `pinjam`.`nik`=`karyawan`.`nik` where `anggota`.`nama` like '%"+cari+"%'";
            ResultSet resultset = statement.executeQuery(query);
            
            String data[][] = new String[getBanyakData()][13];
            while(resultset.next()) {
                int nik = resultset.getInt("nik");
                int nmrpinjam = resultset.getInt("nmrpinjam");
                int nim = resultset.getInt("nim");
                int kdbuku = resultset.getInt("kdbuku");
                
                String tglpinjam = resultset.getString("tglpinjam");
            String tglkembali = resultset.getString("tglkembali");
            Date tglminjam = (Date)Date.valueOf(tglpinjam);
            Date tglbalik = (Date)Date.valueOf(tglkembali);
                    
            long lama = Math.abs(tglminjam.getTime()-tglbalik.getTime());
            long denda = (lama-7)*1000;
                
                data[jmldata][0] = Integer.toString(nmrpinjam);
                data[jmldata][1] = Integer.toString(nim);
                data[jmldata][2] = resultset.getString("nama");
                data[jmldata][3] = resultset.getString("kelas");
                data[jmldata][4] = Integer.toString(kdbuku);
                data[jmldata][5] = resultset.getString("nmbuku");
                data[jmldata][6] = resultset.getString("nmpenerbit");
                data[jmldata][7] = resultset.getString("tglpinjam");
                data[jmldata][8] = resultset.getString("tglkembali");
                data[jmldata][9] = Integer.toString((int) lama);
                data[jmldata][10] = Integer.toString((int) denda);
                data[jmldata][11] = Integer.toString(nik);
                data[jmldata][12] = resultset.getString("nama");
                jmldata= jmldata+1;
            }
            return data;
            
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void deletePinjam(String nmrpinjam) {
        try{
            String query = "DELETE FROM `pinjam` WHERE nmrpinjam = "+nmrpinjam+"";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        } catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
