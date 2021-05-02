package university.selectioncommittee.endpoint.enrolleinfo.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.enrolleeinfo.enrtychallenge.EntryChallengeCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.enrtychallenge.EntryChallengeResponse;
import university.selectioncommittee.dto.enrolleeinfo.enrtychallenge.EntryChallengeUpdateRequest;
import university.selectioncommittee.endpoint.enrolleinfo.EntryChallengeEndpoint;
import university.selectioncommittee.entity.enrolleeinfo.InsideTest;
import university.selectioncommittee.entity.enrolleeinfo.OrtScore;
import university.selectioncommittee.mapper.EntryChallengeMapper;
import university.selectioncommittee.service.enrolleeinfo.EntryChallengeService;
import university.selectioncommittee.service.enrolleeinfo.InsideTestService;
import university.selectioncommittee.service.enrolleeinfo.OrtScoreService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntryChallengeEndpointImpl implements EntryChallengeEndpoint {

    private final EntryChallengeMapper entryChallengeMapper;
    private final EntryChallengeService entryChallengeService;
    private final OrtScoreService ortScoreService;
    private final InsideTestService insideTestService;

    public EntryChallengeEndpointImpl(EntryChallengeMapper entryChallengeMapper, EntryChallengeService entryChallengeService, OrtScoreService ortScoreService, InsideTestService insideTestService) {
        this.entryChallengeMapper = entryChallengeMapper;
        this.entryChallengeService = entryChallengeService;
        this.ortScoreService = ortScoreService;
        this.insideTestService = insideTestService;
    }

    @Override
    @Transactional
    public EntryChallengeResponse add(EntryChallengeCreateRequest request) {
        OrtScore ortScore = null;
        InsideTest insideTest = null;
        if (request.getInsideTestId() != null)
            insideTest = insideTestService.retrieve(request.getInsideTestId());
        if (request.getOrtScoreId() != null)
            ortScore = ortScoreService.retrieve(request.getOrtScoreId());
        return entryChallengeMapper.toEntryChallengeResponse(entryChallengeService.create(request, insideTest, ortScore));
    }

    @Override
    @Transactional
    public EntryChallengeResponse update(@NonNull Long id, EntryChallengeUpdateRequest request) {
        OrtScore ortScore = null;
        InsideTest insideTest = null;
        if (request.getInsideTestId() != null)
            insideTest = insideTestService.retrieve(request.getInsideTestId());
        if (request.getOrtScoreId() != null)
            ortScore = ortScoreService.retrieve(request.getOrtScoreId());
        return entryChallengeMapper.toEntryChallengeResponse(entryChallengeService.put(id, request, insideTest, ortScore));
    }

    @Override
    @Transactional(readOnly = true)
    public EntryChallengeResponse getById(@NonNull Long id) {
        return entryChallengeMapper.toEntryChallengeResponse(entryChallengeService.retrieve(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<EntryChallengeResponse> getAll() {
        return entryChallengeService.list()
                .stream()
                .map(entryChallengeMapper::toEntryChallengeResponse)
                .collect(Collectors.toList());
    }
}
