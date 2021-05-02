package university.selectioncommittee.endpoint.users;

import university.selectioncommittee.dto.users.enrollee.EnrolleeCreateRequest;
import university.selectioncommittee.dto.users.enrollee.EnrolleeResponse;
import university.selectioncommittee.dto.users.enrollee.EnrolleeUpdateRequest;

import java.util.List;

public interface EnrolleeEndpoint {
    EnrolleeResponse add(EnrolleeCreateRequest request);
    EnrolleeResponse update(Long id, EnrolleeUpdateRequest request);
    EnrolleeResponse getById(Long id);
    List<EnrolleeResponse> getAll();
}
