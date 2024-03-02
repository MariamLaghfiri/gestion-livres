package org.example.gestionlivres.dto;

import lombok.*;
import org.example.gestionlivres.entity.Enum.Genre;
import org.example.gestionlivres.entity.Enum.Role;

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
    private Boolean deleted;
    private Role roles;
}
