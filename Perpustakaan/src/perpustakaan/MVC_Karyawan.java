
package perpustakaan;

public class MVC_Karyawan {
    //untuk menghubungkan 3 kelas view model dan controller
    Karyawan karyawan = new Karyawan();
    ModelKaryawan modelkaryawan = new ModelKaryawan();
    ControllerKaryawan controllerkaryawan = new ControllerKaryawan(modelkaryawan, karyawan);
}
