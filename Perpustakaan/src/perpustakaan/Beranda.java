
package perpustakaan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Beranda extends JFrame {
    JButton btni_buku = new JButton("INPUT BUKU");
    JButton btni_anggota = new JButton("INPUT ANGGOTA");
    JButton btni_karyawan = new JButton("INPUT KARYAWAN");
    JButton btnpeminjaman = new JButton("PEMINJAMAN");
    
    public Beranda() {
        setTitle("BERANDA");
        setDefaultCloseOperation(3);
        setSize(450, 250);
        
        btni_anggota.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                MVC_Anggota mvca = new MVC_Anggota();
                dispose();
            }
        });
        btni_karyawan.addActionListener((ActionEvent e)->{
                MVC_Karyawan mvck = new MVC_Karyawan();
                dispose();
        });
        btni_buku.addActionListener((ActionEvent e) -> {
            MVC_Buku mvcb = new MVC_Buku();
            dispose();
        });
        
        btnpeminjaman.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                MVC_Pinjam mvcp = new MVC_Pinjam();
                dispose();
            }
        });
        
        setLayout(null);
        add(btni_anggota);
        add(btni_buku);
        add(btni_karyawan);
        add(btnpeminjaman);
        
        
        btni_anggota.setBounds(30,30,150,50);
        btni_buku.setBounds(210,30,150,50);
        btni_karyawan.setBounds(30,110,150,50);
        btnpeminjaman.setBounds(210,110,150,50);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
