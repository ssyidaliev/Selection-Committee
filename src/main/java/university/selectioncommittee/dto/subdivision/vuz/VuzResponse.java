package university.selectioncommittee.dto.subdivision.vuz;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VuzResponse {

    private Long id;
    private String title;
    private String shortTitle;
    private String address;
}
