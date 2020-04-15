
package perpustakaan;

public class MVC_Buku {
    //untuk menghubungkan 3 kelas view model dan controller
    Buku buku = new Buku();
    ModelBuku modelbuku = new ModelBuku();
    ControllerBuku controllerbuku = new ControllerBuku(modelbuku, buku);
}
