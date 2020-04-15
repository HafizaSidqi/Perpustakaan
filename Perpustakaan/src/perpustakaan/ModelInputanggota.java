
package perpustakaan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ModelInputanggota {
    //mengkoneksikan database. model berisi query2
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/praktikum_perpus";    //nama database
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;        //untuk penggunaan query
    
    public ModelInputanggota() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    public void insertAnggota(String nim, String nama, String ttl, String jk, String agama, String kelas, String tgldaftar, String berlaku){
        try{
            String query = "INSERT INTO `anggota`(`nim`, `nama`, `tgl_lahir`, `jk`, `agama`, `kelas`, `tgl_daftar`,`berlaku_hg`) VALUES ("+nim+", '"+nama+"','"+ttl+"','"+jk+"','"+agama+"','"+kelas+"','"+tgldaftar+"' ,'"+berlaku+"')";
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
    
    
    public String[][] readAnggota() { //dua dimensi(baris-kolom)
        try{
            int jmldata = 0;        //menampung jml data sebanyak jml data yang ada, defaultnya 0
            String data[][] = new String[getBanyakData()][8];   //menampung array, barisnya isinya di getBanyakData, kolomnya itu atribute
            String query = "Select * from `anggota`;";
            ResultSet resultset = statement.executeQuery(query);
            while(resultset.next()) {
                
                data[jmldata][0] = resultset.getString("nim");
                data[jmldata][1] = resultset.getString("nama");
                data[jmldata][2] = resultset.getString("tgl_lahir");
                data[jmldata][3] = resultset.getString("jk");
                data[jmldata][4] = resultset.getString("agama");
                data[jmldata][5] = resultset.getString("kelas");
                data[jmldata][6] = resultset.getString("tgl_daftar");
                data[jmldata][7] = resultset.getString("berlaku_hg");
                jmldata++;
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
            String query = "Select * from `anggota`";
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
    public void deleteAnggota(String nim) {
        try{
            String query = "DELETE FROM `anggota` WHERE nim = "+nim+"";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        } catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
