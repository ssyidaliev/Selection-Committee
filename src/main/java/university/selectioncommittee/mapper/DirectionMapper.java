package university.selectioncommittee.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.selectioncommittee.dto.subdivision.direction.DirectionResponse;
import university.selectioncommittee.entity.subdivision.Direction;

@Component
public class DirectionMapper {

    public DirectionResponse toDirectionResponse(@NonNull Direction direction){
        return DirectionResponse.builder()
                .id(direction.getId())
                .cipher(direction.getCipher())
                .title(direction.getTitle())
                .shortTitle(direction.getShortTitle())
                .facultyId(direction.getFaculty().getId())
                .build();
    }
}
