package id.ac.ub.filkom.contoh.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import id.ac.ub.filkom.contoh.entity.*;
import id.ac.ub.filkom.contoh.repository.*;

@Service
public class PeminjamanService {

    private final AnggotaRepository anggotaRepo;
    private final BukuRepository bukuRepo;
    private final PeminjamanRepository peminjamanRepo;

    public PeminjamanService(AnggotaRepository anggotaRepo, 
                             BukuRepository bukuRepo, 
                             PeminjamanRepository peminjamanRepo) {
        this.anggotaRepo = anggotaRepo;
        this.bukuRepo = bukuRepo;
        this.peminjamanRepo = peminjamanRepo;
    }

    @Transactional
    public String prosesPinjam(String idAnggota, String idBuku, int qty) {
        Anggota anggota = anggotaRepo.findById(idAnggota)
                .orElseThrow(() -> new RuntimeException("Anggota tidak ditemukan"));

        if (!anggota.dapatMeminjam(qty)) {
            throw new RuntimeException("Jumlah pinjam melebihi batas pinjam anggota!");
        }

        Buku buku = bukuRepo.findById(idBuku)
                .orElseThrow(() -> new RuntimeException("Buku tidak ditemukan"));

        if (!buku.kurangiStok(qty)) {
            throw new RuntimeException("Stok buku tidak mencukupi!");
        }
        bukuRepo.save(buku);

        Peminjaman peminjaman = new Peminjaman(idAnggota, idBuku, qty);
        peminjamanRepo.save(peminjaman);

        return "PNJ-" + peminjaman.getIdPinjam();
    }
}