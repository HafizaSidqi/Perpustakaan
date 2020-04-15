
package perpustakaan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class Karyawan extends JFrame{
    JLabel ljudul = new JLabel("DATA KARYAWAN");
    
    JLabel lnik = new JLabel("Nik");
    JLabel lnama = new JLabel("Nama Karyawan");
    JLabel ljk = new JLabel("Jenis Kelamin");
    JLabel lgolongan = new JLabel("Golongan");
    JLabel ljabatan = new JLabel("Jabatan");
    JLabel ltunjangan = new JLabel("Tunjangan");
    JLabel ljmlgaji = new JLabel("Jumlah Gaji");
    
    JTextField fnik = new JTextField();
    JTextField fnama = new JTextField();
    JTextField fgolongan = new JTextField();
    JTextField fsearch = new JTextField();
    
    JLabel fjabatan = new JLabel();
    JLabel ftunjangan = new JLabel();
    JLabel fjmlgaji = new JLabel();
    
    JRadioButton rbPria = new JRadioButton(" Laki=laki ");
    JRadioButton rbWanita = new JRadioButton(" Perempuan ");
    
    
    JButton btnsimpan = new JButton("Simpan");
    JButton btnkeluar = new JButton("Keluar");
    JButton btnhapus = new JButton("Hapus");
    JButton btnrefresh = new JButton("Refresh");
    JButton btncari = new JButton("Cari");
    
    JTable tabel;
    DefaultTableModel tablemodel;
    JScrollPane scrollpane;
    Object namakolom[] = {"NIK", "NAMA", "JENIS KELAMIN", "GOLONGAN", "JABATAN", "TUNJANGAN", "GAJI"};    //membuat kolom dengan array tipe objek
    
    public Karyawan(){
        tablemodel = new DefaultTableModel(namakolom,0);    //0 menandakan jumlah baris
        tabel = new JTable(tablemodel);                     //tabel merupakan variable untuk tabelnya dengan isi tablemodel
        scrollpane = new JScrollPane(tabel);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(1000,600);
        
        ButtonGroup group = new ButtonGroup();
        group.add(rbPria);
        group.add(rbWanita);
        
        add(ljudul);
        
        add(fnik);
        add(lnik);
        add(fnama);
        add(lnama);
        add(ljk);
        add(fgolongan);
        add(lgolongan);
        add(fjabatan);
        add(ljabatan);
        add(ftunjangan);
        add(ltunjangan);
        add(ljmlgaji);
        add(fjmlgaji);
        add(rbPria);
        add(rbWanita);
        add(btnsimpan);
        add(btnkeluar);
        add(btnhapus);
        add(btnrefresh);
        add(btncari);
        add(fsearch);
        
        
        //TABLE
        add(scrollpane);
        scrollpane.setBounds(30, 280, 900, 200);
        scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollpane nya vertical
        
        ljudul.setBounds(400, 20, 150, 30);
        lnik.setBounds(30, 70, 150, 20);
        lnama.setBounds(30, 100, 150, 20);
        ljk.setBounds(30, 130, 150, 20);
        lgolongan.setBounds(30, 160, 150, 20);
        fnik.setBounds(200, 70, 150, 20);
        fnama.setBounds(200, 100, 150, 20);
        rbPria.setBounds(200, 130, 150, 20);
        rbWanita.setBounds(380, 130, 150, 20);
        fgolongan.setBounds(200, 160, 150, 20);
        ljabatan.setBounds(30, 190, 150, 20);
        ltunjangan.setBounds(30, 210, 150, 20);
        fjabatan.setBounds(200, 190, 150, 20);
        ftunjangan.setBounds(200, 210, 150, 20);
        ljmlgaji.setBounds(30,240, 150, 20);
        fjmlgaji.setBounds(200,240, 150, 20);
        
        btnsimpan.setBounds(450, 160, 100, 25);
        btnhapus.setBounds(570, 160, 100, 25);
        fsearch.setBounds(660, 100, 130, 25);
        btncari.setBounds(800, 100, 100, 25);
        btnkeluar.setBounds(500, 190, 100, 25);
        btnrefresh.setBounds(620, 190, 100, 25);
        
        btnkeluar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Beranda beranda = new Beranda();
                dispose();
            }
        });

    }
    public String getnik(){
        return fnik.getText();
    }
    public String getnama(){
        return fnama.getText();
    }
    public String getjk(){
        if(rbPria.isSelected()){
            return rbPria.getText();
        } else {
            return rbWanita.getText();
        }
    }
    public String getgolongan(){
        return fgolongan.getText();
    }
    public String getjabatan(){
        return fjabatan.getText();
    }
    public String gettunjangan(){
        return ftunjangan.getText();
    }
    public String getjmlgaji(){
        return fjmlgaji.getText();
    }
    public String getsearch() {
        return fsearch.getText();
    }
}
