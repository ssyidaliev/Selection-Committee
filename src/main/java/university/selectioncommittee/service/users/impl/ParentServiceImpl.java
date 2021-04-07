package university.selectioncommittee.service.users.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.users.parent.ParentCreateRequest;
import university.selectioncommittee.dto.users.parent.ParentUpdateRequest;
import university.selectioncommittee.entity.locations.AddressParent;
import university.selectioncommittee.entity.users.Parent;
import university.selectioncommittee.exception.ResourceNotFoundException;
import university.selectioncommittee.repository.users.ParentRepository;
import university.selectioncommittee.service.users.ParentService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepository;

    public ParentServiceImpl(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    @Transactional
    public Parent create(@NonNull ParentCreateRequest request, @NonNull AddressParent addressParent) {
        Parent parent = new Parent();
        parent.setFirstName(request.getFirstName());
        parent.setLastName(request.getLastName());
        parent.setMiddleName(request.getMiddleName());
        parent.setJob(request.getJob());
        parent.setPosition(request.getPosition());
        parent.setEmail(request.getEmail());
        parent.setAddressParent(addressParent);
        parent.setCreateAt(LocalDateTime.now());
        return parentRepository.save(parent);
    }

    @Override
    @Transactional
    public Parent put(@NonNull Long id, @NonNull ParentUpdateRequest request, @NonNull AddressParent addressParent) {
        Parent parent = retrieve(id);
        parent.setFirstName(request.getFirstName());
        parent.setLastName(request.getLastName());
        parent.setMiddleName(request.getMiddleName());
        parent.setJob(request.getJob());
        parent.setPosition(request.getPosition());
        parent.setEmail(request.getEmail());
        parent.setAddressParent(addressParent);
        parent.setUpdateAt(LocalDateTime.now());
        return parentRepository.save(parent);
    }

    @Override
    @Transactional(readOnly = true)
    public Parent retrieve(@NonNull Long id) {
        return parentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Parent with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Parent> list() {
        return parentRepository.findAll();
    }
}
