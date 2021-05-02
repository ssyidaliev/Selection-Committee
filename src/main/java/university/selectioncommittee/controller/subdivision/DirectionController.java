package university.selectioncommittee.controller.subdivision;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.selectioncommittee.dto.subdivision.direction.DirectionCreateRequest;
import university.selectioncommittee.dto.subdivision.direction.DirectionResponse;
import university.selectioncommittee.dto.subdivision.direction.DirectionUpdateRequest;
import university.selectioncommittee.endpoint.subdvision.DirectionEndpoint;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/direction")
public class DirectionController {

    private final DirectionEndpoint directionEndpoint;

    public DirectionController(DirectionEndpoint directionEndpoint) {
        this.directionEndpoint = directionEndpoint;
    }

    @PostMapping
    public ResponseEntity<DirectionResponse> create(@RequestBody DirectionCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(directionEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<DirectionResponse> put(@PathVariable Long id, DirectionUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(directionEndpoint.update(id, request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DirectionResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(directionEndpoint.getById(id));
    }

    @GetMapping(path = "/faculty/{facultyId}")
    public ResponseEntity<List<DirectionResponse>> listByFaculty(@PathVariable Long facultyId) {
        return ResponseEntity.status(HttpStatus.OK).body(directionEndpoint.getAllByFaculty(facultyId));
    }

    @GetMapping
    public ResponseEntity<List<DirectionResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(directionEndpoint.getAll());
    }
}
