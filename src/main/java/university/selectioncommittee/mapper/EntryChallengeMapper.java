package university.selectioncommittee.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.selectioncommittee.dto.enrolleeinfo.enrtychallenge.EntryChallengeResponse;
import university.selectioncommittee.entity.enrolleeinfo.EntryChallenge;

@Component
public class EntryChallengeMapper {

    public EntryChallengeResponse toEntryChallengeResponse(@NonNull EntryChallenge entryChallenge) {
        return EntryChallengeResponse.builder()
                .id(entryChallenge.getId())
                .passedOrt(entryChallenge.isPassedOrt())
                .certificateNum(entryChallenge.getCertificateNum())
                .certificateColor(entryChallenge.getCertificateColor())
                .sumScore(entryChallenge.getSumScore())
                .tourNum(entryChallenge.getTourNum())
                .afterCollage(entryChallenge.isAfterCollage())
                .dontAppear(entryChallenge.isDontAppear())
                .noSatisfied(entryChallenge.isNoSatisfied())
                .passedInsideTest(entryChallenge.isPassedInsideTest())
                .insideTest(entryChallenge.getInsideTest())
                .ortScore(entryChallenge.getOrtScore())
                .build();
    }
}
