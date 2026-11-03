package id.ac.ub.filkom.contoh.service;

import id.ac.ub.filkom.contoh.entity.Buku;
import id.ac.ub.filkom.contoh.repository.BukuRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

    private final BukuRepository bukuRepository;

    public StockService(BukuRepository bukuRepository) {
        this.bukuRepository = bukuRepository;
    }

    @Transactional
    public void ubahStok(String idBuku, int stokBaru) {
        Buku buku = bukuRepository.findById(idBuku)
                .orElseThrow(() -> new IllegalArgumentException("Buku tidak ditemukan"));

        buku.setStok(stokBaru);
        bukuRepository.save(buku);
    }
}