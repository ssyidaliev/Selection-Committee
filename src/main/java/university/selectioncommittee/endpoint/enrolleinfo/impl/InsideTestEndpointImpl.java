package university.selectioncommittee.endpoint.enrolleinfo.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.enrolleeinfo.insidetest.InsideTestCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.insidetest.InsideTestResponse;
import university.selectioncommittee.dto.enrolleeinfo.insidetest.InsideTestUpdateRequest;
import university.selectioncommittee.endpoint.enrolleinfo.InsideTestEndpoint;
import university.selectioncommittee.mapper.InsideTestMapper;
import university.selectioncommittee.service.enrolleeinfo.InsideTestService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsideTestEndpointImpl implements InsideTestEndpoint {

    private final InsideTestService insideTestService;
    private final InsideTestMapper insideTestMapper;

    public InsideTestEndpointImpl(InsideTestService insideTestService, InsideTestMapper insideTestMapper) {
        this.insideTestService = insideTestService;
        this.insideTestMapper = insideTestMapper;
    }

    @Override
    @Transactional
    public InsideTestResponse add(@NonNull InsideTestCreateRequest request) {
        return insideTestMapper.toInsideTestResponse(insideTestService.create(request));
    }

    @Override
    @Transactional
    public InsideTestResponse update(@NonNull Long id, @NonNull  InsideTestUpdateRequest request) {
        return insideTestMapper.toInsideTestResponse(insideTestService.put(id, request));
    }

    @Override
    @Transactional(readOnly = true)
    public InsideTestResponse getById(@NonNull Long id) {
        return insideTestMapper.toInsideTestResponse(insideTestService.retrieve(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<InsideTestResponse> getAll() {
        return insideTestService.list()
                .stream()
                .map(insideTestMapper::toInsideTestResponse)
                .collect(Collectors.toList());
    }
}
