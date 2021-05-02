package university.selectioncommittee.repository.enrolleeinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import university.selectioncommittee.entity.enrolleeinfo.EntryChallenge;

public interface EntryChallengeRepository extends JpaRepository<EntryChallenge, Long> {
}
