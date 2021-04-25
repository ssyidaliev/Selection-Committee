package university.selectioncommittee.endpoint.enrolleinfo;

import university.selectioncommittee.dto.enrolleeinfo.ortscore.OrtScoreCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.ortscore.OrtScoreResponse;
import university.selectioncommittee.dto.enrolleeinfo.ortscore.OrtScoreUpdateRequest;

import java.util.List;

public interface OrtScoreEndpoint {
    OrtScoreResponse add(OrtScoreCreateRequest request);
    OrtScoreResponse update(Long id, OrtScoreUpdateRequest request);
    OrtScoreResponse getById(Long id);
    List<OrtScoreResponse> getAll();
}
