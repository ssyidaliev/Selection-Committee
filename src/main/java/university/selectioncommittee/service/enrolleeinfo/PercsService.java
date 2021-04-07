package university.selectioncommittee.service.enrolleeinfo;

import university.selectioncommittee.dto.enrolleeinfo.percs.PercsCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.percs.PercsUpdateRequest;
import university.selectioncommittee.entity.enrolleeinfo.Percs;

import java.util.List;

public interface PercsService {
    Percs create(PercsCreateRequest request);
    Percs put(Long id, PercsUpdateRequest request);
    Percs retrieve(Long id);
    List<Percs> list();
}
