package university.selectioncommittee.controller.enrolleeinfo;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.selectioncommittee.dto.enrolleeinfo.percs.PercsCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.percs.PercsResponse;
import university.selectioncommittee.dto.enrolleeinfo.percs.PercsUpdateRequest;
import university.selectioncommittee.dto.enrolleeinfo.sportcategory.SportCategoryCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.sportcategory.SportCategoryResponse;
import university.selectioncommittee.dto.enrolleeinfo.sportcategory.SportCategoryUpdateRequest;
import university.selectioncommittee.endpoint.enrolleinfo.SportCategoryEndpoint;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/sport-category")
public class SportCategoryController {

    private final SportCategoryEndpoint sportCategoryEndpoint;

    public SportCategoryController(SportCategoryEndpoint sportCategoryEndpoint) {
        this.sportCategoryEndpoint = sportCategoryEndpoint;
    }

    @PostMapping
    public ResponseEntity<SportCategoryResponse> create(@RequestBody SportCategoryCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sportCategoryEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<SportCategoryResponse> put(@PathVariable Long id, SportCategoryUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(sportCategoryEndpoint.update(id, request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<SportCategoryResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(sportCategoryEndpoint.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<SportCategoryResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(sportCategoryEndpoint.getAll());
    }
}
