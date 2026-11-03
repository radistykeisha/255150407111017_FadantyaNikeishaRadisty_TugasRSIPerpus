package id.ac.ub.filkom.contoh.controller;

import id.ac.ub.filkom.contoh.service.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HalamanStockController {

    private final StockService stockService;

    public HalamanStockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/stok/update")
    public String updateStok(@RequestParam String idBuku, @RequestParam int stokBaru) {
        stockService.ubahStok(idBuku, stokBaru);
        return "redirect:/buku";
    }
}