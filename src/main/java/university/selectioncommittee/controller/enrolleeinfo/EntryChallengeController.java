package university.selectioncommittee.controller.enrolleeinfo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.selectioncommittee.dto.enrolleeinfo.enrtychallenge.EntryChallengeCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.enrtychallenge.EntryChallengeResponse;
import university.selectioncommittee.dto.enrolleeinfo.enrtychallenge.EntryChallengeUpdateRequest;
import university.selectioncommittee.endpoint.enrolleinfo.EntryChallengeEndpoint;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/entry-challenge")
public class EntryChallengeController {

    private final EntryChallengeEndpoint entryChallengeEndpoint;

    public EntryChallengeController(EntryChallengeEndpoint entryChallengeEndpoint) {
        this.entryChallengeEndpoint = entryChallengeEndpoint;
    }

    @PostMapping
    public ResponseEntity<EntryChallengeResponse> create(@RequestBody EntryChallengeCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(entryChallengeEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EntryChallengeResponse> put(@PathVariable Long id, EntryChallengeUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(entryChallengeEndpoint.update(id, request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EntryChallengeResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(entryChallengeEndpoint.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EntryChallengeResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(entryChallengeEndpoint.getAll());
    }
}
