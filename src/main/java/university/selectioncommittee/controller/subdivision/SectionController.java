package university.selectioncommittee.controller.subdivision;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.selectioncommittee.dto.subdivision.section.SectionCreateRequest;
import university.selectioncommittee.dto.subdivision.section.SectionResponse;
import university.selectioncommittee.dto.subdivision.section.SectionUpdateRequest;
import university.selectioncommittee.endpoint.subdvision.SectionEndpoint;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/section")
public class SectionController {

    private final SectionEndpoint sectionEndpoint;

    public SectionController(SectionEndpoint sectionEndpoint) {
        this.sectionEndpoint = sectionEndpoint;
    }

    @PostMapping
    public ResponseEntity<SectionResponse> create(@RequestBody SectionCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sectionEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<SectionResponse> put(@PathVariable Long id, SectionUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(sectionEndpoint.update(id, request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<SectionResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(sectionEndpoint.getById(id));
    }

    @GetMapping(path = "/direction/{directionId}")
    public ResponseEntity<List<SectionResponse>> listByDirection(@PathVariable Long directionId) {
        return ResponseEntity.status(HttpStatus.OK).body(sectionEndpoint.getAllByDirection(directionId));
    }

    @GetMapping
    public ResponseEntity<List<SectionResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(sectionEndpoint.getAll());
    }


}
