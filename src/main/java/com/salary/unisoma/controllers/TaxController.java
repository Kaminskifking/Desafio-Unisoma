package com.salary.unisoma.controllers;

import com.salary.unisoma.dtos.ReadjustmentDTO;
import com.salary.unisoma.dtos.TaxDTO;
import com.salary.unisoma.services.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/tax")
public class TaxController {

    @Autowired
    TaxService taxService;

    @GetMapping("/{cpf}")
    public ResponseEntity findByCpf(@PathVariable String cpf) {
        TaxDTO tax = taxService.findByCpf(cpf);
        if(tax == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not Found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(taxService.findByCpf(cpf));
    }

}
