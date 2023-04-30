package ru.nabokov.passportservice.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.nabokov.passportservice.dto.client.ObjectDataDto;
import ru.nabokov.passportservice.dto.client.OrganizationDto;
import ru.nabokov.passportservice.dto.client.TypeDto;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class DataClient {

    private final WebClient webClient;

    public ObjectDataDto getObjectData(String uri) {
        return Objects.requireNonNull(webClient.get()
                        .uri(uri)
                        .retrieve()
                        .toEntity(ObjectDataDto.class)
                        .block())
                .getBody();
    }

    public List<ObjectDataDto> getObjectsData(String path, Long typeId) {
        return Objects.requireNonNull(webClient.get()
                        .uri(uriBuilder -> uriBuilder
                                .path(path)
                                .queryParam("typeId", typeId)
                                .build())
                        .retrieve()
                        .toEntityList(ObjectDataDto.class)
                        .block())
                .getBody();
    }

    public TypeDto getType(String uri) {
        return Objects.requireNonNull(webClient.get()
                        .uri(uri)
                        .retrieve()
                        .toEntity(TypeDto.class)
                        .block())
                .getBody();
    }

    public List<OrganizationDto> getOrganizations(String path, String ids) {
        return Objects.requireNonNull(webClient.get()
                        .uri(uriBuilder -> uriBuilder
                                .path(path)
                                .queryParam("ids", ids)
                                .build())
                        .retrieve()
                        .toEntityList(OrganizationDto.class)
                        .block())
                .getBody();
    }
}
