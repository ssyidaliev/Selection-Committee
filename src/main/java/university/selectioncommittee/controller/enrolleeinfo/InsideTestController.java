package university.selectioncommittee.controller.enrolleeinfo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.selectioncommittee.dto.enrolleeinfo.insidetest.InsideTestCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.insidetest.InsideTestResponse;
import university.selectioncommittee.dto.enrolleeinfo.insidetest.InsideTestUpdateRequest;
import university.selectioncommittee.endpoint.enrolleinfo.InsideTestEndpoint;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/inside-test")
public class InsideTestController {

    private final InsideTestEndpoint insideTestEndpoint;

    public InsideTestController(InsideTestEndpoint insideTestEndpoint) {
        this.insideTestEndpoint = insideTestEndpoint;
    }

    @PostMapping
    public ResponseEntity<InsideTestResponse> create(@RequestBody InsideTestCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(insideTestEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<InsideTestResponse> put(@PathVariable Long id, InsideTestUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(insideTestEndpoint.update(id, request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<InsideTestResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(insideTestEndpoint.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<InsideTestResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(insideTestEndpoint.getAll());
    }
}
