
package perpustakaan;

public class MVC_Pinjam {
    //untuk menghubungkan 3 kelas view model dan controller
    Peminjaman pinjam = new Peminjaman();
    ModelPeminjaman modelpinjam = new ModelPeminjaman();
    ControllerPinjam controllerpinjam = new ControllerPinjam(modelpinjam, pinjam);
}
