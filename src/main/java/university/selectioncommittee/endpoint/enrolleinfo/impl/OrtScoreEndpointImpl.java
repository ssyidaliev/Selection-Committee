package university.selectioncommittee.endpoint.enrolleinfo.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.enrolleeinfo.ortscore.OrtScoreCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.ortscore.OrtScoreResponse;
import university.selectioncommittee.dto.enrolleeinfo.ortscore.OrtScoreUpdateRequest;
import university.selectioncommittee.endpoint.enrolleinfo.OrtScoreEndpoint;
import university.selectioncommittee.mapper.OrtScoreMapper;
import university.selectioncommittee.service.enrolleeinfo.OrtScoreService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrtScoreEndpointImpl implements OrtScoreEndpoint {

    private final OrtScoreService ortScoreService;
    private final OrtScoreMapper ortScoreMapper;

    public OrtScoreEndpointImpl(OrtScoreService ortScoreService, OrtScoreMapper ortScoreMapper) {
        this.ortScoreService = ortScoreService;
        this.ortScoreMapper = ortScoreMapper;
    }

    @Override
    @Transactional
    public OrtScoreResponse add(@NonNull OrtScoreCreateRequest request) {
        return ortScoreMapper.toOrtScoreResponse(ortScoreService.create(request));
    }

    @Override
    @Transactional
    public OrtScoreResponse update(@NonNull Long id, @NonNull OrtScoreUpdateRequest request) {
        return ortScoreMapper.toOrtScoreResponse(ortScoreService.put(id, request));
    }

    @Override
    @Transactional(readOnly = true)
    public OrtScoreResponse getById(@NonNull Long id) {
        return ortScoreMapper.toOrtScoreResponse(ortScoreService.retrieve(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrtScoreResponse> getAll() {
        return ortScoreService.list()
                .stream()
                .map(ortScoreMapper::toOrtScoreResponse)
                .collect(Collectors.toList());
    }
}
