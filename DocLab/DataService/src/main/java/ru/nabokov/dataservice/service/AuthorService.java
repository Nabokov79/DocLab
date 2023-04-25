package ru.nabokov.dataservice.service;

import ru.nabokov.dataservice.dto.autor.AuthorDto;
import ru.nabokov.dataservice.dto.autor.NewAuthorDto;
import ru.nabokov.dataservice.dto.autor.UpdateAuthorDto;
import java.util.List;

public interface AuthorService {

    AuthorDto save(NewAuthorDto authorDto);

    AuthorDto update(UpdateAuthorDto authorDto);

    List<AuthorDto> getAll();

    String delete(Long id);
}
