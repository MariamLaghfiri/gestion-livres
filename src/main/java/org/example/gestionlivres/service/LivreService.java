package org.example.gestionlivres.service;

import org.example.gestionlivres.dto.LivreDTO;
import org.example.gestionlivres.entity.Enum.Genre;

import java.util.List;

public interface LivreService {
    List<LivreDTO> showAllLivres();
    List<LivreDTO> findLivreByGenre(Genre genre);
    LivreDTO getLivreById(Long id);
    LivreDTO addLivre(LivreDTO livreDTO);
    LivreDTO updateLivre(Long id ,LivreDTO livreDTO);
    Boolean deleteLivre(LivreDTO livreDTO);

}
