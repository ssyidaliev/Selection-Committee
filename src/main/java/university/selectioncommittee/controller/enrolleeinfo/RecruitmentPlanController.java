package university.selectioncommittee.controller.enrolleeinfo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.selectioncommittee.dto.enrolleeinfo.recruitmentplan.RecruitmentPlanCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.recruitmentplan.RecruitmentPlanResponse;
import university.selectioncommittee.dto.enrolleeinfo.recruitmentplan.RecruitmentPlanUpdateRequest;
import university.selectioncommittee.endpoint.enrolleinfo.RecruitmentPlanEndpoint;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/recruitment-plan")
public class RecruitmentPlanController {

    private final RecruitmentPlanEndpoint recruitmentPlanEndpoint;

    public RecruitmentPlanController(RecruitmentPlanEndpoint recruitmentPlanEndpoint) {
        this.recruitmentPlanEndpoint = recruitmentPlanEndpoint;
    }

    @PostMapping
    public ResponseEntity<RecruitmentPlanResponse> create(@RequestBody RecruitmentPlanCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recruitmentPlanEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<RecruitmentPlanResponse> put(@PathVariable Long id, RecruitmentPlanUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(recruitmentPlanEndpoint.update(id, request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RecruitmentPlanResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(recruitmentPlanEndpoint.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<RecruitmentPlanResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(recruitmentPlanEndpoint.getAll());
    }
}
