package university.selectioncommittee.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.selectioncommittee.dto.enrolleeinfo.ortscore.OrtScoreResponse;
import university.selectioncommittee.entity.enrolleeinfo.OrtScore;

@Component
public class OrtScoreMapper {

    public OrtScoreResponse toOrtScoreResponse(@NonNull OrtScore ortScore) {
        return OrtScoreResponse.builder()
                .id(ortScore.getId())
                .basicScore(ortScore.getBasicScore())
                .kyrSubScore(ortScore.getKyrSubScore())
                .bioSubScore(ortScore.getBioSubScore())
                .phySubScore(ortScore.getPhySubScore())
                .chemSubScore(ortScore.getChemSubScore())
                .mathSubScore(ortScore.getMathSubScore())
                .hisSubScore(ortScore.getHisSubScore())
                .engSubScore(ortScore.getEngSubScore())
                .rusSubScore(ortScore.getBioSubScore())
                .build();
    }
}
