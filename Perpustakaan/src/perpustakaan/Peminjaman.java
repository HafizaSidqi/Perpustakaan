
package perpustakaan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class Peminjaman extends JFrame{
    JLabel ljudul = new JLabel("DATA PENGEMBALIAN");
    JLabel lnmrpinjam = new JLabel("Nomor Pinjam");
    JLabel lnim = new JLabel("Nim");
    JLabel lnama = new JLabel("Nama Mahasiswa");
    JLabel lkelas = new JLabel("Kelas");
    JLabel lkdbuku = new JLabel("Kode Buku");
    JLabel lnmbuku = new JLabel("Nama Buku");
    JLabel lpenerbit = new JLabel("Nama Penerbit");
    JLabel ltglpinjam = new JLabel("Tanggal Pinjam");
    JLabel ltglkembali = new JLabel("Tanggal Kembali");
    JLabel llmpinjam = new JLabel("Lama Pinjam");
    
    JLabel fnama = new JLabel();
    JLabel fkelas = new JLabel();
    JLabel fnmbuku = new JLabel();
    JLabel fnmpenerbit = new JLabel();
    JLabel flmpinjam = new JLabel();
    
    JTextField fnmrpinjam = new JTextField();
    JTextField fnim = new JTextField();
    JTextField fkdbuku = new JTextField();
    JTextField ftglpinjam = new JTextField();
    JTextField ftglkembali = new JTextField();
    JTextField fsearch = new JTextField();
    
    JLabel ldenda = new JLabel("Denda");
    JLabel lnik = new JLabel("Nik");
    JLabel lnmkaryawan = new JLabel("Karyawan yg bertugas ");
    
    JLabel fdenda = new JLabel();
    JTextField fnik = new JTextField();
    JLabel fnmkaryawan = new JLabel();
    
    JButton btnsimpan = new JButton("Simpan");
    JButton btnhapus = new JButton("Hapus");
    JButton btncari = new JButton("Cari");
    JButton btnkeluar = new JButton("Keluar");
    JButton btnrefresh = new JButton("Refresh");
    
    JTable tabel;
    DefaultTableModel tablemodel;
    JScrollPane scrollpane;
    Object namakolom[] = {"No Pinjam","NIM","Nama", "Kelas", "Kode Buku", "Judul Buku", "Penerbit", "Tgl Pinjam", "Tgl Kembali", "Lama", "Denda","NIK", "Petugas"};    //membuat kolom dengan array tipe objek
    
    public Peminjaman() {
        tablemodel = new DefaultTableModel(namakolom,0);    //0 menandakan jumlah baris
        tabel = new JTable(tablemodel);                     //tabel merupakan variable untuk tabelnya dengan isi tablemodel
        scrollpane = new JScrollPane(tabel);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(1000,800);
        
        add(ljudul);
        add(lnmrpinjam);
        add(lnim);
        add(lnama);
        add(lkelas);
        add(lkdbuku);
        add(fnmrpinjam);
        add(fnim);
        add(fnama);
        add(fkelas);
        add(fkdbuku);
        add(lnmbuku);
        add(lpenerbit);
        add(ltglpinjam);
        add(ltglkembali);
        add(llmpinjam);
        add(fnmbuku);
        add(fnmpenerbit);
        add(ftglpinjam);
        add(ftglkembali);
        add(flmpinjam);
        add(btnsimpan);
        add(btnkeluar);
        add(btnhapus);
        add(btnrefresh);
        add(btncari);
        add(fsearch);
        add(fdenda);
        add(fnik);
        add(fnmkaryawan);
        add(ldenda);
        add(lnik);
        add(lnmkaryawan);
        
        ljudul.setBounds(400, 20, 150, 30);
        
        lnmrpinjam.setBounds(30, 70, 150, 20);
        lnim.setBounds(30, 100, 150, 20);
        lnama.setBounds(30, 130, 150, 20);
        lkelas.setBounds(30, 160, 150, 20);
        lkdbuku.setBounds(30, 190, 150, 20);
        
        fnmrpinjam.setBounds(200, 70, 150, 20);
        fnim.setBounds(200, 100, 150, 20);
        fnama.setBounds(200, 130, 150, 20);
        fkelas.setBounds(200, 160, 150, 20);
        fkdbuku.setBounds(200, 190, 150, 20);
        
        lnmbuku.setBounds(30, 220, 150, 20);
        lpenerbit.setBounds(30, 250, 150, 20);
        ltglpinjam.setBounds(30, 280, 150, 20);
        ltglkembali.setBounds(30, 310, 150, 20);
        llmpinjam.setBounds(30, 340, 150, 20);
        
        fnmbuku.setBounds(200, 220, 150, 20);
        fnmpenerbit.setBounds(200, 250, 150, 20);
        ftglpinjam.setBounds(200, 280, 150, 20);
        ftglkembali.setBounds(200, 310, 150, 20);
        flmpinjam.setBounds(200, 340, 150, 20);
        
        btnsimpan.setBounds(400, 100, 100, 25);
        btnhapus.setBounds(520, 100, 100, 25);
        fsearch.setBounds(660, 100, 130, 25);
        btncari.setBounds(800, 100, 100, 25);
        btnkeluar.setBounds(480, 140, 100, 25);
        btnrefresh.setBounds(600, 140, 100, 25);
        
        ldenda.setBounds(400, 200, 100, 20);
        lnik.setBounds(400, 230, 100, 20);
        lnmkaryawan.setBounds(400, 260, 150, 20);
        
        fdenda.setBounds(600, 200, 100, 20);
        fnik.setBounds(600, 230, 100, 20);
        fnmkaryawan.setBounds(600, 260, 100, 20);
        
        //TABLE
        add(scrollpane);
        scrollpane.setBounds(30, 360, 900, 300);
        scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollpane nya vertical
        
        btnkeluar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Beranda beranda = new Beranda();
                dispose();
            }
        });
    }
    public String getnmrpinjam(){
        return fnmrpinjam.getText();
    }
    public String getnim(){
        return fnim.getText();
    }
    public String getkdbuku(){
        return fkdbuku.getText();
    }
    public String gettglpinjam(){
        return ftglpinjam.getText();
    }
    public String gettglkembali(){
        return ftglkembali.getText();
    }
    public String getnik(){
        return fnik.getText();
    }
    public String getsearch(){
        return fsearch.getText();
    }
}
