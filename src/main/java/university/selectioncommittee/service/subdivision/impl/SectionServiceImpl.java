package university.selectioncommittee.service.subdivision.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.subdivision.section.SectionCreateRequest;
import university.selectioncommittee.dto.subdivision.section.SectionUpdateRequest;
import university.selectioncommittee.entity.subdivision.Direction;
import university.selectioncommittee.entity.subdivision.Section;
import university.selectioncommittee.exception.ResourceNotFoundException;
import university.selectioncommittee.repository.subdivision.SectionRepository;
import university.selectioncommittee.service.subdivision.SectionService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    private final SectionRepository sectionRepository;

    public SectionServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    @Transactional
    public Section create(@NonNull SectionCreateRequest request, @NonNull Direction direction) {
        Section section = new Section();
        section.setTitle(request.getTitle());
        section.setShortTitle(request.getShortTitle());
        section.setDirection(direction);
        section.setUpdateAt(LocalDateTime.now());
        return sectionRepository.save(section);
    }

    @Override
    @Transactional
    public Section put(@NonNull Long id, @NonNull SectionUpdateRequest request, @NonNull Direction direction) {
        Section section = retrieve(id);
        section.setTitle(request.getTitle());
        section.setShortTitle(request.getShortTitle());
        section.setDirection(direction);
        section.setUpdateAt(LocalDateTime.now());
        return sectionRepository.save(section);
    }

    @Override
    @Transactional(readOnly = true)
    public Section retrieve(@NonNull Long id) {
        return sectionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Section with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Section> list() {
        return sectionRepository.findAll();
    }

    @Override
    public List<Section> listByFaculty(@NonNull Long directionId) {
        return sectionRepository.findAllByDirectionId(directionId);
    }
}
