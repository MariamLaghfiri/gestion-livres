package org.example.gestionlivres.service.serviceImp;

import org.example.gestionlivres.dto.LivreDTO;
import org.example.gestionlivres.entity.Enum.Genre;
import org.example.gestionlivres.entity.Livre;
import org.example.gestionlivres.repository.LivreRepository;
import org.example.gestionlivres.service.LivreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivreServiceImp implements LivreService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    LivreRepository livreRepository;
    @Override
    public List<LivreDTO> showAllLivres() {
        List<Livre> livres = livreRepository.findByDeletedFalse();
        return livres.stream()
                .map(l -> modelMapper.map(l,LivreDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<LivreDTO> findLivreByGenre(Genre genre) {
        List<Livre> livres = livreRepository.findLivreByGenreAndDeletedFalse(genre);
        return livres.stream()
                .map(l -> modelMapper.map(l,LivreDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public LivreDTO getLivreById(Long id) {
        Livre livre= livreRepository.findByIdAndDeletedFalse(id).get();
        return modelMapper.map(livre, LivreDTO.class);
    }

    @Override
    public LivreDTO addLivre(LivreDTO livreDTO) {
        Livre livre = livreRepository.save(modelMapper.map(livreDTO,Livre.class));
        return modelMapper.map(livre,LivreDTO.class);
    }

    @Override
    public LivreDTO updateLivre(Long id, LivreDTO livreDTO) {
        livreDTO.setId(id);
        Livre livre = livreRepository.save(modelMapper.map(livreDTO,Livre.class));
        return modelMapper.map(livre,LivreDTO.class);
    }

    @Override
    public Boolean deleteLivre(LivreDTO livreDTO) {
        livreDTO.setDeleted(Boolean.TRUE);
        LivreDTO livreDTO1=modelMapper.map(livreRepository.save(modelMapper.map(livreDTO, Livre.class)),LivreDTO.class);
        return livreDTO1.getDeleted();
    }
}
