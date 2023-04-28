package ru.nabokov.passportservice.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.nabokov.passportservice.dto.client.ObjectDataDto;
import ru.nabokov.passportservice.dto.client.Organization;
import ru.nabokov.passportservice.dto.client.TypeDto;

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

    public TypeDto getType(String uri) {
        return Objects.requireNonNull(webClient.get()
                        .uri(uri)
                        .retrieve()
                        .toEntity(TypeDto.class)
                        .block())
                .getBody();
    }

    public Organization getOrganization(String uri) {
        return Objects.requireNonNull(webClient.get()
                        .uri(uri)
                        .retrieve()
                        .toEntity(Organization.class)
                        .block())
                .getBody();
    }
}
