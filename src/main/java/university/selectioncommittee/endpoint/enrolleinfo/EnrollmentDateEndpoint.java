package university.selectioncommittee.endpoint.enrolleinfo;

import university.selectioncommittee.dto.enrolleeinfo.enrollmentdate.EnrollmentDateCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.enrollmentdate.EnrollmentDateResponse;
import university.selectioncommittee.dto.enrolleeinfo.enrollmentdate.EnrollmentDateUpdateRequest;

import java.util.List;

public interface EnrollmentDateEndpoint {
    EnrollmentDateResponse add(EnrollmentDateCreateRequest request);
    EnrollmentDateResponse update(Long id, EnrollmentDateUpdateRequest request);
    EnrollmentDateResponse getById(Long id);
    List<EnrollmentDateResponse> getAll();
}
