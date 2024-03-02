package org.example.gestionlivres.controller;

import org.example.gestionlivres.dto.LivreDTO;
import org.example.gestionlivres.entity.Enum.Genre;
import org.example.gestionlivres.service.serviceImp.LivreServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/livre")
public class LivreController {
    @Autowired
    LivreServiceImp livreServiceImp;

    @GetMapping("/all")
    public ResponseEntity<List<LivreDTO>> showAllLivres(){
        List<LivreDTO> livreDTOS=livreServiceImp.showAllLivres();
        return new ResponseEntity<>(livreDTOS, HttpStatus.OK);
    }
    @GetMapping("/find-livre-by-genre/{genre}")
    public ResponseEntity<List<LivreDTO>> findLivreByGenre(@PathVariable(value = "genre") Genre genre){
        List<LivreDTO> livreDTOS=livreServiceImp.findLivreByGenre(genre);
        return new ResponseEntity<>(livreDTOS, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LivreDTO> getLivreById(@PathVariable(value = "id") Long id){
        LivreDTO livreDTO = livreServiceImp.getLivreById(id);
        return new ResponseEntity<>(livreDTO, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<LivreDTO> addLivre(@RequestBody LivreDTO livreDTO){
        LivreDTO livre=livreServiceImp.addLivre(livreDTO);
        return new ResponseEntity<>(livre, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<LivreDTO> updateLivre(@RequestBody LivreDTO livreDTO, @PathVariable Long id){
        LivreDTO livre=livreServiceImp.updateLivre(id, livreDTO);
        return new ResponseEntity<>(livre, HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public HashMap<String,Boolean> deleteLivre(@PathVariable(value = "id") Long id){
        LivreDTO livreDTO=livreServiceImp.getLivreById(id);
        HashMap<String,Boolean> response=new HashMap<>();
        if(livreServiceImp.deleteLivre(livreDTO)){
            response.put("delete",Boolean.TRUE);
        }
        return response;
    }
}
