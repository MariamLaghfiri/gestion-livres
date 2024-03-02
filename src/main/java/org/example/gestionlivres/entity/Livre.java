package org.example.gestionlivres.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.gestionlivres.entity.Enum.Role;
import org.example.gestionlivres.entity.Enum.Genre;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String auteur;
    private Genre genre;
    @Column(name="is_deleted", columnDefinition = "boolean default false")
    private Boolean deleted;
    private Role roles;
}