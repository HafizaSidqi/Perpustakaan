
package perpustakaan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Buku extends JFrame{
    JLabel ljudul = new JLabel("DATA BUKU");
    
    JLabel lkdbuku = new JLabel("Kode Buku");
    JLabel lnmbuku = new JLabel("Nama Buku");
    JLabel lnmpengarang = new JLabel("Nama Pengarang");
    JLabel lnmpenerbit = new JLabel("Nama Penerbit");
    JLabel lthnterbit = new JLabel("Tahun Terbit");
    
    JTextField fkdbuku = new JTextField();
    JTextField fnmbuku = new JTextField();
    JTextField fnmpengarang = new JTextField();
    JTextField fnmpenerbit = new JTextField();
    JTextField fthnterbit= new JTextField();
    JTextField fcari = new JTextField();
    
    JButton btnsimpan = new JButton("Simpan");
    JButton btnhapus = new JButton("Hapus");
    JButton btncari = new JButton("Cari");
    JButton btnkeluar = new JButton("Keluar");
    JButton btnrefresh = new JButton("Refresh");
    
    JTable tabel;
    DefaultTableModel tablemodel;
    JScrollPane scrollpane;
    Object namakolom[] = {"#","Kode Buku","Judul Buku", "Pengarang", "Penerbit", "Tahun Terbit"};    //membuat kolom dengan array tipe objek
    
    public Buku(){
        tablemodel = new DefaultTableModel(namakolom,0);    //0 menandakan jumlah baris
        tabel = new JTable(tablemodel);                     //tabel merupakan variable untuk tabelnya dengan isi tablemodel
        scrollpane = new JScrollPane(tabel);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(1000,600);
        
        add(ljudul);
        add(lkdbuku);
        add(fkdbuku);
        add(lnmbuku);
        add(fnmbuku);
        add(lnmpengarang);
        add(fnmpengarang);
        add(lnmpenerbit);
        add(fnmpenerbit);
        add(lthnterbit);
        add(fthnterbit); 
        add(btnsimpan);
        add(btnkeluar);
        add(btnhapus);
        add(btnrefresh);
        add(btncari);
        add(fcari);
        
        
        ljudul.setBounds(400, 20, 150, 30);
        
        lkdbuku.setBounds(30, 70, 150, 20);
        lnmbuku.setBounds(30, 100, 150, 20);
        lnmpengarang.setBounds(30, 130, 150, 20);
        lnmpenerbit.setBounds(30, 160, 150, 20);
        lthnterbit.setBounds(30, 190, 150, 20);
        
        fkdbuku.setBounds(200, 70, 150, 20);
        fnmbuku.setBounds(200, 100, 150, 20);
        fnmpengarang.setBounds(200, 130, 150, 20);
        fnmpenerbit.setBounds(200, 160, 150, 20);
        fthnterbit.setBounds(200, 190, 150, 20);
        
        btnsimpan.setBounds(400, 100, 100, 25);
        btnhapus.setBounds(520, 100, 100, 25);
        fcari.setBounds(660, 100, 130, 25);
        btncari.setBounds(800, 100, 100, 25);
        btnkeluar.setBounds(480, 140, 100, 25);
        btnrefresh.setBounds(600, 140, 100, 25);
        
        //TABLE
        add(scrollpane);
        scrollpane.setBounds(30, 250, 900, 300);
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
    public String getkdbuku(){
        return fkdbuku.getText();
    }
    public String getnmbuku(){
        return fnmbuku.getText();
    }
    public String getnmpengarang(){
        return fnmpengarang.getText();
    }
    public String getnmpenerbit(){
        return fnmpenerbit.getText();
    }
    public String getthnterbit(){
        return fthnterbit.getText();
    }
    public String getsearch(){
        return fcari.getText();
    }
}

