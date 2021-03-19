package university.selectioncommittee.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.selectioncommittee.dto.subdivision.vuz.VuzResponse;
import university.selectioncommittee.entity.subdivision.VUZ;

@Component
public class VuzMapper {

    public VuzResponse toVuzResponse(@NonNull VUZ vuz) {
        return VuzResponse.builder()
                .id(vuz.getId())
                .title(vuz.getTitle())
                .shortTitle(vuz.getShortTitle())
                .address(vuz.getAddress())
                .build();
    }
}
