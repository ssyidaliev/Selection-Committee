package university.selectioncommittee.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.selectioncommittee.dto.subdivision.faculty.FacultyResponse;
import university.selectioncommittee.entity.subdivision.Faculty;

@Component
public class FacultyMapper {

    public FacultyResponse toFacultyResponse(@NonNull Faculty faculty) {
        return FacultyResponse.builder()
                .id(faculty.getId())
                .title(faculty.getTitle())
                .shortTitle(faculty.getShortTitle())
                .vuzId(faculty.getVuz().getId())
                .build();
    }
}
