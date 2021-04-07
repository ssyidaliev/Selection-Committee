package university.selectioncommittee.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.selectioncommittee.dto.enrolleeinfo.percs.PercsResponse;
import university.selectioncommittee.entity.enrolleeinfo.Percs;

@Component
public class PercsMapper {

    public PercsResponse toPercsResponse(@NonNull Percs percs) {
        return PercsResponse.builder()
                .id(percs.getId())
                .orphan(percs.isOrphan())
                .invalid(percs.isInvalid())
                .care(percs.isCare())
                .ethnicKyr(percs.isEthnicKyr())
                .build();
    }
}
