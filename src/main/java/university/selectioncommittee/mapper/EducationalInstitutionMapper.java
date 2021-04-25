package university.selectioncommittee.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.selectioncommittee.dto.education.educationalinstitution.EducationalInstitutionResponse;
import university.selectioncommittee.entity.education.EducationalInstitution;

@Component
public class EducationalInstitutionMapper {

    public EducationalInstitutionResponse toEducationalInstitutionResponse(@NonNull EducationalInstitution educationalInstitution) {
        return EducationalInstitutionResponse.builder()
                .id(educationalInstitution.getId())
                .republic(educationalInstitution.getRepublic())
                .region(educationalInstitution.getRegion())
                .district(educationalInstitution.getDistrict())
                .city(educationalInstitution.getCity())
                .village(educationalInstitution.getVillage())
                .build();
    }
}
