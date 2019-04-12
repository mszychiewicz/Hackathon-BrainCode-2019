package com.braincode.backend.alfa;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AlfaController {

    private AlfaRepository repository;

    @GetMapping("/alfas")
    List<Alfa> all() {return repository.findAll(); }

    @PostMapping("/alfas")
    Alfa newAlfa(@RequestBody Alfa newAlfa) {
        return repository.save(newAlfa);
    }

    // Single item

    @GetMapping("/alfas/{id}")
    Alfa one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new AlfaNotFoundException(id));
    }

    @PutMapping("/alfas/{id}")
    Alfa replaceAlfa(@RequestBody Alfa newAlfa, @PathVariable Long id) {

        return repository.findById(id)
                .map(alfa -> {
                    alfa.setName(newAlfa.getName());
                    return repository.save(alfa);
                })
                .orElseGet(() -> {
                    newAlfa.setId(id);
                    return repository.save(newAlfa);
                });
    }

    @DeleteMapping("/alfas/{id}")
    void deleteAlfa(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
