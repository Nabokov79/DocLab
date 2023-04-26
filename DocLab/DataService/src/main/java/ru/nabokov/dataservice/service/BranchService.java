package ru.nabokov.dataservice.service;

import ru.nabokov.dataservice.dto.branch.BranchDto;
import ru.nabokov.dataservice.dto.branch.NewBranchDto;
import ru.nabokov.dataservice.dto.branch.UpdateBranchDto;

public interface BranchService {

    BranchDto save(NewBranchDto branchDto);

    BranchDto update(UpdateBranchDto branchDto);

    BranchDto get(Long id);
}
