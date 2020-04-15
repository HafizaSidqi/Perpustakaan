package perpustakaan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class ControllerBuku {
    //pernatara model dan view
    ModelBuku modelbuku;
    Buku buku;
    String dataterpilih;
    
    public ControllerBuku(ModelBuku modelbuku, Buku buku) {
        this.buku = buku;
        this.modelbuku = modelbuku;
        
        if (modelbuku.getBanyakData() != 0) {
            String databuku[][] = modelbuku.readBuku();
            buku.tabel.setModel((new JTable(databuku, buku.namakolom)).getModel());
            
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        buku.btnsimpan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buku.getkdbuku().equals("")
                        || buku.getnmbuku().equals("")
                        || buku.getnmpengarang().equals("")
                        || buku.getnmpenerbit().equals("")
                        || buku.getthnterbit().equals("")) {
                    JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
                } else {
                    String kdbuku = buku.getkdbuku();
                    String nmbuku = buku.getnmbuku();
                    String nmpengarang = buku.getnmpengarang();
                    String nmpenerbit = buku.getnmpenerbit();
                    String thnterbit = buku.getthnterbit();
                    
                    modelbuku.insertBuku(kdbuku, nmbuku, nmpengarang, nmpenerbit, thnterbit);
                    
                    //untuk menampilkan output langsung tanpa reload
                    String databuku[][] = modelbuku.readBuku();
                    buku.tabel.setModel(new JTable(databuku,buku.namakolom).getModel());
                }
            }
        });
        buku.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int baris = buku.tabel.getSelectedRow();
                int kolom = buku.tabel.getSelectedColumn();
                //mengambil nmyang ada di kolom indeks 0
                dataterpilih = buku.tabel.getValueAt(baris, 1).toString();
                
            }
        });
        
        buku.btnhapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //konfirmsi untuk menghapus
                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus buku "+dataterpilih+"?", "Pilih Opsi...", JOptionPane.YES_NO_CANCEL_OPTION);
                
                if(input==0) {
                    modelbuku.deleteBuku(dataterpilih);
                    //untuk menampilkan output langsung tanpa reload
                    String databuku[][] = modelbuku.readBuku();
                    buku.tabel.setModel(new JTable(databuku, buku.namakolom).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });
        
        buku.btnrefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buku.fkdbuku.setText("");
                buku.fnmbuku.setText("");
                buku.fnmpengarang.setText("");
                buku.fnmpenerbit.setText("");
                buku.fthnterbit.setText("");
                String databuku[][] = modelbuku.readBuku();
                buku.tabel.setModel(new JTable(databuku, buku.namakolom).getModel());
            }
        });
        buku.btncari.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String cari = buku.getsearch();
                
                modelbuku.searchBuku(cari);
                
                String datafilm[][]= modelbuku.searchBuku(cari);
                buku.tabel.setModel((new JTable(datafilm, buku.namakolom)).getModel());
                
            }
        });
        
    }
}