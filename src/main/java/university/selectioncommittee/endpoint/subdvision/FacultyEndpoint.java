package university.selectioncommittee.endpoint.subdvision;

import university.selectioncommittee.dto.subdivision.faculty.FacultyResponse;
import university.selectioncommittee.dto.subdivision.faculty.FacultyCreateRequest;
import university.selectioncommittee.dto.subdivision.faculty.FacultyUpdateRequest;


import java.util.List;

public interface FacultyEndpoint {
    FacultyResponse add(FacultyCreateRequest request);
    FacultyResponse update(Long id, FacultyUpdateRequest request);
    FacultyResponse getById(Long id);
    List<FacultyResponse> getAll();
}
