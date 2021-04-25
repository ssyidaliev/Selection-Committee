package university.selectioncommittee.service.enrolleeinfo;

import university.selectioncommittee.dto.enrolleeinfo.military.MilitaryCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.military.MilitaryUpdateRequest;
import university.selectioncommittee.entity.enrolleeinfo.Military;

import java.util.List;

public interface MilitaryService {
    Military create(MilitaryCreateRequest request);
    Military put(Long id, MilitaryUpdateRequest request);
    Military retrieve(Long id);
    List<Military> list();
}
