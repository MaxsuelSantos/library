package com.max.library.controllers;

import com.max.library.dto.CollectionDTO;
import com.max.library.services.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("collections")
public class CollectionController {

    @Autowired
    private CollectionService service;


    @GetMapping
    public ResponseEntity<Page<CollectionDTO>> findAllPaged(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAllPaged(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CollectionDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<CollectionDTO> insert(@RequestBody CollectionDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CollectionDTO> update(@PathVariable Long id, @RequestBody CollectionDTO dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
