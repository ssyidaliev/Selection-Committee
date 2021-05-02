package university.selectioncommittee.endpoint.enrolleinfo;

import university.selectioncommittee.dto.enrolleeinfo.enrtychallenge.EntryChallengeCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.enrtychallenge.EntryChallengeResponse;
import university.selectioncommittee.dto.enrolleeinfo.enrtychallenge.EntryChallengeUpdateRequest;

import java.util.List;

public interface EntryChallengeEndpoint {
    EntryChallengeResponse add(EntryChallengeCreateRequest request);
    EntryChallengeResponse update(Long id, EntryChallengeUpdateRequest request);
    EntryChallengeResponse getById(Long id);
    List<EntryChallengeResponse> getAll();
}
