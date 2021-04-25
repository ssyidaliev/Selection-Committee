package university.selectioncommittee.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.selectioncommittee.dto.enrolleeinfo.insidetest.InsideTestResponse;
import university.selectioncommittee.entity.enrolleeinfo.InsideTest;

@Component
public class InsideTestMapper {

    public InsideTestResponse toInsideTestResponse(@NonNull InsideTest insideTest) {
        return InsideTestResponse.builder()
                .id(insideTest.getId())
                .passedByOrtResult(insideTest.isPassedByOrtResult())
                .reqScore(insideTest.getReqScore())
                .placeNum(insideTest.getPlaceNum())
                .placeCount(insideTest.getPlaceCount())
                .build();
    }
}
