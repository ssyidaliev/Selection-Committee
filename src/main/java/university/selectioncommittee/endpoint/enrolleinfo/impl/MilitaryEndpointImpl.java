package university.selectioncommittee.endpoint.enrolleinfo.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.enrolleeinfo.military.MilitaryCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.military.MilitaryResponse;
import university.selectioncommittee.dto.enrolleeinfo.military.MilitaryUpdateRequest;
import university.selectioncommittee.endpoint.enrolleinfo.MilitaryEndpoint;
import university.selectioncommittee.mapper.MilitaryMapper;
import university.selectioncommittee.service.enrolleeinfo.MilitaryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MilitaryEndpointImpl implements MilitaryEndpoint {

    private final MilitaryService militaryService;
    private final MilitaryMapper militaryMapper;

    public MilitaryEndpointImpl(MilitaryService militaryService, MilitaryMapper militaryMapper) {
        this.militaryService = militaryService;
        this.militaryMapper = militaryMapper;
    }

    @Override
    @Transactional
    public MilitaryResponse add(@NonNull MilitaryCreateRequest request) {
        return militaryMapper.toMilitaryResponse(militaryService.create(request));
    }

    @Override
    @Transactional
    public MilitaryResponse update(@NonNull Long id, @NonNull MilitaryUpdateRequest request) {
        return militaryMapper.toMilitaryResponse(militaryService.put(id, request));
    }

    @Override
    @Transactional(readOnly = true)
    public MilitaryResponse getById(@NonNull Long id) {
        return militaryMapper.toMilitaryResponse(militaryService.retrieve(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<MilitaryResponse> getAll() {
        return militaryService.list()
                .stream()
                .map(militaryMapper::toMilitaryResponse)
                .collect(Collectors.toList());
    }
}
