package university.selectioncommittee.service.subdivision;

import university.selectioncommittee.dto.subdivision.direction.DirectionCreateRequest;
import university.selectioncommittee.dto.subdivision.direction.DirectionUpdateRequest;
import university.selectioncommittee.entity.subdivision.Direction;
import university.selectioncommittee.entity.subdivision.Faculty;

import java.util.List;

public interface DirectionService {
    Direction create(DirectionCreateRequest request, Faculty faculty);
    Direction put(Long id, DirectionUpdateRequest request, Faculty faculty);
    Direction retrieve(Long id);
    List<Direction> list();
}
