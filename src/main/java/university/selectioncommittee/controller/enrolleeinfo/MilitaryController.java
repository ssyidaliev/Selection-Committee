package university.selectioncommittee.controller.enrolleeinfo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.selectioncommittee.dto.enrolleeinfo.military.MilitaryCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.military.MilitaryResponse;
import university.selectioncommittee.dto.enrolleeinfo.military.MilitaryUpdateRequest;
import university.selectioncommittee.endpoint.enrolleinfo.MilitaryEndpoint;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/military")
public class MilitaryController {

    private final MilitaryEndpoint militaryEndpoint;

    public MilitaryController(MilitaryEndpoint militaryEndpoint) {
        this.militaryEndpoint = militaryEndpoint;
    }

    @PostMapping
    public ResponseEntity<MilitaryResponse> create(@RequestBody MilitaryCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(militaryEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<MilitaryResponse> put(@PathVariable Long id, MilitaryUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(militaryEndpoint.update(id, request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MilitaryResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(militaryEndpoint.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<MilitaryResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(militaryEndpoint.getAll());
    }
}
