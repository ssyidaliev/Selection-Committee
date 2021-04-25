package university.selectioncommittee.service.education.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.education.previouseducation.PreviousEducationCreateRequest;
import university.selectioncommittee.dto.education.previouseducation.PreviousEducationUpdateRequest;
import university.selectioncommittee.entity.education.PreviousEducation;
import university.selectioncommittee.exception.ResourceNotFoundException;
import university.selectioncommittee.repository.education.PreviousEducationRepository;
import university.selectioncommittee.service.education.PreviousEducationService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PreviousEducationServiceImpl implements PreviousEducationService {

    private final PreviousEducationRepository previousEducationRepository;

    public PreviousEducationServiceImpl(PreviousEducationRepository previousEducationRepository) {
        this.previousEducationRepository = previousEducationRepository;
    }

    @Override
    @Transactional
    public PreviousEducation create(@NonNull PreviousEducationCreateRequest request) {
        PreviousEducation previousEducation = new PreviousEducation();
        previousEducation.setName(request.getName());
        previousEducation.setType(request.getType());
        previousEducation.setCreateAt(LocalDateTime.now());
        return previousEducationRepository.save(previousEducation);
    }

    @Override
    @Transactional
    public PreviousEducation put(@NonNull Long id, @NonNull PreviousEducationUpdateRequest request) {
        PreviousEducation previousEducation = retrieve(id);
        previousEducation.setName(request.getName());
        previousEducation.setType(request.getType());
        previousEducation.setUpdateAt(LocalDateTime.now());
        return previousEducationRepository.save(previousEducation);
    }

    @Override
    @Transactional(readOnly = true)
    public PreviousEducation retrieve(@NonNull Long id) {
        return previousEducationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "PreviousEducation with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PreviousEducation> list() {
        return previousEducationRepository.findAll();
    }
}
