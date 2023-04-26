package ru.nabokov.dataservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokov.dataservice.dto.branch.BranchDto;
import ru.nabokov.dataservice.dto.branch.NewBranchDto;
import ru.nabokov.dataservice.dto.branch.UpdateBranchDto;
import ru.nabokov.dataservice.exceptions.BadRequestException;
import ru.nabokov.dataservice.exceptions.NotFoundException;
import ru.nabokov.dataservice.mapper.BranchMapper;
import ru.nabokov.dataservice.mapper.LicenseMapper;
import ru.nabokov.dataservice.model.Branch;
import ru.nabokov.dataservice.repository.BranchRepository;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository repository;
    private final BranchMapper mapper;
    private final LicenseMapper licenseMapper;
    private final AddressService addressService;
    private final LicenseService licenseService;

    @Override
    public BranchDto save(NewBranchDto branchDto) {
        Branch branch = mapper.mapToNewBranch(branchDto);
        branch.setAddress(addressService.get(branchDto.getAddressId()));
        branch.setLicense(licenseMapper.mapToLicense(licenseService.get(branchDto.getLicenseId())));
        return mapper.mapToDivisionDto(repository.save(branch));
    }

    @Override
    public BranchDto update(UpdateBranchDto branchDto) {
        if (!repository.existsById(branchDto.getId())) {
            throw new BadRequestException(String.format("Branch wth id=%s not found for update", branchDto.getId()));
        }
        Branch branch = mapper.mapToUpdateBranch(branchDto);
        branch.setAddress(addressService.get(branchDto.getAddressId()));
        branch.setLicense(licenseMapper.mapToLicense(licenseService.get(branchDto.getLicenseId())));
        return mapper.mapToDivisionDto(repository.save(branch));
    }

    @Override
    public BranchDto get(Long id) {
        return mapper.mapToDivisionDto(repository.findById(id)
                              .orElseThrow(() -> new NotFoundException(String.format("Branch wth id=%s not found", id)))
        );
    }
}
