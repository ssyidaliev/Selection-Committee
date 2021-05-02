package university.selectioncommittee.endpoint.education;

import university.selectioncommittee.dto.education.education.EducationCreateRequest;
import university.selectioncommittee.dto.education.education.EducationResponse;
import university.selectioncommittee.dto.education.education.EducationUpdateRequest;

import java.util.List;

public interface EducationEndpoint {

    EducationResponse add(EducationCreateRequest request);
    EducationResponse update(Long id, EducationUpdateRequest request);
    EducationResponse getById(Long id);
    List<EducationResponse> getAll();
}
