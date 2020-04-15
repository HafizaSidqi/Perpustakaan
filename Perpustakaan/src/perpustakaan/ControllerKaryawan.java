package perpustakaan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class ControllerKaryawan {
    //pernatara model dan view
    ModelKaryawan modelkaryawan;
    Karyawan karyawan;
    String dataterpilih;
    
    
    public ControllerKaryawan(ModelKaryawan modelkaryawan, Karyawan karyawan) {
        this.karyawan = karyawan;
        this.modelkaryawan = modelkaryawan;
        
        if (modelkaryawan.getBanyakData() != 0) {
            String datakaryawan[][] = modelkaryawan.readKaryawan();
            karyawan.tabel.setModel((new JTable(datakaryawan, karyawan.namakolom)).getModel());
            
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        karyawan.btnsimpan.addActionListener((ActionEvent e)-> {
                if (karyawan.getnik().equals("")
                        || karyawan.getnama().equals("")
                        || karyawan.getjk().equals("")
                        || karyawan.getgolongan().equals("")) {
                    JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
                } else {
                    String nik = karyawan.getnik();
                    String nama = karyawan.getnama();
                    String jk = karyawan.getjk();
                    String golongan = karyawan.getgolongan();
                    
                    modelkaryawan.insertKaryawan(nik, nama, jk, golongan);
                    
                    //untuk menampilkan output langsung tanpa reload
                    String databuku[][] = modelkaryawan.readKaryawan();
                    karyawan.tabel.setModel(new JTable(databuku,karyawan.namakolom).getModel());
                }
            
        });
        karyawan.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int baris = karyawan.tabel.getSelectedRow();
                int kolom = karyawan.tabel.getSelectedColumn();
                //mengambil nmyang ada di kolom indeks 0
                dataterpilih = karyawan.tabel.getValueAt(baris, 0).toString();
                
            }
        });
        
        karyawan.btnhapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //konfirmsi untuk menghapus
                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus karyawan "+dataterpilih+"?", "Pilih Opsi...", JOptionPane.YES_NO_CANCEL_OPTION);
                
                if(input==0) {
                    modelkaryawan.deleteKaryawan(dataterpilih);
                    //untuk menampilkan output langsung tanpa reload
                    String databuku[][] = modelkaryawan.readKaryawan();
                    karyawan.tabel.setModel(new JTable(databuku, karyawan.namakolom).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });
        
        karyawan.btnrefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                karyawan.fnik.setText("");
                karyawan.fnama.setText("");
                karyawan.fgolongan.setText("");
                
                String databuku[][] = modelkaryawan.readKaryawan();
                karyawan.tabel.setModel(new JTable(databuku, karyawan.namakolom).getModel());
            }
        });
        karyawan.btncari.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String cari = karyawan.getsearch();
                
                modelkaryawan.searchKaryawan(cari);
                
                String datafilm[][]= modelkaryawan.searchKaryawan(cari);
                karyawan.tabel.setModel((new JTable(datafilm, karyawan.namakolom)).getModel());
                
            }
        });
        
        /* karyawan.fgolongan.addKeyListener(new KeyAdapter(){
        @Override
        public void keyPressed(KeyEvent e){
        String golongan = karyawan.getgolongan().toString();
        String data[][] = modelkaryawan.readJabatan(golongan);
        String jabatan = data[0][0];
        String tunjangan = data[0][1];
        String jmlgaji = data[0][2];
        if (e.getKeyCode()==KeyEvent.VK_ENTER)
        {
        karyawan.fjabatan.setText(jabatan);
        karyawan.ftunjangan.setText(tunjangan);
        karyawan.fjmlgaji.setText(jmlgaji);
        }
        }
        });*/
    }
}