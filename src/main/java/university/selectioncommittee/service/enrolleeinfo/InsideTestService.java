package university.selectioncommittee.service.enrolleeinfo;

import university.selectioncommittee.dto.enrolleeinfo.insidetest.InsideTestCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.insidetest.InsideTestUpdateRequest;
import university.selectioncommittee.dto.enrolleeinfo.military.MilitaryCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.military.MilitaryUpdateRequest;
import university.selectioncommittee.entity.enrolleeinfo.InsideTest;
import university.selectioncommittee.entity.enrolleeinfo.Military;

import java.util.List;

public interface InsideTestService {
    InsideTest create(InsideTestCreateRequest request);
    InsideTest put(Long id, InsideTestUpdateRequest request);
    InsideTest retrieve(Long id);
    List<InsideTest> list();
}
