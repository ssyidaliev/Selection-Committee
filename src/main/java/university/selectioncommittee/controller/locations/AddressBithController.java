package university.selectioncommittee.controller.locations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.selectioncommittee.dto.locations.addressbirth.AddressBirthCreateRequest;
import university.selectioncommittee.dto.locations.addressbirth.AddressBirthResponse;
import university.selectioncommittee.dto.locations.addressbirth.AddressBirthUpdateRequest;
import university.selectioncommittee.endpoint.locations.AddressBirthEndpoint;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/address-birth")
public class AddressBithController {

    private final AddressBirthEndpoint addressBirthEndpoint;

    public AddressBithController(AddressBirthEndpoint addressBirthEndpoint) {
        this.addressBirthEndpoint = addressBirthEndpoint;
    }

    @PostMapping
    public ResponseEntity<AddressBirthResponse> create(@RequestBody AddressBirthCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressBirthEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AddressBirthResponse> put(@PathVariable Long id, AddressBirthUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(addressBirthEndpoint.update(id, request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AddressBirthResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(addressBirthEndpoint.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<AddressBirthResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(addressBirthEndpoint.getAll());
    }
}
