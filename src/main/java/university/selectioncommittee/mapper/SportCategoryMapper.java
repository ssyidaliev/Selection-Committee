package university.selectioncommittee.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.selectioncommittee.dto.enrolleeinfo.sportcategory.SportCategoryResponse;
import university.selectioncommittee.entity.enrolleeinfo.SportCategory;

@Component
public class SportCategoryMapper {

    public SportCategoryResponse toSportCategoryResponse(@NonNull SportCategory sportCategory) {
        return SportCategoryResponse.builder()
                .id(sportCategory.getId())
                .name(sportCategory.getName())
                .category(sportCategory.getCategory())
                .numDoc(sportCategory.getNumDoc())
                .build();
    }
}
