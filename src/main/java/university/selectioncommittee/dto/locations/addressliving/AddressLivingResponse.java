package university.selectioncommittee.dto.locations.addressliving;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddressLivingResponse {

    private Long id;
    private String republic;
    private String region;
    private String district;
    private String city;
    private String village;
    private String phone;
}
