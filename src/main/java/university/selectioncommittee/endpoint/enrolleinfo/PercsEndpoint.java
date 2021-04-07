package university.selectioncommittee.endpoint.enrolleinfo;

import university.selectioncommittee.dto.enrolleeinfo.passport.PassportResponse;
import university.selectioncommittee.dto.enrolleeinfo.percs.PercsCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.percs.PercsResponse;
import university.selectioncommittee.dto.enrolleeinfo.percs.PercsUpdateRequest;

import java.util.List;

public interface PercsEndpoint {

    PercsResponse add(PercsCreateRequest request);
    PercsResponse update(Long id, PercsUpdateRequest request);
    PercsResponse getById(Long id);
    List<PercsResponse> getAll();
}
