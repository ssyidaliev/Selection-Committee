package university.selectioncommittee.endpoint.subdvision;

import university.selectioncommittee.dto.subdivision.direction.DirectionCreateRequest;
import university.selectioncommittee.dto.subdivision.direction.DirectionResponse;
import university.selectioncommittee.dto.subdivision.direction.DirectionUpdateRequest;

import java.util.List;

public interface DirectionEndpoint {
    DirectionResponse add(DirectionCreateRequest request);
    DirectionResponse update(Long id, DirectionUpdateRequest request);
    DirectionResponse getById(Long id);
    List<DirectionResponse> getAll();
    List<DirectionResponse> getAllByFaculty(Long facultyId);
}
