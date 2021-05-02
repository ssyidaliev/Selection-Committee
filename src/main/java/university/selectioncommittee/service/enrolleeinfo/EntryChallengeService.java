package university.selectioncommittee.service.enrolleeinfo;

import university.selectioncommittee.dto.enrolleeinfo.enrtychallenge.EntryChallengeCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.enrtychallenge.EntryChallengeUpdateRequest;
import university.selectioncommittee.entity.enrolleeinfo.EntryChallenge;
import university.selectioncommittee.entity.enrolleeinfo.InsideTest;
import university.selectioncommittee.entity.enrolleeinfo.OrtScore;

import java.util.List;

public interface EntryChallengeService {
    EntryChallenge create(EntryChallengeCreateRequest request, InsideTest insideTest, OrtScore ortScore);
    EntryChallenge put(Long id, EntryChallengeUpdateRequest request, InsideTest insideTest, OrtScore ortScore);
    EntryChallenge retrieve(Long id);
    List<EntryChallenge> list();
}
