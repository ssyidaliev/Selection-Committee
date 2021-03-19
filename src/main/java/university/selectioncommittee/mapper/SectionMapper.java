package university.selectioncommittee.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.selectioncommittee.dto.subdivision.section.SectionResponse;
import university.selectioncommittee.entity.subdivision.Section;

@Component
public class SectionMapper {

    public SectionResponse toSectionResponse(@NonNull Section section){
        return SectionResponse.builder()
                .id(section.getId())
                .title(section.getTitle())
                .shortTitle(section.getShortTitle())
                .directionId(section.getDirection().getId())
                .build();
    }
}
