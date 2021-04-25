package university.selectioncommittee.service.education;

import university.selectioncommittee.dto.education.educationalinstitution.EducationalInstitutionCreateRequest;
import university.selectioncommittee.dto.education.educationalinstitution.EducationalInstitutionUpdateRequest;
import university.selectioncommittee.entity.education.EducationalInstitution;
import university.selectioncommittee.entity.education.PreviousEducation;

import java.util.List;

public interface EducationalInstitutionService {

    EducationalInstitution create(EducationalInstitutionCreateRequest request, PreviousEducation previousEducation);
    EducationalInstitution put(Long id, EducationalInstitutionUpdateRequest request, PreviousEducation previousEducation);
    EducationalInstitution retrieve(Long id);
    List<EducationalInstitution> list();
}
