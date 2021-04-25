package university.selectioncommittee.service.education;

import university.selectioncommittee.dto.education.previouseducation.PreviousEducationCreateRequest;
import university.selectioncommittee.dto.education.previouseducation.PreviousEducationUpdateRequest;
import university.selectioncommittee.entity.education.PreviousEducation;

import java.util.List;

public interface PreviousEducationService {
    PreviousEducation create(PreviousEducationCreateRequest request);
    PreviousEducation put(Long id, PreviousEducationUpdateRequest request);
    PreviousEducation retrieve(Long id);
    List<PreviousEducation> list();

}
