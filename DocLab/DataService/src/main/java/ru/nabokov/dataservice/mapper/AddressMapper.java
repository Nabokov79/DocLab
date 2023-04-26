package ru.nabokov.dataservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.dataservice.dto.address.AddressDto;
import ru.nabokov.dataservice.dto.address.NewAddressDto;
import ru.nabokov.dataservice.dto.address.UpdateAddressDto;
import ru.nabokov.dataservice.model.Address;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address mapToNewAddress(NewAddressDto addressDto);

    AddressDto mapToAddressDto(Address address);

    Address mapToUpdateAddress(UpdateAddressDto addressDto);

    List<AddressDto> mapToAddressDto(List<Address> addresses);
}
