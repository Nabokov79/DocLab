package ru.nabokov.dataservice.service;

import ru.nabokov.dataservice.dto.address.AddressDto;
import ru.nabokov.dataservice.dto.address.NewAddressDto;
import ru.nabokov.dataservice.dto.address.UpdateAddressDto;
import ru.nabokov.dataservice.model.Address;

import java.util.List;

public interface AddressService {

    AddressDto save(NewAddressDto addressDto);

    AddressDto update(UpdateAddressDto addressDto);

    Address get(Long id);

    List<AddressDto> getAll(Long cityId, int from, int size);

    String delete(Long id);
}
