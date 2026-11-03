package id.ac.ub.filkom.contoh.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import id.ac.ub.filkom.contoh.service.PeminjamanService;
import java.util.Map;

@RestController
@RequestMapping("/api/peminjaman")
public class PeminjamanBoundary {

    private final PeminjamanService peminjamanService;

    public PeminjamanBoundary(PeminjamanService peminjamanService) {
        this.peminjamanService = peminjamanService;
    }

    @PostMapping
    public ResponseEntity<?> pinjamBuku(@RequestBody PinjamRequest request) {
        try {
            String idPinjam = peminjamanService.prosesPinjam(
                    request.idAnggota(), 
                    request.idBuku(), 
                    request.qty()
            );
            return ResponseEntity.ok(Map.of(
                    "status", "SUCCESS",
                    "idPinjam", idPinjam,
                    "message", "Peminjaman berhasil diproses"
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "status", "FAILED",
                    "message", e.getMessage()
            ));
        }
    }

    public record PinjamRequest(String idAnggota, String idBuku, int qty) {}
}