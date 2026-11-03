package id.ac.ub.filkom.contoh.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "anggota")
public class Anggota {

    @Id
    @Column(name = "id_anggota")
    private String idAnggota;

    private String nama;

    @Column(name = "batas_pinjam")
    private int batasPinjam;

    protected Anggota() {}

    // Konstruktor 3 parameter
    public Anggota(String idAnggota, String nama, int batasPinjam) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.batasPinjam = batasPinjam;
    }

    // Konstruktor 2 parameter (DITAMBAHKAN UNTUK ANGGOTASERVICE)
    public Anggota(String idAnggota, String nama) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.batasPinjam = 3;
    }

    // Domain logic
    public boolean dapatMeminjam(int qty) {
        return qty > 0 && qty <= batasPinjam;
    }

    // Getter
    public String getIdAnggota() { return idAnggota; }
    public String getNama() { return nama; }
    public int getBatasPinjam() { return batasPinjam; }
}