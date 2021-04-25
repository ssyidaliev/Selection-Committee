package university.selectioncommittee.dto.enrolleeinfo.enrollmentdate;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class EnrollmentDateResponse {
    private Long id;
    private boolean dayForm;
    private boolean languagesRus;
    private String studyForm;
    private boolean recommended;
    private String protocol;
    private LocalDate recommendedDate;
    private boolean paid;
    private boolean confirmEnrollment;
    private LocalDate confirmDate;
    private String enrollment;
    private String orderNum;
    private LocalDate orderDate;
    private String protocolNum;
    private LocalDate protocolDate;
    private boolean tookDocs;
    private LocalDate tookDocsDate;
    private Long directionId;
}
