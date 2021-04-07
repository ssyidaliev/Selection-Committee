package university.selectioncommittee.endpoint.enrolleinfo.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.enrolleeinfo.passport.PassportCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.passport.PassportResponse;
import university.selectioncommittee.dto.enrolleeinfo.passport.PassportUpdateRequest;
import university.selectioncommittee.endpoint.enrolleinfo.PassportEndpoint;
import university.selectioncommittee.mapper.PassportMapper;
import university.selectioncommittee.service.enrolleeinfo.PassportService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassportEndpointImpl implements PassportEndpoint {

    private final PassportService passportService;
    private final PassportMapper passportMapper;

    public PassportEndpointImpl(PassportService passportService, PassportMapper passportMapper) {
        this.passportService = passportService;
        this.passportMapper = passportMapper;
    }

    @Override
    @Transactional
    public PassportResponse add(@NonNull PassportCreateRequest request) {
        return passportMapper.toPassportResponse(passportService.create(request));
    }

    @Override
    @Transactional
    public PassportResponse update(@NonNull Long id, @NonNull PassportUpdateRequest request) {
        return passportMapper.toPassportResponse(passportService.put(id, request));
    }

    @Override
    @Transactional(readOnly = true)
    public PassportResponse getById(@NonNull Long id) {
        return passportMapper.toPassportResponse(passportService.retrieve(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PassportResponse> getAll() {
        return passportService.list()
                .stream()
                .map(passportMapper::toPassportResponse)
                .collect(Collectors.toList());
    }
}
