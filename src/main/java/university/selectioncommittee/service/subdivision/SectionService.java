package university.selectioncommittee.service.subdivision;

import university.selectioncommittee.dto.subdivision.section.SectionCreateRequest;
import university.selectioncommittee.dto.subdivision.section.SectionUpdateRequest;
import university.selectioncommittee.entity.subdivision.Direction;
import university.selectioncommittee.entity.subdivision.Section;

import java.util.List;

public interface SectionService {
    Section create(SectionCreateRequest request, Direction direction);
    Section put(Long id, SectionUpdateRequest request, Direction direction);
    Section retrieve(Long id);
    List<Section> list();
}
