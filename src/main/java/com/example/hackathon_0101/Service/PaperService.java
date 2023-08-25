package com.example.hackathon_0101.Service;

import com.example.hackathon_0101.Dto.PaperDto;
import com.example.hackathon_0101.Dto.UserDto;
import com.example.hackathon_0101.Entity.PaperEntity;
import com.example.hackathon_0101.Entity.UserEntity;
import com.example.hackathon_0101.Repository.PaperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaperService {
    private final PaperRepository paperRepository;

    public void save(PaperDto paperDto){  //논문 저장
        PaperEntity paperEntity =PaperEntity.toPaperEntity(paperDto);
        paperRepository.save(paperEntity);
    }
}
