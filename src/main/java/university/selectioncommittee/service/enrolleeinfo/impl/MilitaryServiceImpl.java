package university.selectioncommittee.service.enrolleeinfo.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.enrolleeinfo.military.MilitaryCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.military.MilitaryUpdateRequest;
import university.selectioncommittee.entity.enrolleeinfo.Military;
import university.selectioncommittee.exception.ResourceNotFoundException;
import university.selectioncommittee.repository.enrolleeinfo.MilitaryRepository;
import university.selectioncommittee.service.enrolleeinfo.MilitaryService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MilitaryServiceImpl implements MilitaryService {

    private final MilitaryRepository militaryRepository;

    public MilitaryServiceImpl(MilitaryRepository militaryRepository) {
        this.militaryRepository = militaryRepository;
    }

    @Override
    @Transactional
    public Military create(@NonNull MilitaryCreateRequest request) {
        Military military = new Military();
        military.setDocument(request.getDocument());
        military.setSerialNum(request.getSerialNum());
        military.setNameOfMilitaryRegis(request.getNameOfMilitaryRegis());
        military.setMilitaryRegistrationDate(request.getMilitaryRegistrationDate());
        military.setGood(request.isGood());
        military.setSpecialAccount(request.isSpecialAccount());
        military.setSpecialAccountNumber(request.getSpecialAccountNumber());
        military.setTransferredToTheReserve(request.isTransferredToTheReserve());
        military.setRank(request.getRank());
        military.setMilitaryRegistrationSpecialty(request.getMilitaryRegistrationSpecialty());
        military.setMilitaryRegistrationNumber(request.getMilitaryRegistrationNumber());
        military.setCreateAt(LocalDateTime.now());
        return militaryRepository.save(military);
    }

    @Override
    @Transactional
    public Military put(@NonNull Long id, @NonNull MilitaryUpdateRequest request) {
        Military military = retrieve(id);
        military.setDocument(request.getDocument());
        military.setSerialNum(request.getSerialNum());
        military.setNameOfMilitaryRegis(request.getNameOfMilitaryRegis());
        military.setMilitaryRegistrationDate(request.getMilitaryRegistrationDate());
        military.setGood(request.isGood());
        military.setSpecialAccount(request.isSpecialAccount());
        military.setSpecialAccountNumber(request.getSpecialAccountNumber());
        military.setTransferredToTheReserve(request.isTransferredToTheReserve());
        military.setRank(request.getRank());
        military.setMilitaryRegistrationSpecialty(request.getMilitaryRegistrationSpecialty());
        military.setMilitaryRegistrationNumber(request.getMilitaryRegistrationNumber());
        military.setUpdateAt(LocalDateTime.now());
        return militaryRepository.save(military);
    }

    @Override
    @Transactional(readOnly = true)
    public Military retrieve(@NonNull Long id) {
        return militaryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Military with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Military> list() {
        return militaryRepository.findAll();
    }
}
