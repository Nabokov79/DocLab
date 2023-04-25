package ru.nabokov.dataservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.dataservice.dto.autor.AuthorDto;
import ru.nabokov.dataservice.dto.autor.NewAuthorDto;
import ru.nabokov.dataservice.dto.autor.UpdateAuthorDto;
import ru.nabokov.dataservice.model.Author;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author mapToNewAuthor(NewAuthorDto authorDto);

    AuthorDto mapToAuthorDto(Author author);

    Author mapToUpdateAuthor(UpdateAuthorDto authorDto);

    List<AuthorDto> mapToAuthorsDto(List<Author> authors);
}
