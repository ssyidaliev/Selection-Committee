package university.selectioncommittee.dto.enrolleeinfo.sportcategory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SportCategoryCreateRequest {

    private String name;
    private String category;
    private String numDoc;
}
