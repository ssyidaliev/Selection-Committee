package university.selectioncommittee.controller.education;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.selectioncommittee.dto.education.education.EducationCreateRequest;
import university.selectioncommittee.dto.education.education.EducationResponse;
import university.selectioncommittee.dto.education.education.EducationUpdateRequest;
import university.selectioncommittee.dto.education.previouseducation.PreviousEducationCreateRequest;
import university.selectioncommittee.dto.education.previouseducation.PreviousEducationResponse;
import university.selectioncommittee.dto.education.previouseducation.PreviousEducationUpdateRequest;
import university.selectioncommittee.endpoint.education.EducationEndpoint;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/education")
public class EducationController {

    private final EducationEndpoint educationEndpoint;

    public EducationController(EducationEndpoint educationEndpoint) {
        this.educationEndpoint = educationEndpoint;
    }

    @PostMapping
    public ResponseEntity<EducationResponse> create(@RequestBody EducationCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(educationEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EducationResponse> put(@PathVariable Long id, EducationUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(educationEndpoint.update(id, request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EducationResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(educationEndpoint.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EducationResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(educationEndpoint.getAll());
    }
}
