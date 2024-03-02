package org.example.gestionlivres.repository;

import org.example.gestionlivres.dto.LivreDTO;
import org.example.gestionlivres.entity.Enum.Genre;
import org.example.gestionlivres.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LivreRepository extends JpaRepository<Livre,Long> {
    List<Livre> findByDeletedFalse();
    List<Livre> findLivreByGenreAndDeletedFalse(Genre genre);

    Optional<Livre> findByIdAndDeletedFalse(Long aLong);
}