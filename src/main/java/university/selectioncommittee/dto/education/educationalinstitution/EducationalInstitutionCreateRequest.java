package university.selectioncommittee.dto.education.educationalinstitution;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EducationalInstitutionCreateRequest {

    private String republic;
    private String region;
    private String district;
    private String city;
    private String village;
    private Long previousEducationId;
}
