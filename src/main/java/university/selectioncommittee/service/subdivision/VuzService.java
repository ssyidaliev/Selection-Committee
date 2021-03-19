package university.selectioncommittee.service.subdivision;

import university.selectioncommittee.dto.subdivision.vuz.VuzCreateRequest;
import university.selectioncommittee.dto.subdivision.vuz.VuzUpdateRequest;
import university.selectioncommittee.entity.subdivision.VUZ;

import java.util.List;

public interface VuzService {
    VUZ create(VuzCreateRequest request);
    VUZ put(Long id, VuzUpdateRequest request);
    VUZ retrieve(Long id);
    List<VUZ> list();
}
