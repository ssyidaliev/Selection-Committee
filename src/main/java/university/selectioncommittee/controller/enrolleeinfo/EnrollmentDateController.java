package university.selectioncommittee.controller.enrolleeinfo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.selectioncommittee.dto.enrolleeinfo.enrollmentdate.EnrollmentDateCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.enrollmentdate.EnrollmentDateResponse;
import university.selectioncommittee.dto.enrolleeinfo.enrollmentdate.EnrollmentDateUpdateRequest;
import university.selectioncommittee.endpoint.enrolleinfo.EnrollmentDateEndpoint;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/enrollment-date")
public class EnrollmentDateController {

    private final EnrollmentDateEndpoint enrollmentDateEndpoint;

    public EnrollmentDateController(EnrollmentDateEndpoint enrollmentDateEndpoint) {
        this.enrollmentDateEndpoint = enrollmentDateEndpoint;
    }

    @PostMapping
    public ResponseEntity<EnrollmentDateResponse> create(@RequestBody EnrollmentDateCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(enrollmentDateEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EnrollmentDateResponse> put(@PathVariable Long id, EnrollmentDateUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(enrollmentDateEndpoint.update(id, request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EnrollmentDateResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(enrollmentDateEndpoint.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentDateResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(enrollmentDateEndpoint.getAll());
    }
}
