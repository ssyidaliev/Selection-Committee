package university.selectioncommittee.controller.locations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.selectioncommittee.dto.locations.addressbirth.AddressBirthCreateRequest;
import university.selectioncommittee.dto.locations.addressbirth.AddressBirthResponse;
import university.selectioncommittee.dto.locations.addressbirth.AddressBirthUpdateRequest;
import university.selectioncommittee.dto.locations.addressresidence.AddressResidenceCreateRequest;
import university.selectioncommittee.dto.locations.addressresidence.AddressResidenceResponse;
import university.selectioncommittee.dto.locations.addressresidence.AddressResidenceUpdateRequest;
import university.selectioncommittee.endpoint.locations.AddressBirthEndpoint;
import university.selectioncommittee.endpoint.locations.AddressResidenceEndpoint;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/address-residence")
public class AddressResidenceController {

    private final AddressResidenceEndpoint addressResidenceEndpoint;

    public AddressResidenceController(AddressResidenceEndpoint addressResidenceEndpoint) {
        this.addressResidenceEndpoint = addressResidenceEndpoint;
    }

    @PostMapping
    public ResponseEntity<AddressResidenceResponse> create(@RequestBody AddressResidenceCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressResidenceEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AddressResidenceResponse> put(@PathVariable Long id, AddressResidenceUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(addressResidenceEndpoint.update(id, request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AddressResidenceResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(addressResidenceEndpoint.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<AddressResidenceResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(addressResidenceEndpoint.getAll());
    }
}
