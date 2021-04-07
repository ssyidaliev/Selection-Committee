package university.selectioncommittee.dto.locations.addressbirth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressBirthCreateRequest {

    private String republic;
    private String region;
    private String district;
    private String city;
    private String village;
}
