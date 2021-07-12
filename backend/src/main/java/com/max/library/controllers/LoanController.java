package com.max.library.controllers;

import com.max.library.dto.LoanDTO;
import com.max.library.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("loans")
public class LoanController {

    @Autowired
    private LoanService service;


    @GetMapping
    public ResponseEntity<Page<LoanDTO>> findAllPaged(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAllPaged(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<LoanDTO> insert(@RequestBody LoanDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanDTO> update(@PathVariable Long id, @RequestBody LoanDTO dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
