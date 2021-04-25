package university.selectioncommittee.dto.enrolleeinfo.sportcategory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SportCategoryUpdateRequest {

    private Long id;
    private String name;
    private String category;
    private String numDoc;
}
