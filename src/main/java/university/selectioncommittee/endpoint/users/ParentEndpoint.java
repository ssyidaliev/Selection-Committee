package university.selectioncommittee.endpoint.users;

import university.selectioncommittee.dto.users.parent.ParentCreateRequest;
import university.selectioncommittee.dto.users.parent.ParentResponse;
import university.selectioncommittee.dto.users.parent.ParentUpdateRequest;

import java.util.List;

public interface ParentEndpoint {
    ParentResponse add(ParentCreateRequest request);
    ParentResponse update(Long id, ParentUpdateRequest request);
    ParentResponse getById(Long id);
    List<ParentResponse> getAll();
}
