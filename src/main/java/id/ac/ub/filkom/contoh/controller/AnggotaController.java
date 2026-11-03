package id.ac.ub.filkom.contoh.controller;

import id.ac.ub.filkom.contoh.service.AnggotaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnggotaController {

    private final AnggotaService anggotaService;

    public AnggotaController(AnggotaService anggotaService) {
        this.anggotaService = anggotaService;
    }

    @GetMapping("/anggota")
    public String tampilkanHalamanAnggota(Model model) {
        model.addAttribute("daftarAnggota", anggotaService.ambilSemuaAnggota());
        return "anggota";
    }

    @PostMapping("/anggota")
    public String tambahAnggota(@RequestParam String idAnggota, @RequestParam String nama) {
        anggotaService.tambahAnggota(idAnggota, nama);
        return "redirect:/anggota";
    }
}