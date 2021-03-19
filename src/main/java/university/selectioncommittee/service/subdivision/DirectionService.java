package university.selectioncommittee.service.subdivision;

import university.selectioncommittee.dto.subdivision.direction.DirectionCreateRequest;
import university.selectioncommittee.dto.subdivision.direction.DirectionUpdateRequest;
import university.selectioncommittee.entity.subdivision.Direction;

import java.util.List;

public interface DirectionService {
    Direction create(DirectionCreateRequest request);
    Direction put(Long id, DirectionUpdateRequest request);
    Direction retrieve(Long id);
    List<Direction> list();
}
