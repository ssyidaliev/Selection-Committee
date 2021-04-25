package university.selectioncommittee.service.enrolleeinfo;

import university.selectioncommittee.dto.enrolleeinfo.ortscore.OrtScoreCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.ortscore.OrtScoreUpdateRequest;
import university.selectioncommittee.entity.enrolleeinfo.OrtScore;

import java.util.List;

public interface OrtScoreService {
    OrtScore create(OrtScoreCreateRequest request);
    OrtScore put(Long id, OrtScoreUpdateRequest request);
    OrtScore retrieve(Long id);
    List<OrtScore> list();
}
