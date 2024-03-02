package org.example.gestionlivres.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.example.gestionlivres.entity.Enum.Genre;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Livre {
    @Id
    @GeneratedValue()
    private Long id;
    private String titre;
    private String auteur;
    private Genre genre;
}
