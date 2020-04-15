
package perpustakaan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InputAnggota extends JFrame{
    String jk;
    
    JLabel ljudul = new JLabel("DATA ANGGOTA");
    JLabel lnim = new JLabel("Nim");
    JLabel lnama = new JLabel("Nama Anggota");
    JLabel lttl = new JLabel("Tanggal Lahir");
    JLabel ljk = new JLabel("Jenis Kelamin");
    JLabel lagama = new JLabel("Agama");
    JLabel lkelas = new JLabel("Kelas");
    JLabel ltgldaftar = new JLabel("Tanggal Daftar");
    JLabel lberlaku = new JLabel("Berlaku Hingga");
    
    JTextField fnim = new JTextField();
    JTextField fnama = new JTextField();
    JTextField fttl = new JTextField();
    JTextField fkelas = new JTextField();
    JTextField ftgldaftar = new JTextField();
    JTextField fberlaku = new JTextField();
    
    JRadioButton rbPria = new JRadioButton(" Laki=laki ");
    JRadioButton rbWanita = new JRadioButton(" Perempuan ");
    
    String[] namaagama =
            {"Islam", "Kristen", "Katolik", "Hindu", "Budha"};
    JComboBox cmbagama = new JComboBox(namaagama);
    
    JButton btnsimpan = new JButton("Simpan");
    JButton btnkeluar = new JButton("Keluar");
    JButton btnhapus = new JButton("Hapus");
    JButton btnrefresh = new JButton("Refresh");
    
    JTable tabel;
    DefaultTableModel tablemodel;
    JScrollPane scrollpane;
    Object namakolom[] = {"NIM", "NAMA", "TANGGAL LAHIR", "JENIS KELAMIN", "AGAMA", "KELAS", "TGL DAFTAR", "TGL BERAKHIR"};    //membuat kolom dengan array tipe objek
    
    public InputAnggota(){
        tablemodel = new DefaultTableModel(namakolom,0);    //0 menandakan jumlah baris
        tabel = new JTable(tablemodel);                     //tabel merupakan variable untuk tabelnya dengan isi tablemodel
        scrollpane = new JScrollPane(tabel);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(1000,600);
        
        ButtonGroup group = new ButtonGroup();
        group.add(rbPria);
        group.add(rbWanita);
        
        add(ljudul);
        add(fnim);
        add(lnim);
        add(fnama);
        add(lnama);
        add(fttl);
        add(lttl);
        add(ljk);
        add(lagama);
        add(fkelas);
        add(lkelas);
        add(ftgldaftar);
        add(ltgldaftar);
        add(fberlaku);
        add(lberlaku);
        add(rbPria);
        add(rbWanita);
        add(cmbagama);
        add(btnsimpan);
        add(btnkeluar);
        add(btnhapus);
        add(btnrefresh);
        
        
        //TABLE
        add(scrollpane);
        scrollpane.setBounds(30, 280, 900, 200);
        scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollpane nya vertical
        
        ljudul.setBounds(400, 20, 150, 30);
        lnim.setBounds(30, 70, 150, 20);
        lnama.setBounds(30, 100, 150, 20);
        lttl.setBounds(30, 130, 150, 20);
        ljk.setBounds(30, 160, 150, 20);
        fnim.setBounds(200, 70, 150, 20);
        fnama.setBounds(200, 100, 150, 20);
        fttl.setBounds(200, 130, 150, 20);
        rbPria.setBounds(200, 160, 150, 20);
        rbWanita.setBounds(200, 180, 150, 20);
        
        lagama.setBounds(400, 70, 150, 20);
        lkelas.setBounds(400, 100, 150, 20);
        ltgldaftar.setBounds(400, 130, 150, 20);
        lberlaku.setBounds(400, 160, 150, 20);
        cmbagama.setBounds(520, 70, 150, 20);
        fkelas.setBounds(520, 100, 150, 20);
        ftgldaftar.setBounds(520, 130, 150, 20);
        fberlaku.setBounds(520, 160, 150, 20);
        
        btnsimpan.setBounds(30, 210, 100, 25);
        btnkeluar.setBounds(160, 210, 100, 25);
        btnhapus.setBounds(280, 210, 100, 25);
        btnrefresh.setBounds(400, 210, 100, 25);
        
        btnkeluar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Beranda beranda = new Beranda();
                dispose();
            }
        });

    }
    public String getnim(){
        return fnim.getText();
    }
    public String getnama(){
        return fnama.getText();
    }
    public String gettl(){
        return fttl.getText();
    }
    public String getkelas(){
        return fkelas.getText();
    }
    public String gettgldaftar(){
        return ftgldaftar.getText();
    }
    public String getberlaku(){
        return fberlaku.getText();
    }
    public String getjk(){
        if(rbPria.isSelected()){
            return rbPria.getText();
        } else {
            return rbWanita.getText();
        }
    }
    public String getagama(){
        return (String)cmbagama.getSelectedItem();
    }
}

