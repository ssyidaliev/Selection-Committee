package university.selectioncommittee.dto.locations.addressresidence;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddressResidenceResponse {

    private Long id;
    private String republic;
    private String region;
    private String district;
    private String city;
    private String village;
}
