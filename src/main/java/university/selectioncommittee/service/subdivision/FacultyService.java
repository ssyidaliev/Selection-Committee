package university.selectioncommittee.service.subdivision;

import university.selectioncommittee.dto.subdivision.faculty.FacultyCreateRequest;
import university.selectioncommittee.dto.subdivision.faculty.FacultyUpdateRequest;
import university.selectioncommittee.entity.subdivision.Faculty;
import university.selectioncommittee.entity.subdivision.VUZ;

import java.util.List;

public interface FacultyService {
    Faculty create(FacultyCreateRequest request, VUZ vuz);
    Faculty put(Long id, FacultyUpdateRequest request, VUZ vuz);
    Faculty retrieve(Long id);
    List<Faculty> list();
}
