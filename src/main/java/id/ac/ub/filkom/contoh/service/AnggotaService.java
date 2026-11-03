package id.ac.ub.filkom.contoh.service;

import id.ac.ub.filkom.contoh.entity.Anggota;
import id.ac.ub.filkom.contoh.repository.AnggotaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnggotaService {

    private final AnggotaRepository anggotaRepository;

    public AnggotaService(AnggotaRepository anggotaRepository) {
        this.anggotaRepository = anggotaRepository;
    }

    // Features: Lihat Anggota
    public List<Anggota> ambilSemuaAnggota() {
        return anggotaRepository.findAll();
    }

    // Features: Tambah Anggota
    public Anggota tambahAnggota(String idAnggota, String nama) {
        return anggotaRepository.save(new Anggota(idAnggota, nama));
    }
}