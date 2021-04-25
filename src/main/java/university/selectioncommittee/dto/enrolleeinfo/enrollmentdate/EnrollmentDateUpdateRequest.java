package university.selectioncommittee.dto.enrolleeinfo.enrollmentdate;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EnrollmentDateUpdateRequest {
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
