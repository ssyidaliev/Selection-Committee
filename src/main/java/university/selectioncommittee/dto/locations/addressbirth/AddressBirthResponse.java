package university.selectioncommittee.dto.locations.addressbirth;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddressBirthResponse {

    private Long id;
    private String republic;
    private String region;
    private String district;
    private String city;
    private String village;
}
