package university.selectioncommittee.repository.enrolleeinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import university.selectioncommittee.entity.education.RecruitmentPlan;

public interface RecruitmentPlanRepository extends JpaRepository<RecruitmentPlan, Long> {
}
