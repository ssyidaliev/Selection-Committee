package university.selectioncommittee.controller.enrolleeinfo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.selectioncommittee.dto.enrolleeinfo.passport.PassportCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.passport.PassportResponse;
import university.selectioncommittee.dto.enrolleeinfo.passport.PassportUpdateRequest;
import university.selectioncommittee.endpoint.enrolleinfo.PassportEndpoint;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/passport")
public class PassportController {

    private final PassportEndpoint passportEndpoint;

    public PassportController(PassportEndpoint passportEndpoint) {
        this.passportEndpoint = passportEndpoint;
    }

    @PostMapping
    public ResponseEntity<PassportResponse> create(@RequestBody PassportCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(passportEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PassportResponse> put(@PathVariable Long id, PassportUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(passportEndpoint.update(id, request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PassportResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(passportEndpoint.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<PassportResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(passportEndpoint.getAll());
    }
}
