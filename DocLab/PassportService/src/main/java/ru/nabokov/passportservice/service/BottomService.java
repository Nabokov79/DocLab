package ru.nabokov.passportservice.service;

import ru.nabokov.passportservice.dto.bottom.BottomDto;
import ru.nabokov.passportservice.dto.bottom.NewBottomDto;
import ru.nabokov.passportservice.dto.bottom.UpdateBottomDto;
import java.util.List;

public interface BottomService {

    List<BottomDto> save(List<NewBottomDto> bottomsDto);

    List<BottomDto> update(List<UpdateBottomDto> bottomsDto);

    List<BottomDto> getAll(Integer volume);

   void delete(Long botId);
}
