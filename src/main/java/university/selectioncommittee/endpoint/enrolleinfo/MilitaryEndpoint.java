package university.selectioncommittee.endpoint.enrolleinfo;

import university.selectioncommittee.dto.enrolleeinfo.military.MilitaryCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.military.MilitaryResponse;
import university.selectioncommittee.dto.enrolleeinfo.military.MilitaryUpdateRequest;

import java.util.List;

public interface MilitaryEndpoint {
    MilitaryResponse add(MilitaryCreateRequest request);
    MilitaryResponse update(Long id, MilitaryUpdateRequest request);
    MilitaryResponse getById(Long id);
    List<MilitaryResponse> getAll();
}
