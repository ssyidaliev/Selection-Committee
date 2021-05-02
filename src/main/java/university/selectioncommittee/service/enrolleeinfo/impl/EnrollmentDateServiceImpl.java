package university.selectioncommittee.service.enrolleeinfo.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.enrolleeinfo.enrollmentdate.EnrollmentDateCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.enrollmentdate.EnrollmentDateUpdateRequest;
import university.selectioncommittee.entity.enrolleeinfo.EnrollmentDate;
import university.selectioncommittee.entity.subdivision.Direction;
import university.selectioncommittee.exception.ResourceNotFoundException;
import university.selectioncommittee.repository.enrolleeinfo.EnrollmentDateRepository;
import university.selectioncommittee.service.enrolleeinfo.EnrollmentDateService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EnrollmentDateServiceImpl implements EnrollmentDateService {

    private final EnrollmentDateRepository enrollmentDateRepository;

    public EnrollmentDateServiceImpl(EnrollmentDateRepository enrollmentDateRepository) {
        this.enrollmentDateRepository = enrollmentDateRepository;
    }

    @Override
    @Transactional
    public EnrollmentDate create(EnrollmentDateCreateRequest request, @NonNull Direction direction) {
        EnrollmentDate enrollmentDate = new EnrollmentDate();
        enrollmentDate.setDayForm(request.isDayForm());
        enrollmentDate.setLanguagesRus(request.isLanguagesRus());
        enrollmentDate.setStudyForm(request.getStudyForm());
        enrollmentDate.setRecommended(request.isRecommended());
        enrollmentDate.setProtocol(request.getProtocol());
        enrollmentDate.setRecommendedDate(request.getRecommendedDate());
        enrollmentDate.setPaid(request.isPaid());
        enrollmentDate.setConfirmEnrollment(request.isConfirmEnrollment());
        enrollmentDate.setConfirmDate(request.getConfirmDate());
        enrollmentDate.setEnrollment(request.isEnrollment());
        enrollmentDate.setOrderNum(request.getOrderNum());
        enrollmentDate.setOrderDate(request.getOrderDate());
        enrollmentDate.setProtocolNum(request.getProtocolNum());
        enrollmentDate.setProtocolDate(request.getProtocolDate());
        enrollmentDate.setTookDocs(request.isTookDocs());
        enrollmentDate.setTookDocsDate(request.getTookDocsDate());
        enrollmentDate.setDirection(direction);
        enrollmentDate.setCreateAt(LocalDateTime.now());
        return enrollmentDateRepository.save(enrollmentDate);
    }

    @Override
    @Transactional
    public EnrollmentDate put(@NonNull Long id, EnrollmentDateUpdateRequest request, @NonNull Direction direction) {
        EnrollmentDate enrollmentDate = retrieve(id);
        enrollmentDate.setDayForm(request.isDayForm());
        enrollmentDate.setLanguagesRus(request.isLanguagesRus());
        enrollmentDate.setStudyForm(request.getStudyForm());
        enrollmentDate.setRecommended(request.isRecommended());
        enrollmentDate.setProtocol(request.getProtocol());
        enrollmentDate.setRecommendedDate(request.getRecommendedDate());
        enrollmentDate.setPaid(request.isPaid());
        enrollmentDate.setConfirmEnrollment(request.isConfirmEnrollment());
        enrollmentDate.setConfirmDate(request.getConfirmDate());
        enrollmentDate.setEnrollment(request.isEnrollment());
        enrollmentDate.setOrderNum(request.getOrderNum());
        enrollmentDate.setOrderDate(request.getOrderDate());
        enrollmentDate.setProtocolNum(request.getProtocolNum());
        enrollmentDate.setProtocolDate(request.getProtocolDate());
        enrollmentDate.setTookDocs(request.isTookDocs());
        enrollmentDate.setTookDocsDate(request.getTookDocsDate());
        enrollmentDate.setDirection(direction);
        enrollmentDate.setUpdateAt(LocalDateTime.now());
        return enrollmentDateRepository.save(enrollmentDate);
    }

    @Override
    @Transactional(readOnly = true)
    public EnrollmentDate retrieve(@NonNull Long id) {
        return enrollmentDateRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Enrollment Date with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<EnrollmentDate> list() {
        return enrollmentDateRepository.findAll();
    }
}
