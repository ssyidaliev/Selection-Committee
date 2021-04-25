package university.selectioncommittee.service.enrolleeinfo.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.enrolleeinfo.ortscore.OrtScoreCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.ortscore.OrtScoreUpdateRequest;
import university.selectioncommittee.entity.enrolleeinfo.OrtScore;
import university.selectioncommittee.exception.ResourceNotFoundException;
import university.selectioncommittee.repository.enrolleeinfo.OrtScoreRepository;
import university.selectioncommittee.service.enrolleeinfo.OrtScoreService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrtScoreServiceImpl implements OrtScoreService {

    private final OrtScoreRepository ortScoreRepository;

    public OrtScoreServiceImpl(OrtScoreRepository ortScoreRepository) {
        this.ortScoreRepository = ortScoreRepository;
    }

    @Override
    @Transactional
    public OrtScore create(@NonNull OrtScoreCreateRequest request) {
        OrtScore ortScore = new OrtScore();
        ortScore.setBasicScore(request.getBasicScore());
        ortScore.setKyrSubScore(request.getKyrSubScore());
        ortScore.setBioSubScore(request.getBioSubScore());
        ortScore.setPhySubScore(request.getPhySubScore());
        ortScore.setChemSubScore(request.getChemSubScore());
        ortScore.setMathSubScore(request.getMathSubScore());
        ortScore.setHisSubScore(request.getHisSubScore());
        ortScore.setEngSubScore(request.getEngSubScore());
        ortScore.setRusSubScore(request.getRusSubScore());
        ortScore.setCreateAt(LocalDateTime.now());
        return ortScoreRepository.save(ortScore);
    }

    @Override
    @Transactional
    public OrtScore put(@NonNull Long id, @NonNull OrtScoreUpdateRequest request) {
        OrtScore ortScore = retrieve(id);
        ortScore.setBasicScore(request.getBasicScore());
        ortScore.setKyrSubScore(request.getKyrSubScore());
        ortScore.setBioSubScore(request.getBioSubScore());
        ortScore.setPhySubScore(request.getPhySubScore());
        ortScore.setChemSubScore(request.getChemSubScore());
        ortScore.setMathSubScore(request.getMathSubScore());
        ortScore.setHisSubScore(request.getHisSubScore());
        ortScore.setEngSubScore(request.getEngSubScore());
        ortScore.setRusSubScore(request.getRusSubScore());
        ortScore.setUpdateAt(LocalDateTime.now());
        return ortScoreRepository.save(ortScore);
    }

    @Override
    @Transactional(readOnly = true)
    public OrtScore retrieve(@NonNull Long id) {
        return ortScoreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "OrtScore with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrtScore> list() {
        return ortScoreRepository.findAll();
    }
}
