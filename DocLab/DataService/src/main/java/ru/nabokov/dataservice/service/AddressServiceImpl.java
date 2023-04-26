package ru.nabokov.dataservice.service;

import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.nabokov.dataservice.dto.address.AddressDto;
import ru.nabokov.dataservice.dto.address.NewAddressDto;
import ru.nabokov.dataservice.dto.address.UpdateAddressDto;
import ru.nabokov.dataservice.exceptions.NotFoundException;
import ru.nabokov.dataservice.mapper.AddressMapper;
import ru.nabokov.dataservice.model.Address;
import ru.nabokov.dataservice.model.QAddress;
import ru.nabokov.dataservice.repository.AddressRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;
    private final AddressMapper mapper;
    private final CityService cityService;

    @Override
    public AddressDto save(NewAddressDto addressDto) {
        Address address = mapper.mapToNewAddress(addressDto);
        address.setCity(cityService.get(addressDto.getCityId()));
        return mapper.mapToAddressDto(repository.save(address));
    }

    @Override
    public AddressDto update(UpdateAddressDto addressDto) {
        if (!repository.existsById(addressDto.getId())) {
            throw new NotFoundException(String.format("address with id=%s not found for update.", addressDto.getId()));
        }
        Address address = mapper.mapToUpdateAddress(addressDto);
        address.setCity(cityService.get(addressDto.getCityId()));
        return mapper.mapToAddressDto(repository.save(address));
    }

    @Override
    public Address get(Long id) {
        return repository.findById(id)
                         .orElseThrow(() -> new NotFoundException(String.format("Address with id=%s not found", id)));
    }

    @Override
    public List<AddressDto> getAll(Long cityId, int from, int size) {
        Pageable pageable = PageRequest.of(from / size,size, Sort.by("cityId"));
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if(cityId != null) {
            booleanBuilder.and(QAddress.address.city.id.eq(cityId));
        }
        if(cityId == null) {
            return mapper.mapToAddressDto(repository.findAll(pageable).getContent());
        }
        return mapper.mapToAddressDto(repository.findAll(booleanBuilder, pageable).getContent());
    }

    @Override
    public String delete(Long id) {
        Address address = repository.findById(id).orElseThrow(() -> new NotFoundException(
                        String.format("address with id=%s not found for delete.", id)));
        repository.deleteById(id);
        return String.join(" ", address.getCity().getName(),
                                                 address.getStreet(),
                                                 address.getHouseNumber().toString());
    }
}
