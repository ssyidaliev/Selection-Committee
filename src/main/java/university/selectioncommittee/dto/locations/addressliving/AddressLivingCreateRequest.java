package university.selectioncommittee.dto.locations.addressliving;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressLivingCreateRequest {

    private String republic;
    private String region;
    private String district;
    private String city;
    private String village;
    private String phone;
}
