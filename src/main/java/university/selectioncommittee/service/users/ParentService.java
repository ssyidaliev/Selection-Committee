package university.selectioncommittee.service.users;

import university.selectioncommittee.dto.users.parent.ParentCreateRequest;
import university.selectioncommittee.dto.users.parent.ParentUpdateRequest;
import university.selectioncommittee.entity.locations.AddressParent;
import university.selectioncommittee.entity.users.Parent;

import java.util.List;

public interface ParentService {

    Parent create(ParentCreateRequest request, AddressParent addressParent);
    Parent put(Long id, ParentUpdateRequest request, AddressParent addressParent);
    Parent retrieve(Long id);
    List<Parent> list();
}
