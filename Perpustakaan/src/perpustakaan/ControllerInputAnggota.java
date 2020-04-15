package perpustakaan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class ControllerInputAnggota {
    //pernatara model dan view
    ModelInputanggota modelinputanggota;
    InputAnggota inputanggota;
    String dataterpilih;
    
    public ControllerInputAnggota(ModelInputanggota modelinputanggota, InputAnggota inputanggota) {
        this.modelinputanggota = modelinputanggota;
        this.inputanggota = inputanggota;
        
        if (modelinputanggota.getBanyakData() != 0) {
            String dataanggota[][] = modelinputanggota.readAnggota();
            inputanggota.tabel.setModel((new JTable(dataanggota, inputanggota.namakolom)).getModel());
            
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        inputanggota.btnsimpan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputanggota.getnim().equals("")
                        || inputanggota.getnama().equals("")
                        || inputanggota.gettl().equals("")
                        || inputanggota.getjk().equals("")
                        || inputanggota.getagama().equals("")
                        || inputanggota.getkelas().equals("")
                        || inputanggota.gettgldaftar().equals("")
                        || inputanggota.getberlaku().equals("")) {
                    JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
                } else {
                    String nim = inputanggota.getnim();
                    String nama = inputanggota.getnama();
                    String ttl = inputanggota.gettl();
                    String jk = inputanggota.getjk();
                    String agama = inputanggota.getagama();
                    String kelas = inputanggota.getkelas();
                    String tgldaftar = inputanggota.gettgldaftar();
                    String berlaku = inputanggota.getberlaku();
                    
                    modelinputanggota.insertAnggota(nim, nama, ttl, jk, agama, kelas, tgldaftar, berlaku);
                    
                    //untuk menampilkan output langsung tanpa reload
                    String datamahasiswa[][] = modelinputanggota.readAnggota();
                    inputanggota.tabel.setModel(new JTable(datamahasiswa, inputanggota.namakolom).getModel());
                }
            }
        });
        
        inputanggota.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int baris = inputanggota.tabel.getSelectedRow();
                int kolom = inputanggota.tabel.getSelectedColumn();
                //mengambil nmyang ada di kolom indeks 0
                dataterpilih = inputanggota.tabel.getValueAt(baris, 0).toString();
                
            }
        });
        
        inputanggota.btnhapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //konfirmsi untuk menghapus
                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus NIM "+dataterpilih+"?", "Pilih Opsi...", JOptionPane.YES_NO_CANCEL_OPTION);
                
                if(input==0) {
                    modelinputanggota.deleteAnggota(dataterpilih);
                    //untuk menampilkan output langsung tanpa reload
                    String datamahasiswa[][] = modelinputanggota.readAnggota();
                    inputanggota.tabel.setModel(new JTable(datamahasiswa, inputanggota.namakolom).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });
        
        inputanggota.btnrefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputanggota.fnim.setText("");
                inputanggota.fnama.setText("");
                inputanggota.fttl.setText("");
                inputanggota.rbPria.isSelected();
                inputanggota.cmbagama.setSelectedItem("");
                inputanggota.fkelas.setText("");
                inputanggota.ftgldaftar.setText("");
                inputanggota.fberlaku.setText("");
                
                String dataanggota[][] = modelinputanggota.readAnggota();
                inputanggota.tabel.setModel(new JTable(dataanggota, inputanggota.namakolom).getModel());
            }
        });
        
    }
}
