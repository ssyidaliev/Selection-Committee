package university.selectioncommittee.dto.enrolleeinfo.sportcategory;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SportCategoryResponse {

    private Long id;
    private String name;
    private String category;
    private String numDoc;
}
