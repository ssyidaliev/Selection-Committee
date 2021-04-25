package university.selectioncommittee.service.enrolleeinfo.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.enrolleeinfo.sportcategory.SportCategoryCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.sportcategory.SportCategoryUpdateRequest;
import university.selectioncommittee.entity.enrolleeinfo.SportCategory;
import university.selectioncommittee.exception.ResourceNotFoundException;
import university.selectioncommittee.repository.enrolleeinfo.SportCategoryRepository;
import university.selectioncommittee.service.enrolleeinfo.SportCategoryService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SportCategoryServiceImpl implements SportCategoryService {

    private final SportCategoryRepository sportCategoryRepository;

    public SportCategoryServiceImpl(SportCategoryRepository sportCategoryRepository) {
        this.sportCategoryRepository = sportCategoryRepository;
    }

    @Override
    @Transactional
    public SportCategory create(@NonNull SportCategoryCreateRequest request) {
        SportCategory sportCategory = new SportCategory();
        sportCategory.setName(request.getName());
        sportCategory.setCategory(request.getCategory());
        sportCategory.setNumDoc(request.getNumDoc());
        sportCategory.setCreateAt(LocalDateTime.now());
        return sportCategoryRepository.save(sportCategory);
    }

    @Override
    @Transactional
    public SportCategory put(@NonNull Long id, @NonNull SportCategoryUpdateRequest request) {
        SportCategory sportCategory = retrieve(id);
        sportCategory.setName(request.getName());
        sportCategory.setCategory(request.getCategory());
        sportCategory.setNumDoc(request.getNumDoc());
        sportCategory.setUpdateAt(LocalDateTime.now());
        return sportCategoryRepository.save(sportCategory);
    }

    @Override
    @Transactional(readOnly = true)
    public SportCategory retrieve(@NonNull Long id) {
        return sportCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "SportCategory with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<SportCategory> list() {
        return sportCategoryRepository.findAll();
    }
}
