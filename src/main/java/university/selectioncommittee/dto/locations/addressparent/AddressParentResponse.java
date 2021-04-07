package university.selectioncommittee.dto.locations.addressparent;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddressParentResponse {

    private Long id;
    private String republic;
    private String region;
    private String district;
    private String city;
    private String village;
}
