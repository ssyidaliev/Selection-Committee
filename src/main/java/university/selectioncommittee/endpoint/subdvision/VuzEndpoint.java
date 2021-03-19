package university.selectioncommittee.endpoint.subdvision;

import university.selectioncommittee.dto.subdivision.vuz.VuzCreateRequest;
import university.selectioncommittee.dto.subdivision.vuz.VuzResponse;
import university.selectioncommittee.dto.subdivision.vuz.VuzUpdateRequest;

import java.util.List;

public interface VuzEndpoint {
    VuzResponse add(VuzCreateRequest request);
    VuzResponse update(Long id, VuzUpdateRequest request);
    VuzResponse getById(Long id);
    List<VuzResponse> getAll();
}
