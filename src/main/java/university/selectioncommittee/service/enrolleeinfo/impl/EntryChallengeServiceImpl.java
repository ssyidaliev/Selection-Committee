package university.selectioncommittee.service.enrolleeinfo.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.enrolleeinfo.enrtychallenge.EntryChallengeCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.enrtychallenge.EntryChallengeUpdateRequest;
import university.selectioncommittee.entity.enrolleeinfo.EntryChallenge;
import university.selectioncommittee.entity.enrolleeinfo.InsideTest;
import university.selectioncommittee.entity.enrolleeinfo.OrtScore;
import university.selectioncommittee.exception.ResourceNotFoundException;
import university.selectioncommittee.repository.enrolleeinfo.EntryChallengeRepository;
import university.selectioncommittee.service.enrolleeinfo.EntryChallengeService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EntryChallengeServiceImpl implements EntryChallengeService {

    private final EntryChallengeRepository entryChallengeRepository;

    public EntryChallengeServiceImpl(EntryChallengeRepository entryChallengeRepository) {
        this.entryChallengeRepository = entryChallengeRepository;
    }

    @Override
    @Transactional
    public EntryChallenge create(EntryChallengeCreateRequest request, InsideTest insideTest, OrtScore ortScore) {
        EntryChallenge entryChallenge = new EntryChallenge();
        entryChallenge.setPassedOrt(request.isPassedOrt());
        entryChallenge.setCertificateNum(request.getCertificateNum());
        entryChallenge.setCertificateColor(request.getCertificateColor());
        entryChallenge.setSumScore(request.getSumScore());
        entryChallenge.setTourNum(request.getTourNum());
        entryChallenge.setAfterCollage(request.isAfterCollage());
        entryChallenge.setDontAppear(request.isDontAppear());
        entryChallenge.setNoSatisfied(request.isNoSatisfied());
        entryChallenge.setPassedInsideTest(request.isPassedInsideTest());
        entryChallenge.setInsideTest(insideTest);
        entryChallenge.setOrtScore(ortScore);
        entryChallenge.setCreateAt(LocalDateTime.now());
        return entryChallengeRepository.save(entryChallenge);
    }

    @Override
    @Transactional
    public EntryChallenge put(@NonNull Long id, EntryChallengeUpdateRequest request, InsideTest insideTest, OrtScore ortScore) {
        EntryChallenge entryChallenge = retrieve(id);
        entryChallenge.setPassedOrt(request.isPassedOrt());
        entryChallenge.setCertificateNum(request.getCertificateNum());
        entryChallenge.setCertificateColor(request.getCertificateColor());
        entryChallenge.setSumScore(request.getSumScore());
        entryChallenge.setTourNum(request.getTourNum());
        entryChallenge.setAfterCollage(request.isAfterCollage());
        entryChallenge.setDontAppear(request.isDontAppear());
        entryChallenge.setNoSatisfied(request.isNoSatisfied());
        entryChallenge.setPassedInsideTest(request.isPassedInsideTest());
        entryChallenge.setInsideTest(insideTest);
        entryChallenge.setOrtScore(ortScore);
        entryChallenge.setUpdateAt(LocalDateTime.now());
        return entryChallengeRepository.save(entryChallenge);
    }

    @Override
    @Transactional(readOnly = true)
    public EntryChallenge retrieve(@NonNull Long id) {
        return entryChallengeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Entry Challenge with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<EntryChallenge> list() {
        return entryChallengeRepository.findAll();
    }
}
