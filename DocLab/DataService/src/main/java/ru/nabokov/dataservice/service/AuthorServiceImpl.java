package ru.nabokov.dataservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.dataservice.dto.autor.AuthorDto;
import ru.nabokov.dataservice.dto.autor.NewAuthorDto;
import ru.nabokov.dataservice.dto.autor.UpdateAuthorDto;
import ru.nabokov.dataservice.exceptions.BadRequestException;
import ru.nabokov.dataservice.exceptions.NotFoundException;
import ru.nabokov.dataservice.mapper.AuthorMapper;
import ru.nabokov.dataservice.model.Author;
import ru.nabokov.dataservice.repository.AuthorRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;
    private final AuthorMapper mapper;

    @Override
    public AuthorDto save(NewAuthorDto authorDto) {
        if (repository.existsByName(authorDto.getName())) {
            throw new BadRequestException(String.format("author=%s found.", authorDto.getName()));
        }
        Author author = mapper.mapToNewAuthor(authorDto);
        return mapper.mapToAuthorDto(repository.save(author));
    }

    @Override
    public AuthorDto update(UpdateAuthorDto authorDto) {
        if (!repository.existsById(authorDto.getId())) {
            throw new NotFoundException(String.format("author=%s not found for update.", authorDto.getName()));
        }
        Author author = mapper.mapToUpdateAuthor(authorDto);
        return mapper.mapToAuthorDto(repository.save(author));
    }

    @Override
    public List<AuthorDto> getAll() {
        return mapper.mapToAuthorsDto(repository.findAll());
    }

    @Override
    public String delete(Long id) {
        Author author = repository.findById(id).orElseThrow(() -> new NotFoundException(
                        String.format("author with id=%s not found for delete.", id))
                );
        repository.deleteById(id);
        return author.getName();
    }
}