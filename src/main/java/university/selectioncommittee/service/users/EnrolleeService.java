package university.selectioncommittee.service.users;

import university.selectioncommittee.dto.users.enrollee.EnrolleeCreateRequest;
import university.selectioncommittee.dto.users.enrollee.EnrolleeUpdateRequest;
import university.selectioncommittee.entity.education.Education;
import university.selectioncommittee.entity.enrolleeinfo.*;
import university.selectioncommittee.entity.locations.AddressBirth;
import university.selectioncommittee.entity.locations.AddressLiving;
import university.selectioncommittee.entity.locations.AddressParent;
import university.selectioncommittee.entity.locations.AddressResidence;
import university.selectioncommittee.entity.users.Enrollee;
import university.selectioncommittee.entity.users.Parent;

import java.util.List;

public interface EnrolleeService {
    Enrollee create(EnrolleeCreateRequest request, AddressLiving addressLiving, AddressResidence addressResidence, AddressBirth addressBirth, Parent parent, Percs percs, Passport passport, Military military, EnrollmentDate enrollmentDate, Education education, EntryChallenge entryChallenge);
    Enrollee put(Long id, EnrolleeUpdateRequest request, AddressLiving addressLiving, AddressResidence addressResidence, AddressBirth addressBirth, Parent parent, Percs percs, Passport passport, Military military, EnrollmentDate enrollmentDate, Education education, EntryChallenge entryChallenge);
    Enrollee retrieve(Long id);
    List<Enrollee> list();
}
