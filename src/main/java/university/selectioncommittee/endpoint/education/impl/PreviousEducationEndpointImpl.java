package university.selectioncommittee.endpoint.education.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.education.previouseducation.PreviousEducationCreateRequest;
import university.selectioncommittee.dto.education.previouseducation.PreviousEducationResponse;
import university.selectioncommittee.dto.education.previouseducation.PreviousEducationUpdateRequest;
import university.selectioncommittee.endpoint.education.PreviousEducationEndpoint;
import university.selectioncommittee.mapper.PreviousEducationMapper;
import university.selectioncommittee.service.education.PreviousEducationService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PreviousEducationEndpointImpl implements PreviousEducationEndpoint {

    private final PreviousEducationService previousEducationService;
    private final PreviousEducationMapper previousEducationMapper;

    public PreviousEducationEndpointImpl(PreviousEducationService previousEducationService, PreviousEducationMapper previousEducationMapper) {
        this.previousEducationService = previousEducationService;
        this.previousEducationMapper = previousEducationMapper;
    }

    @Override
    @Transactional
    public PreviousEducationResponse add(@NonNull PreviousEducationCreateRequest request) {
        return previousEducationMapper.toPreviousEducationResponse(previousEducationService.create(request));
    }

    @Override
    @Transactional
    public PreviousEducationResponse update(@NonNull Long id, @NonNull PreviousEducationUpdateRequest request) {
        return previousEducationMapper.toPreviousEducationResponse(previousEducationService.put(id, request));
    }

    @Override
    @Transactional(readOnly = true)
    public PreviousEducationResponse getById(@NonNull Long id) {
        return previousEducationMapper.toPreviousEducationResponse(previousEducationService.retrieve(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PreviousEducationResponse> getAll() {
        return previousEducationService.list()
                .stream()
                .map(previousEducationMapper::toPreviousEducationResponse)
                .collect(Collectors.toList());
    }
}
