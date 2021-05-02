package university.selectioncommittee.endpoint.subdvision;

import university.selectioncommittee.dto.subdivision.direction.DirectionResponse;
import university.selectioncommittee.dto.subdivision.section.SectionCreateRequest;
import university.selectioncommittee.dto.subdivision.section.SectionResponse;
import university.selectioncommittee.dto.subdivision.section.SectionUpdateRequest;

import java.util.List;

public interface SectionEndpoint {
    SectionResponse add(SectionCreateRequest request);
    SectionResponse update(Long id, SectionUpdateRequest request);
    SectionResponse getById(Long id);
    List<SectionResponse> getAll();
    List<SectionResponse> getAllByDirection(Long directionId);
}
