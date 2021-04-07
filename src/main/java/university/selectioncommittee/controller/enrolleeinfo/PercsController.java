package university.selectioncommittee.controller.enrolleeinfo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.selectioncommittee.dto.enrolleeinfo.percs.PercsCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.percs.PercsResponse;
import university.selectioncommittee.dto.enrolleeinfo.percs.PercsUpdateRequest;
import university.selectioncommittee.endpoint.enrolleinfo.PercsEndpoint;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/percs")
public class PercsController {

    private final PercsEndpoint percsEndpoint;

    public PercsController(PercsEndpoint percsEndpoint) {
        this.percsEndpoint = percsEndpoint;
    }

    @PostMapping
    public ResponseEntity<PercsResponse> create(@RequestBody PercsCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(percsEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PercsResponse> put(@PathVariable Long id, PercsUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(percsEndpoint.update(id, request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PercsResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(percsEndpoint.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<PercsResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(percsEndpoint.getAll());
    }
}
