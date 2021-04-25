package university.selectioncommittee.endpoint.education;

import university.selectioncommittee.dto.education.educationalinstitution.EducationalInstitutionCreateRequest;
import university.selectioncommittee.dto.education.educationalinstitution.EducationalInstitutionResponse;
import university.selectioncommittee.dto.education.educationalinstitution.EducationalInstitutionUpdateRequest;

import java.util.List;

public interface EducationalInstitutionEndpoint {

    EducationalInstitutionResponse add(EducationalInstitutionCreateRequest request);
    EducationalInstitutionResponse update(Long id, EducationalInstitutionUpdateRequest request);
    EducationalInstitutionResponse getById(Long id);
    List<EducationalInstitutionResponse> getAll();
}
