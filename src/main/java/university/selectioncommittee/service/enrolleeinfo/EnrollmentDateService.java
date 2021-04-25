package university.selectioncommittee.service.enrolleeinfo;

import university.selectioncommittee.dto.enrolleeinfo.enrollmentdate.EnrollmentDateCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.enrollmentdate.EnrollmentDateUpdateRequest;
import university.selectioncommittee.entity.enrolleeinfo.EnrollmentDate;
import university.selectioncommittee.entity.subdivision.Direction;

import java.util.List;

public interface EnrollmentDateService {
    EnrollmentDate create(EnrollmentDateCreateRequest request, Direction direction);
    EnrollmentDate put(Long id, EnrollmentDateUpdateRequest request, Direction direction);
    EnrollmentDate retrieve(Long id);
    List<EnrollmentDate> list();
}
