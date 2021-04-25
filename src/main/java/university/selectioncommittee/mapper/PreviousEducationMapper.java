package university.selectioncommittee.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.selectioncommittee.dto.education.previouseducation.PreviousEducationResponse;
import university.selectioncommittee.entity.education.PreviousEducation;

@Component
public class PreviousEducationMapper {

    public PreviousEducationResponse toPreviousEducationResponse(@NonNull PreviousEducation previousEducation) {
        return PreviousEducationResponse.builder()
                .id(previousEducation.getId())
                .name(previousEducation.getName())
                .type(previousEducation.getName())
                .build();
    }
}
