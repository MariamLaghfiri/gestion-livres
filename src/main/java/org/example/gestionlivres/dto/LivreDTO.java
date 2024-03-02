package org.example.gestionlivres.dto;

import jakarta.persistence.Entity;
import lombok.*;
import org.example.gestionlivres.entity.Enum.Genre;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LivreDTO {
    private Long id;
    private String titre;
    private String auteur;
    private Genre genre;
}
