package university.selectioncommittee.service.enrolleeinfo;

import university.selectioncommittee.dto.enrolleeinfo.sportcategory.SportCategoryCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.sportcategory.SportCategoryUpdateRequest;
import university.selectioncommittee.entity.enrolleeinfo.SportCategory;

import java.util.List;

public interface SportCategoryService {

    SportCategory create(SportCategoryCreateRequest request);
    SportCategory put(Long id, SportCategoryUpdateRequest request);
    SportCategory retrieve(Long id);
    List<SportCategory> list();
}
