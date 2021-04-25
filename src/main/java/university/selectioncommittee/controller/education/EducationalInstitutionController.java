package university.selectioncommittee.controller.education;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.selectioncommittee.dto.education.educationalinstitution.EducationalInstitutionCreateRequest;
import university.selectioncommittee.dto.education.educationalinstitution.EducationalInstitutionResponse;
import university.selectioncommittee.dto.education.educationalinstitution.EducationalInstitutionUpdateRequest;
import university.selectioncommittee.endpoint.education.EducationalInstitutionEndpoint;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/educational-institution")
public class EducationalInstitutionController {

    private final EducationalInstitutionEndpoint educationalInstitutionEndpoint;

    public EducationalInstitutionController(EducationalInstitutionEndpoint educationalInstitutionEndpoint) {
        this.educationalInstitutionEndpoint = educationalInstitutionEndpoint;
    }

    @PostMapping
    public ResponseEntity<EducationalInstitutionResponse> create(@RequestBody EducationalInstitutionCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(educationalInstitutionEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EducationalInstitutionResponse> put(@PathVariable Long id, EducationalInstitutionUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(educationalInstitutionEndpoint.update(id, request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EducationalInstitutionResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(educationalInstitutionEndpoint.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EducationalInstitutionResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(educationalInstitutionEndpoint.getAll());
    }
}
