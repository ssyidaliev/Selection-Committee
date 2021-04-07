package university.selectioncommittee.controller.locations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.selectioncommittee.dto.locations.addressliving.AddressLivingCreateRequest;
import university.selectioncommittee.dto.locations.addressliving.AddressLivingResponse;
import university.selectioncommittee.dto.locations.addressliving.AddressLivingUpdateRequest;
import university.selectioncommittee.endpoint.locations.AddressLivingEndpoint;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/address-living")
public class AddressLivingController {

    private final AddressLivingEndpoint addressLivingEndpoint;

    public AddressLivingController(AddressLivingEndpoint addressLivingEndpoint) {
        this.addressLivingEndpoint = addressLivingEndpoint;
    }

    @PostMapping
    public ResponseEntity<AddressLivingResponse> create(@RequestBody AddressLivingCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressLivingEndpoint.add(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AddressLivingResponse> put(@PathVariable Long id, AddressLivingUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(addressLivingEndpoint.update(id, request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AddressLivingResponse> retrieve(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(addressLivingEndpoint.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<AddressLivingResponse>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(addressLivingEndpoint.getAll());
    }
}
