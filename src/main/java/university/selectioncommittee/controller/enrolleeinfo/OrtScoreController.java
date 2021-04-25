package university.selectioncommittee.controller.enrolleeinfo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.selectioncommittee.dto.enrolleeinfo.ortscore.OrtScoreCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.ortscore.OrtScoreResponse;
import university.selectioncommittee.dto.enrolleeinfo.ortscore.OrtScoreUpdateRequest;
import university.selectioncommittee.endpoint.enrolleinfo.OrtScoreEndpoint;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/orr-score")
public class OrtScoreController {

    private final OrtScoreEndpoint ortScoreEndpoint;

    public OrtScoreController(OrtScoreEndpoint ortScoreEndpoint) {
        this.ortScoreEndpoint = ortScoreEndpoint;
    }

    @PostMapping
    public ResponseEntity<OrtScoreResponse> create(@RequestBody OrtScoreCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ortScoreEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<OrtScoreResponse> put(@PathVariable Long id, OrtScoreUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(ortScoreEndpoint.update(id, request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<OrtScoreResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(ortScoreEndpoint.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<OrtScoreResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(ortScoreEndpoint.getAll());
    }
}
