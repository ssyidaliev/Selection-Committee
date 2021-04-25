package university.selectioncommittee.controller.education;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.selectioncommittee.dto.education.previouseducation.PreviousEducationCreateRequest;
import university.selectioncommittee.dto.education.previouseducation.PreviousEducationResponse;
import university.selectioncommittee.dto.education.previouseducation.PreviousEducationUpdateRequest;
import university.selectioncommittee.endpoint.education.PreviousEducationEndpoint;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/previous-education")
public class PreviousEducationController {

    private final PreviousEducationEndpoint previousEducationEndpoint;

    public PreviousEducationController(PreviousEducationEndpoint previousEducationEndpoint) {
        this.previousEducationEndpoint = previousEducationEndpoint;
    }

    @PostMapping
    public ResponseEntity<PreviousEducationResponse> create(@RequestBody PreviousEducationCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(previousEducationEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PreviousEducationResponse> put(@PathVariable Long id, PreviousEducationUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(previousEducationEndpoint.update(id, request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PreviousEducationResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(previousEducationEndpoint.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<PreviousEducationResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(previousEducationEndpoint.getAll());
    }
}
