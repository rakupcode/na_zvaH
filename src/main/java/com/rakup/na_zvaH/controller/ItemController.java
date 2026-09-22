package com.rakup.na_zvaH.controller;

import com.rakup.na_zvaH.dto.ItemDetail;
import com.rakup.na_zvaH.service.NaZvaHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private NaZvaHService naZvaHService;

    @GetMapping("/last")
    public ResponseEntity<ItemDetail> getLastItem(@RequestParam Long userId) {
        ItemDetail itemDetail = naZvaHService.getLastItemDetail(userId);
        if (itemDetail == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(itemDetail);
    }

    @GetMapping("/get")
    public ResponseEntity<ItemDetail> getItem(@RequestParam Long itemId) {
        ItemDetail itemDetail = naZvaHService.getItemDetail(itemId);
        if (itemDetail == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(itemDetail);
    }
}
