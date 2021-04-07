package university.selectioncommittee.dto.locations.addressresidence;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResidenceCreateRequest {

    private String republic;
    private String region;
    private String district;
    private String city;
    private String village;
}
