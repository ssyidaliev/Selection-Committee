package university.selectioncommittee.service.subdivision.impl;

import lombok.NonNull;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.subdivision.direction.DirectionCreateRequest;
import university.selectioncommittee.dto.subdivision.direction.DirectionUpdateRequest;
import university.selectioncommittee.entity.subdivision.Direction;
import university.selectioncommittee.exception.ResourceNotFoundException;
import university.selectioncommittee.repository.subdivision.DirectionRepository;
import university.selectioncommittee.service.subdivision.DirectionService;

import java.time.LocalDateTime;
import java.util.List;

public class DirectionServiceImpl implements DirectionService {

    private final DirectionRepository directionRepository;

    public DirectionServiceImpl(DirectionRepository directionRepository) {
        this.directionRepository = directionRepository;
    }

    @Override
    @Transactional
    public Direction create(@NonNull DirectionCreateRequest request) {
        Direction direction = new Direction();
        direction.setCipher(request.getCipher());
        direction.setTitle(request.getTitle());
        direction.setShortTitle(request.getShortTitle());
        direction.setFaculty(request.getFaculty());
        direction.setCreateAt(LocalDateTime.now());
        return directionRepository.save(direction);
    }

    @Override
    @Transactional
    public Direction put(@NonNull Long id, @NonNull DirectionUpdateRequest request) {
        Direction direction = retrieve(id);
        direction.setCipher(request.getCipher());
        direction.setTitle(request.getTitle());
        direction.setShortTitle(request.getShortTitle());
        direction.setFaculty(request.getFaculty());
        direction.setUpdateAt(LocalDateTime.now());
        return directionRepository.save(direction);
    }

    @Override
    @Transactional(readOnly = true)
    public Direction retrieve(@NonNull Long id) {
        return directionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Direction with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Direction> list() {
        return directionRepository.findAll();
    }
}
