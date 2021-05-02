package university.selectioncommittee.service.education.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.education.education.EducationCreateRequest;
import university.selectioncommittee.dto.education.education.EducationUpdateRequest;
import university.selectioncommittee.entity.education.Education;
import university.selectioncommittee.entity.education.EducationalInstitution;
import university.selectioncommittee.entity.enrolleeinfo.SportCategory;
import university.selectioncommittee.exception.ResourceNotFoundException;
import university.selectioncommittee.repository.education.EducationRepository;
import university.selectioncommittee.service.education.EducationService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {

    private final EducationRepository educationRepository;

    public EducationServiceImpl(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @Override
    @Transactional
    public Education create(EducationCreateRequest request, SportCategory sportCategory, EducationalInstitution educationalInstitution) {
        Education education = new Education();
        education.setOriginalDiplomaOrCertificate(request.isOriginalDiplomaOrCertificate());
        education.setExcellentStudent(request.isExcellentStudent());
        education.setGoldMedal(request.isGoldMedal());
        education.setPrizeWinner(request.isPrizeWinner());
        education.setDiplomaOrCertificate(request.isDiplomaOrCertificate());
        education.setSerialDiplomaOrCertificate(request.getSerialDiplomaOrCertificate());
        education.setNumDiplomaOrCertificate(request.getNumDiplomaOrCertificate());
        education.setYearOfIssue(request.getYearOfIssue());
        education.setSchoolLanguage(request.getSchoolLanguage());
        education.setForeignLanguage(request.getForeignLanguage());
        education.setOutOfCompetition(request.isOutOfCompetition());
        education.setSportCategory(sportCategory);
        education.setKstuStudent(request.isKstuStudent());
        education.setEducationalInstitution(educationalInstitution);
        education.setCreateAt(LocalDateTime.now());
        return educationRepository.save(education);
    }

    @Override
    @Transactional
    public Education put(@NonNull Long id, EducationUpdateRequest request, SportCategory sportCategory, EducationalInstitution educationalInstitution) {
        Education education = retrieve(id);
        education.setOriginalDiplomaOrCertificate(request.isOriginalDiplomaOrCertificate());
        education.setExcellentStudent(request.isExcellentStudent());
        education.setGoldMedal(request.isGoldMedal());
        education.setPrizeWinner(request.isPrizeWinner());
        education.setDiplomaOrCertificate(request.isDiplomaOrCertificate());
        education.setSerialDiplomaOrCertificate(request.getSerialDiplomaOrCertificate());
        education.setNumDiplomaOrCertificate(request.getNumDiplomaOrCertificate());
        education.setYearOfIssue(request.getYearOfIssue());
        education.setSchoolLanguage(request.getSchoolLanguage());
        education.setForeignLanguage(request.getForeignLanguage());
        education.setOutOfCompetition(request.isOutOfCompetition());
        education.setSportCategory(sportCategory);
        education.setKstuStudent(request.isKstuStudent());
        education.setEducationalInstitution(educationalInstitution);
        education.setUpdateAt(LocalDateTime.now());
        return educationRepository.save(education);
    }

    @Override
    @Transactional(readOnly = true)
    public Education retrieve(@NonNull Long id) {
        return educationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Educational with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Education> list() {
        return educationRepository.findAll();
    }
}
