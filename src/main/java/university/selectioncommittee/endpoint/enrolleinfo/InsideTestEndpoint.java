package university.selectioncommittee.endpoint.enrolleinfo;

import university.selectioncommittee.dto.enrolleeinfo.insidetest.InsideTestCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.insidetest.InsideTestResponse;
import university.selectioncommittee.dto.enrolleeinfo.insidetest.InsideTestUpdateRequest;

import java.util.List;

public interface InsideTestEndpoint {
    InsideTestResponse add(InsideTestCreateRequest request);
    InsideTestResponse update(Long id, InsideTestUpdateRequest request);
    InsideTestResponse getById(Long id);
    List<InsideTestResponse> getAll();
}
