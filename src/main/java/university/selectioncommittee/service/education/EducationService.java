package university.selectioncommittee.service.education;

import university.selectioncommittee.dto.education.education.EducationCreateRequest;
import university.selectioncommittee.dto.education.education.EducationUpdateRequest;
import university.selectioncommittee.entity.education.Education;
import university.selectioncommittee.entity.education.EducationalInstitution;
import university.selectioncommittee.entity.enrolleeinfo.SportCategory;

import java.util.List;

public interface EducationService {
    Education create(EducationCreateRequest request, SportCategory sportCategory, EducationalInstitution educationalInstitution);
    Education put(Long id, EducationUpdateRequest request, SportCategory sportCategory, EducationalInstitution educationalInstitution);
    Education retrieve(Long id);
    List<Education> list();

}
