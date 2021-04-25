package university.selectioncommittee.service.education.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.education.educationalinstitution.EducationalInstitutionCreateRequest;
import university.selectioncommittee.dto.education.educationalinstitution.EducationalInstitutionUpdateRequest;
import university.selectioncommittee.entity.education.EducationalInstitution;
import university.selectioncommittee.entity.education.PreviousEducation;
import university.selectioncommittee.exception.ResourceNotFoundException;
import university.selectioncommittee.repository.education.EducationalInstitutionRepository;
import university.selectioncommittee.service.education.EducationalInstitutionService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EducationalInstitutionServiceImpl implements EducationalInstitutionService {

    private final EducationalInstitutionRepository educationalInstitutionRepository;

    public EducationalInstitutionServiceImpl(EducationalInstitutionRepository educationalInstitutionRepository) {
        this.educationalInstitutionRepository = educationalInstitutionRepository;
    }

    @Override
    @Transactional
    public EducationalInstitution create(@NonNull EducationalInstitutionCreateRequest request, @NonNull PreviousEducation previousEducation) {
        EducationalInstitution educationalInstitution = new EducationalInstitution();
        educationalInstitution.setRepublic(request.getRepublic());
        educationalInstitution.setRegion(request.getRegion());
        educationalInstitution.setDistrict(request.getDistrict());
        educationalInstitution.setCity(request.getCity());
        educationalInstitution.setVillage(request.getVillage());
        educationalInstitution.setPreviousEducation(previousEducation);
        educationalInstitution.setCreateAt(LocalDateTime.now());
        return educationalInstitutionRepository.save(educationalInstitution);
    }

    @Override
    @Transactional
    public EducationalInstitution put(@NonNull Long id, @NonNull EducationalInstitutionUpdateRequest request, @NonNull PreviousEducation previousEducation) {
        EducationalInstitution educationalInstitution = retrieve(id);
        educationalInstitution.setRepublic(request.getRepublic());
        educationalInstitution.setRegion(request.getRegion());
        educationalInstitution.setDistrict(request.getDistrict());
        educationalInstitution.setCity(request.getCity());
        educationalInstitution.setVillage(request.getVillage());
        educationalInstitution.setPreviousEducation(previousEducation);
        educationalInstitution.setCreateAt(LocalDateTime.now());
        return educationalInstitutionRepository.save(educationalInstitution);
    }

    @Override
    @Transactional(readOnly = true)
    public EducationalInstitution retrieve(@NonNull Long id) {
        return educationalInstitutionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Educational Institution with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<EducationalInstitution> list() {
        return educationalInstitutionRepository.findAll();
    }
}
