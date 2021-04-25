package university.selectioncommittee.endpoint.education;

import university.selectioncommittee.dto.education.previouseducation.PreviousEducationCreateRequest;
import university.selectioncommittee.dto.education.previouseducation.PreviousEducationResponse;
import university.selectioncommittee.dto.education.previouseducation.PreviousEducationUpdateRequest;

import java.util.List;

public interface PreviousEducationEndpoint {

    PreviousEducationResponse add(PreviousEducationCreateRequest request);
    PreviousEducationResponse update(Long id, PreviousEducationUpdateRequest request);
    PreviousEducationResponse getById(Long id);
    List<PreviousEducationResponse> getAll();
}
