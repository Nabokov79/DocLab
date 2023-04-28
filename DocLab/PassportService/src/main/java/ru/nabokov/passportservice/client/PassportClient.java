package ru.nabokov.passportservice.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.dto.client.ObjectDataDto;
import ru.nabokov.passportservice.dto.client.OrganizationDto;
import ru.nabokov.passportservice.dto.client.TypeDto;

@Service
@RequiredArgsConstructor
public class PassportClient {

    private final DataClient client;

    public ObjectDataDto getObjectData(Long id) {
        return client.getObjectData("/data/object/" + id);
    }

    public TypeDto getType(Long id) {
        return client.getType("/data/type/" + id);
    }

    public OrganizationDto getOrganization(Long id) {
        return client.getOrganization("/data/organizations/" + id);
    }
}
