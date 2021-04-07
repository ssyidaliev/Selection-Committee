package university.selectioncommittee.endpoint.enrolleinfo;

import university.selectioncommittee.dto.enrolleeinfo.passport.PassportCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.passport.PassportResponse;
import university.selectioncommittee.dto.enrolleeinfo.passport.PassportUpdateRequest;

import java.util.List;

public interface PassportEndpoint {
    PassportResponse add(PassportCreateRequest request);
    PassportResponse update(Long id, PassportUpdateRequest request);
    PassportResponse getById(Long id);
    List<PassportResponse> getAll();
}
