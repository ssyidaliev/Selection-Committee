package university.selectioncommittee.controller.subdivision;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.selectioncommittee.dto.subdivision.faculty.FacultyCreateRequest;
import university.selectioncommittee.dto.subdivision.faculty.FacultyResponse;
import university.selectioncommittee.dto.subdivision.faculty.FacultyUpdateRequest;
import university.selectioncommittee.endpoint.subdvision.FacultyEndpoint;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/faculty")
public class FacultyController {

    private final FacultyEndpoint facultyEndpoint;

    public FacultyController(FacultyEndpoint facultyEndpoint) {
        this.facultyEndpoint = facultyEndpoint;
    }

    @PostMapping
    public ResponseEntity<FacultyResponse> create(@RequestBody FacultyCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(facultyEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<FacultyResponse> put(@PathVariable Long id, FacultyUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(facultyEndpoint.update(id, request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<FacultyResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(facultyEndpoint.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<FacultyResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(facultyEndpoint.getAll());
    }
}
