package university.selectioncommittee.controller.locations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.selectioncommittee.dto.locations.addressbirth.AddressBirthCreateRequest;
import university.selectioncommittee.dto.locations.addressbirth.AddressBirthResponse;
import university.selectioncommittee.dto.locations.addressbirth.AddressBirthUpdateRequest;
import university.selectioncommittee.dto.locations.addressparent.AddressParentCreateRequest;
import university.selectioncommittee.dto.locations.addressparent.AddressParentResponse;
import university.selectioncommittee.dto.locations.addressparent.AddressParentUpdateRequest;
import university.selectioncommittee.endpoint.locations.AddressBirthEndpoint;
import university.selectioncommittee.endpoint.locations.AddressParentEndpoint;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/address-parent")
public class AddressParentController
{

    private final AddressParentEndpoint addressParentEndpoint;

    public AddressParentController(AddressParentEndpoint addressParentEndpoint) {
        this.addressParentEndpoint = addressParentEndpoint;
    }

    @PostMapping
    public ResponseEntity<AddressParentResponse> create(@RequestBody AddressParentCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressParentEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AddressParentResponse> put(@PathVariable Long id, AddressParentUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(addressParentEndpoint.update(id, request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AddressParentResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(addressParentEndpoint.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<AddressParentResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(addressParentEndpoint.getAll());
    }
}
