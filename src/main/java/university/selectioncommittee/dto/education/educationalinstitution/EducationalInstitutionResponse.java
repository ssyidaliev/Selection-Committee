package university.selectioncommittee.dto.education.educationalinstitution;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EducationalInstitutionResponse {

    private Long id;
    private String republic;
    private String region;
    private String district;
    private String city;
    private String village;
    private Long previousEducationId;
}
