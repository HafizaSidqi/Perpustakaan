package perpustakaan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import javax.swing.*;

public class ControllerPinjam {
    //pernatara model dan view
    ModelPeminjaman modelpeminjaman;
    Peminjaman peminjaman;
    String dataterpilih;
    
    public ControllerPinjam(ModelPeminjaman modelpeminjaman, Peminjaman peminjaman) {
        this.peminjaman = peminjaman;
        this.modelpeminjaman = modelpeminjaman;
        
        if (modelpeminjaman.getBanyakData() != 0) {
            String datapeminjaman[][] = modelpeminjaman.readPinjam();
            peminjaman.tabel.setModel((new JTable(datapeminjaman, peminjaman.namakolom)).getModel());
            
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        peminjaman.btnsimpan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (peminjaman.getnmrpinjam().equals("")
                        || peminjaman.getnim().equals("")
                        || peminjaman.getkdbuku().equals("")
                        || peminjaman.gettglpinjam().equals("")
                        || peminjaman.gettglkembali().equals("")
                        || peminjaman.getnik().equals("")) {
                    JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
                } else {
                    String nmrpinjam = peminjaman.getnmrpinjam();
                    String nim = peminjaman.getnim();
                    String kdbuku = peminjaman.getkdbuku();
                    String tglpinjam = peminjaman.gettglpinjam();
                    String tglkembali = peminjaman.gettglkembali();
                    String nik = peminjaman.getnik();
                    
                    modelpeminjaman.insertPinjam(nmrpinjam, nim, kdbuku, tglpinjam, tglkembali,nik);
                    
                    //untuk menampilkan output langsung tanpa reload
                    String datapeminjaman[][] = modelpeminjaman.readPinjam();
                    peminjaman.tabel.setModel(new JTable(datapeminjaman,peminjaman.namakolom).getModel());
                }
            }
        });
        peminjaman.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int baris = peminjaman.tabel.getSelectedRow();
                int kolom = peminjaman.tabel.getSelectedColumn();
                //mengambil nmyang ada di kolom indeks 0
                dataterpilih = peminjaman.tabel.getValueAt(baris, 0).toString();
                
            }
        });
        
        peminjaman.btnhapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //konfirmsi untuk menghapus
                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus buku "+dataterpilih+"?", "Pilih Opsi...", JOptionPane.YES_NO_CANCEL_OPTION);
                
                if(input==0) {
                    modelpeminjaman.deletePinjam(dataterpilih);
                    //untuk menampilkan output langsung tanpa reload
                    String datapeminjaman[][] = modelpeminjaman.readPinjam();
                    peminjaman.tabel.setModel(new JTable(datapeminjaman, peminjaman.namakolom).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });
        
        peminjaman.btnrefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                peminjaman.fnmrpinjam.setText("");
                peminjaman.fnim.setText("");
                peminjaman.fkdbuku.setText("");
                peminjaman.ftglpinjam.setText("");
                peminjaman.ftglkembali.setText("");
                peminjaman.fnik.setText("");
                String datapeminjaman[][] = modelpeminjaman.readPinjam();
                peminjaman.tabel.setModel(new JTable(datapeminjaman, peminjaman.namakolom).getModel());
            }
        });
        peminjaman.btncari.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String cari = peminjaman.getsearch();
                
                modelpeminjaman.searchPinjam(cari);
                
                String datapeminjaman[][]= modelpeminjaman.searchPinjam(cari);
                peminjaman.tabel.setModel((new JTable(datapeminjaman, peminjaman.namakolom)).getModel());
                
            }
        });
        
    }
}