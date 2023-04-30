package ru.nabokov.passportservice.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.passportservice.dto.client.ObjectDataDto;
import ru.nabokov.passportservice.dto.client.OrganizationDto;
import ru.nabokov.passportservice.dto.client.TypeDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassportClient {

    private final DataClient client;

    public ObjectDataDto getObjectData(Long id) {
        return client.getObjectData("/data/object/" + id);
    }

    public List<ObjectDataDto> getObjectsData(Long typeId) {
        return client.getObjectsData("/data/object/", typeId);
    }

    public TypeDto getType(Long id) {
        return client.getType("/data/type/" + id);
    }

    public List<OrganizationDto> getOrganizations(String ids) {
        return client.getOrganizations("/data/organizations/", ids);
    }
}
