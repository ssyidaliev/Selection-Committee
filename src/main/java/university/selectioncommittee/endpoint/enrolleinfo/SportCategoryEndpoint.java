package university.selectioncommittee.endpoint.enrolleinfo;

import university.selectioncommittee.dto.enrolleeinfo.sportcategory.SportCategoryCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.sportcategory.SportCategoryResponse;
import university.selectioncommittee.dto.enrolleeinfo.sportcategory.SportCategoryUpdateRequest;

import java.util.List;

public interface SportCategoryEndpoint {

    SportCategoryResponse add(SportCategoryCreateRequest request);
    SportCategoryResponse update(Long id, SportCategoryUpdateRequest request);
    SportCategoryResponse getById(Long id);
    List<SportCategoryResponse> getAll();
}
