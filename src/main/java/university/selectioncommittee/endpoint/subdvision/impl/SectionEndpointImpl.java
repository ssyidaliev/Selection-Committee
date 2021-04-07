package university.selectioncommittee.endpoint.subdvision.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.subdivision.section.SectionCreateRequest;
import university.selectioncommittee.dto.subdivision.section.SectionResponse;
import university.selectioncommittee.dto.subdivision.section.SectionUpdateRequest;
import university.selectioncommittee.endpoint.subdvision.SectionEndpoint;
import university.selectioncommittee.entity.subdivision.Direction;
import university.selectioncommittee.mapper.SectionMapper;
import university.selectioncommittee.service.subdivision.DirectionService;
import university.selectioncommittee.service.subdivision.SectionService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SectionEndpointImpl implements SectionEndpoint {

    private final SectionService sectionService;
    private final SectionMapper sectionMapper;
    private final DirectionService directionService;

    public SectionEndpointImpl(SectionService sectionService, SectionMapper sectionMapper, DirectionService directionService) {
        this.sectionService = sectionService;
        this.sectionMapper = sectionMapper;
        this.directionService = directionService;
    }

    @Override
    @Transactional
    public SectionResponse add(@NonNull SectionCreateRequest request) {
        Direction direction = directionService.retrieve(request.getDirectionId());
        return sectionMapper.toSectionResponse(sectionService.create(request, direction))  ;
    }

    @Override
    @Transactional
    public SectionResponse update(@NonNull Long id, @NonNull SectionUpdateRequest request) {
        Direction direction = directionService.retrieve(request.getDirectionId());
        return sectionMapper.toSectionResponse(sectionService.put(id, request, direction));
    }

    @Override
    @Transactional(readOnly = true)
    public SectionResponse getById(@NonNull Long id) {
        return sectionMapper.toSectionResponse(sectionService.retrieve(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<SectionResponse> getAll() {
        return sectionService.list()
                .stream()
                .map(sectionMapper::toSectionResponse)
                .collect(Collectors.toList());
    }
}
