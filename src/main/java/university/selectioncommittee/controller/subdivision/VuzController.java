package university.selectioncommittee.controller.subdivision;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.selectioncommittee.dto.subdivision.vuz.VuzCreateRequest;
import university.selectioncommittee.dto.subdivision.vuz.VuzResponse;
import university.selectioncommittee.dto.subdivision.vuz.VuzUpdateRequest;
import university.selectioncommittee.endpoint.subdvision.VuzEndpoint;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/vuz")
public class VuzController {

    private final VuzEndpoint vuzEndpoint;

    public VuzController(VuzEndpoint vuzEndpoint) {
        this.vuzEndpoint = vuzEndpoint;
    }

    @PostMapping
    public ResponseEntity<VuzResponse> create(@RequestBody VuzCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vuzEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<VuzResponse> put(@PathVariable Long id, @RequestBody VuzUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(vuzEndpoint.update(id, request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<VuzResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(vuzEndpoint.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<VuzResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(vuzEndpoint.getAll());
    }
}
