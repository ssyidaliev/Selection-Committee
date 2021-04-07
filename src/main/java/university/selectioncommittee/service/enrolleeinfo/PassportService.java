package university.selectioncommittee.service.enrolleeinfo;

import university.selectioncommittee.dto.enrolleeinfo.passport.PassportCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.passport.PassportUpdateRequest;
import university.selectioncommittee.entity.enrolleeinfo.Passport;

import java.util.List;

public interface PassportService {
    Passport create(PassportCreateRequest request);
    Passport put(Long id, PassportUpdateRequest request);
    Passport retrieve(Long id);
    List<Passport> list();
}
