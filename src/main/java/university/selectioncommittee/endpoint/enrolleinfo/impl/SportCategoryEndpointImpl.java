package university.selectioncommittee.endpoint.enrolleinfo.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.enrolleeinfo.sportcategory.SportCategoryCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.sportcategory.SportCategoryResponse;
import university.selectioncommittee.dto.enrolleeinfo.sportcategory.SportCategoryUpdateRequest;
import university.selectioncommittee.endpoint.enrolleinfo.SportCategoryEndpoint;
import university.selectioncommittee.mapper.SportCategoryMapper;
import university.selectioncommittee.service.enrolleeinfo.SportCategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportCategoryEndpointImpl implements SportCategoryEndpoint {

    private final SportCategoryService sportCategoryService;
    private final SportCategoryMapper sportCategoryMapper;

    public SportCategoryEndpointImpl(SportCategoryService sportCategoryService, SportCategoryMapper sportCategoryMapper) {
        this.sportCategoryService = sportCategoryService;
        this.sportCategoryMapper = sportCategoryMapper;
    }

    @Override
    @Transactional
    public SportCategoryResponse add(@NonNull SportCategoryCreateRequest request) {
        return sportCategoryMapper.toSportCategoryResponse(sportCategoryService.create(request));
    }

    @Override
    @Transactional
    public SportCategoryResponse update(@NonNull Long id, @NonNull SportCategoryUpdateRequest request) {
        return sportCategoryMapper.toSportCategoryResponse(sportCategoryService.put(id, request));
    }

    @Override
    @Transactional(readOnly = true)
    public SportCategoryResponse getById(@NonNull Long id) {
        return sportCategoryMapper.toSportCategoryResponse(sportCategoryService.retrieve(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<SportCategoryResponse> getAll() {
        return sportCategoryService.list()
                .stream()
                .map(sportCategoryMapper::toSportCategoryResponse)
                .collect(Collectors.toList());
    }
}
