package university.selectioncommittee.service.enrolleeinfo.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.enrolleeinfo.insidetest.InsideTestCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.insidetest.InsideTestUpdateRequest;
import university.selectioncommittee.entity.enrolleeinfo.InsideTest;
import university.selectioncommittee.exception.ResourceNotFoundException;
import university.selectioncommittee.repository.enrolleeinfo.InsideTestRepository;
import university.selectioncommittee.service.enrolleeinfo.InsideTestService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InsideTestServiceImpl implements InsideTestService {

    private final InsideTestRepository insideTestRepository;

    public InsideTestServiceImpl(InsideTestRepository insideTestRepository) {
        this.insideTestRepository = insideTestRepository;
    }

    @Override
    @Transactional
    public InsideTest create(@NonNull InsideTestCreateRequest request) {
        InsideTest insideTest = new InsideTest();
        insideTest.setPassedByOrtResult(request.isPassedByOrtResult());
        insideTest.setReqScore(request.getReqScore());
        insideTest.setPlaceNum(request.getPlaceNum());
        insideTest.setPlaceCount(request.getPlaceCount());
        insideTest.setCreateAt(LocalDateTime.now());
        return insideTestRepository.save(insideTest);
    }

    @Override
    @Transactional
    public InsideTest put(@NonNull Long id, @NonNull InsideTestUpdateRequest request) {
        InsideTest insideTest = retrieve(id);
        insideTest.setPassedByOrtResult(request.isPassedByOrtResult());
        insideTest.setReqScore(request.getReqScore());
        insideTest.setPlaceNum(request.getPlaceNum());
        insideTest.setPlaceCount(request.getPlaceCount());
        insideTest.setUpdateAt(LocalDateTime.now());
        return insideTestRepository.save(insideTest);
    }

    @Override
    @Transactional(readOnly = true)
    public InsideTest retrieve(@NonNull Long id) {
        return insideTestRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "InsideTest with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<InsideTest> list() {
        return insideTestRepository.findAll();
    }
}
