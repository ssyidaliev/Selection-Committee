package university.selectioncommittee.controller.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.selectioncommittee.dto.users.parent.ParentCreateRequest;
import university.selectioncommittee.dto.users.parent.ParentResponse;
import university.selectioncommittee.dto.users.parent.ParentUpdateRequest;
import university.selectioncommittee.endpoint.users.ParentEndpoint;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/parent")
public class ParentController {

    private final ParentEndpoint parentEndpoint;

    public ParentController(ParentEndpoint parentEndpoint) {
        this.parentEndpoint = parentEndpoint;
    }

    @PostMapping
    public ResponseEntity<ParentResponse> create(@RequestBody ParentCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(parentEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ParentResponse> put(@PathVariable Long id, ParentUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(parentEndpoint.update(id, request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ParentResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(parentEndpoint.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ParentResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(parentEndpoint.getAll());
    }
}
