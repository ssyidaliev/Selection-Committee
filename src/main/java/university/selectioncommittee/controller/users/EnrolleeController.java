package university.selectioncommittee.controller.users;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.selectioncommittee.dto.users.enrollee.EnrolleeCreateRequest;
import university.selectioncommittee.dto.users.enrollee.EnrolleeResponse;
import university.selectioncommittee.dto.users.enrollee.EnrolleeUpdateRequest;
import university.selectioncommittee.dto.users.parent.ParentCreateRequest;
import university.selectioncommittee.dto.users.parent.ParentResponse;
import university.selectioncommittee.dto.users.parent.ParentUpdateRequest;
import university.selectioncommittee.endpoint.users.EnrolleeEndpoint;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/enrollee")
public class EnrolleeController {

    private final EnrolleeEndpoint enrolleeEndpoint;

    public EnrolleeController(EnrolleeEndpoint enrolleeEndpoint) {
        this.enrolleeEndpoint = enrolleeEndpoint;
    }

    @PostMapping
    public ResponseEntity<EnrolleeResponse> create(@RequestBody EnrolleeCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(enrolleeEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EnrolleeResponse> put(@PathVariable Long id, EnrolleeUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(enrolleeEndpoint.update(id, request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EnrolleeResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(enrolleeEndpoint.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EnrolleeResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(enrolleeEndpoint.getAll());
    }
}
