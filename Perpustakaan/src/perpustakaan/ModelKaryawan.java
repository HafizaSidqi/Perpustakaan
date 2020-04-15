
package perpustakaan;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ModelKaryawan {
    //mengkoneksikan database. model berisi query2
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/praktikum_perpus";    //nama database
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;        //untuk penggunaan query
    
    public ModelKaryawan() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    public void insertKaryawan(String nik, String nama, String jk, String golongan){
        try{
            String query = "INSERT INTO `karyawan`(`nik`, `nama`, `jk`, `golongan`) VALUES ("+nik+", '"+nama+"','"+jk+"',"+golongan+")";
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
    
    /*    public String[][] readJabatan(String golongan) { //dua dimensi(baris-kolom)
    try{
    String query = "Select * from `jabatan` where golongan = "+golongan+"";
    ResultSet resultset = statement.executeQuery(query);
    String data[][] = new String[1][3];
    data[0][0] = resultset.getString("jabatan");
    data[0][1] = resultset.getString("tunjangan");
    data[0][2] = resultset.getString("jmlgaji");
    return data;
    } catch(SQLException e) {
    System.out.println(e.getMessage());
    System.out.println("SQL Error");
    return null;
    }
    }*/
    
    public String[][] readKaryawan() { //dua dimensi(baris-kolom)
        try{
            int jmldata = 0;        //menampung jml data sebanyak jml data yang ada, defaultnya 0
            String data[][] = new String[getBanyakData()][8];   //menampung array, barisnya isinya di getBanyakData, kolomnya itu atribute
            String query = "Select * from `karyawan` inner join `jabatan` on `karyawan`.`golongan`=`jabatan`.`golongan`";
            ResultSet resultset = statement.executeQuery(query);
            while(resultset.next()) {
                int nik = resultset.getInt("nik");
                int golongan = resultset.getInt("golongan");
                
                data[jmldata][0] = Integer.toString(nik);
                data[jmldata][1] = resultset.getString("nama");
                data[jmldata][2] = resultset.getString("jk");
                data[jmldata][3] = Integer.toString(golongan);
                data[jmldata][4] = resultset.getString("jabatan");
                data[jmldata][5] = resultset.getString("tunjangan");
                data[jmldata][6] = resultset.getString("jmlgaji");
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
            String query = "Select * from `karyawan`;";
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
    
    public String[][] searchKaryawan(String cari) {
        try{
            int jmldata = 0;
            String query = "SELECT * FROM `karyawan` inner join `jabatan` on `karyawan`.`golongan`=`jabatan`.`golongan` where nama like '%"+cari+"%'";
            ResultSet resultset = statement.executeQuery(query);
            
            String data[][] = new String[getBanyakData()][8];
            while(resultset.next()) {
                int nik = resultset.getInt("nik");
                
                data[jmldata][1] = Integer.toString(nik);
                data[jmldata][2] = resultset.getString("nama");
                data[jmldata][3] = resultset.getString("jk");
                data[jmldata][4] = resultset.getString("golongan");
                jmldata++;
            }
            return data;
            
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void deleteKaryawan(String nik) {
        try{
            String query = "DELETE FROM `karyawan` WHERE nik = "+nik+"";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        } catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
