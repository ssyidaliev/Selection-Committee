package university.selectioncommittee.service.subdivision.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import university.selectioncommittee.dto.subdivision.vuz.VuzCreateRequest;
import university.selectioncommittee.dto.subdivision.vuz.VuzUpdateRequest;
import university.selectioncommittee.entity.subdivision.VUZ;
import university.selectioncommittee.exception.ResourceNotFoundException;
import university.selectioncommittee.repository.subdivision.VuzRepository;
import university.selectioncommittee.service.subdivision.VuzService;

import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class VuzServiceImpl implements VuzService {

    private final VuzRepository vuzRepository;

    public VuzServiceImpl(VuzRepository vuzRepository) {
        this.vuzRepository = vuzRepository;
    }

    @Override
    @Transactional
    public VUZ create(@NonNull VuzCreateRequest request) {
        VUZ vuz = new VUZ();
        vuz.setTitle(request.getTitle());
        vuz.setShortTitle(request.getShortTitle());
        vuz.setAddress(request.getAddress());
        vuz.setCreateAt(LocalDateTime.now());
        return vuzRepository.save(vuz);
    }

    @Override
    @Transactional
    public VUZ put(@NonNull Long id, @NonNull VuzUpdateRequest request) {
        VUZ vuz = retrieve(id);
        vuz.setTitle(request.getTitle());
        vuz.setShortTitle(request.getShortTitle());
        vuz.setAddress(request.getAddress());
        vuz.setUpdateAt(LocalDateTime.now());
        return vuzRepository.save(vuz);
    }

    @Override
    @Transactional(readOnly=true)
    public VUZ retrieve(@NonNull Long id) {
        return vuzRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "VUZ with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<VUZ> list() {
        return vuzRepository.findAll();
    }
}
