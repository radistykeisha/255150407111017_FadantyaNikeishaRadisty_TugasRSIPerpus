package id.ac.ub.filkom.contoh.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "peminjaman")
public class Peminjaman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPinjam;

    @Column(name = "id_anggota", nullable = false)
    private String idAnggota;

    @Column(name = "id_buku", nullable = false)
    private String idBuku;

    @Column(name = "jumlah_buku", nullable = false)
    private int jumlahBuku;

    @Column(name = "tanggal_pinjam")
    private LocalDate tanggalPinjam;

    @Column(name = "status")
    private String status;

    protected Peminjaman() { } // Wajib untuk JPA

    public Peminjaman(String idAnggota, String idBuku, int jumlahBuku) {
        this.idAnggota = idAnggota;
        this.idBuku = idBuku;
        this.jumlahBuku = jumlahBuku;
        this.tanggalPinjam = LocalDate.now();
        this.status = "DIPINJAM";
    }

    // Getter
    public Long getIdPinjam() { return idPinjam; }
    public String getIdAnggota() { return idAnggota; }
    public String getIdBuku() { return idBuku; }
    public int getJumlahBuku() { return jumlahBuku; }
    public LocalDate getTanggalPinjam() { return tanggalPinjam; }
    public String getStatus() { return status; }
}