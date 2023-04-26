package ru.nabokov.dataservice.mapper;

import org.mapstruct.Mapper;
import ru.nabokov.dataservice.dto.branch.BranchDto;
import ru.nabokov.dataservice.dto.branch.NewBranchDto;
import ru.nabokov.dataservice.dto.branch.UpdateBranchDto;
import ru.nabokov.dataservice.model.Branch;

@Mapper(componentModel = "spring")
public interface BranchMapper {

    Branch mapToNewBranch(NewBranchDto branchDto);

    BranchDto mapToDivisionDto(Branch branch);

    Branch mapToUpdateBranch(UpdateBranchDto branchDto);

    Branch mapToBranch(BranchDto branchDto);
}
