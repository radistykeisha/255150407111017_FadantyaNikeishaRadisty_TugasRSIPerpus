package id.ac.ub.filkom.contoh.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "buku")
public class Buku {

    @Id
    @Column(name = "id_buku")
    private String idBuku;

    private String judul;
    private int stok;

    protected Buku() {}

    public Buku(String idBuku, String judul, int stok) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.stok = stok;
    }

    public boolean kurangiStok(int qty) {
        if (qty <= 0 || stok < qty) return false;
        this.stok -= qty;
        return true;
    }

    // Getter & Setter (SETTER DITAMBAHKAN UNTUK STOCKSERVICE)
    public String getIdBuku() { return idBuku; }
    public String getJudul() { return judul; }
    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }
}