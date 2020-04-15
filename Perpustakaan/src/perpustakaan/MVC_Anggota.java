
package perpustakaan;


public class MVC_Anggota {
    //untuk menghubungkan 3 kelas view model dan controller
    InputAnggota tampilananggota = new InputAnggota();
    ModelInputanggota modelanggota = new ModelInputanggota();
    ControllerInputAnggota controlleranggota = new ControllerInputAnggota(modelanggota, tampilananggota);
}
