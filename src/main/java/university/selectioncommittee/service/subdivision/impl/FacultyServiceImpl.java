package university.selectioncommittee.service.subdivision.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.subdivision.faculty.FacultyCreateRequest;
import university.selectioncommittee.dto.subdivision.faculty.FacultyUpdateRequest;
import university.selectioncommittee.entity.subdivision.Faculty;
import university.selectioncommittee.entity.subdivision.VUZ;
import university.selectioncommittee.exception.ResourceNotFoundException;
import university.selectioncommittee.repository.subdivision.FacultyRepository;
import university.selectioncommittee.service.subdivision.FacultyService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    @Transactional
    public Faculty create(@NonNull FacultyCreateRequest request, @NonNull VUZ vuz) {
        Faculty faculty = new Faculty();
        faculty.setTitle(request.getTitle());
        faculty.setShortTitle(request.getShortTitle());
        faculty.setVuz(vuz);
        faculty.setCreateAt(LocalDateTime.now());
        return facultyRepository.save(faculty);
    }

    @Override
    @Transactional(readOnly = true)
    public Faculty put(@NonNull Long id, @NonNull FacultyUpdateRequest request, @NonNull VUZ vuz) {
        Faculty faculty = retrieve(id);
        faculty.setTitle(request.getTitle());
        faculty.setShortTitle(request.getShortTitle());
        faculty.setVuz(vuz);
        faculty.setUpdateAt(LocalDateTime.now());
        return facultyRepository.save(faculty);
    }

    @Override
    @Transactional(readOnly = true)
    public Faculty retrieve(@NonNull Long id) {
        return facultyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Faculty with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Faculty> list() {
        return facultyRepository.findAll();
    }
}
