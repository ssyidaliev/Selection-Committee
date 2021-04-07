package university.selectioncommittee.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.selectioncommittee.dto.users.parent.ParentResponse;
import university.selectioncommittee.entity.users.Parent;

@Component
public class ParentMapper {

    public ParentResponse toParentResponse(@NonNull Parent parent) {
        return ParentResponse.builder()
                .id(parent.getId())
                .firstName(parent.getFirstName())
                .lastName(parent.getLastName())
                .middleName(parent.getMiddleName())
                .job(parent.getJob())
                .position(parent.getPosition())
                .email(parent.getEmail())
                .phone(parent.getPhone())
                .addressParentId(parent.getAddressParent().getId())
                .build();
    }
}
