package university.selectioncommittee.service.enrolleeinfo.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.enrolleeinfo.percs.PercsCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.percs.PercsUpdateRequest;
import university.selectioncommittee.entity.enrolleeinfo.Percs;
import university.selectioncommittee.exception.ResourceNotFoundException;
import university.selectioncommittee.repository.enrolleeinfo.PercsRepository;
import university.selectioncommittee.service.enrolleeinfo.PercsService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PercsServiceImpl implements PercsService {

    private final PercsRepository percsRepository;

    public PercsServiceImpl(PercsRepository percsRepository) {
        this.percsRepository = percsRepository;
    }

    @Override
    @Transactional
    public Percs create(@NonNull PercsCreateRequest request) {
        Percs percs = new Percs();
        percs.setOrphan(request.isOrphan());
        percs.setInvalid(request.isInvalid());
        percs.setCare(request.isCare());
        percs.setEthnicKyr(request.isEthnicKyr());
        percs.setCreateAt(LocalDateTime.now());
        return percsRepository.save(percs);
    }

    @Override
    @Transactional
    public Percs put(@NonNull Long id, @NonNull PercsUpdateRequest request) {
        Percs percs = retrieve(id);
        percs.setOrphan(request.isOrphan());
        percs.setInvalid(request.isInvalid());
        percs.setCare(request.isCare());
        percs.setEthnicKyr(request.isEthnicKyr());
        percs.setUpdateAt(LocalDateTime.now());
        return percsRepository.save(percs);
    }

    @Override
    @Transactional(readOnly = true)
    public Percs retrieve(@NonNull Long id) {
        return percsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Percs with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Percs> list() {
        return percsRepository.findAll();
    }
}
