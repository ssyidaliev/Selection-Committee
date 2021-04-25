package university.selectioncommittee.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.selectioncommittee.dto.enrolleeinfo.enrollmentdate.EnrollmentDateResponse;
import university.selectioncommittee.entity.enrolleeinfo.EnrollmentDate;

@Component
public class EnrollmentDateMapper {

    public EnrollmentDateResponse toEnrollmentDateResponse(@NonNull EnrollmentDate enrollmentDate) {
        return EnrollmentDateResponse.builder()
                .id(enrollmentDate.getId())
                .dayForm(enrollmentDate.isDayForm())
                .languagesRus(enrollmentDate.isLanguagesRus())
                .studyForm(enrollmentDate.getStudyForm())
                .recommended(enrollmentDate.isRecommended())
                .protocol(enrollmentDate.getProtocol())
                .recommendedDate(enrollmentDate.getRecommendedDate())
                .paid(enrollmentDate.isPaid())
                .confirmEnrollment(enrollmentDate.isConfirmEnrollment())
                .confirmDate(enrollmentDate.getConfirmDate())
                .enrollment(enrollmentDate.getEnrollment())
                .orderNum(enrollmentDate.getOrderNum())
                .orderDate(enrollmentDate.getOrderDate())
                .protocolNum(enrollmentDate.getProtocolNum())
                .protocolDate(enrollmentDate.getProtocolDate())
                .tookDocs(enrollmentDate.isTookDocs())
                .tookDocsDate(enrollmentDate.getTookDocsDate())
                .directionId(enrollmentDate.getDirection().getId())
                .build();
    }
}
