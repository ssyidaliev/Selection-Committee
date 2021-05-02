package university.selectioncommittee.service.users.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.users.enrollee.EnrolleeCreateRequest;
import university.selectioncommittee.dto.users.enrollee.EnrolleeUpdateRequest;
import university.selectioncommittee.entity.education.Education;
import university.selectioncommittee.entity.enrolleeinfo.*;
import university.selectioncommittee.entity.locations.AddressBirth;
import university.selectioncommittee.entity.locations.AddressLiving;
import university.selectioncommittee.entity.locations.AddressResidence;
import university.selectioncommittee.entity.users.Enrollee;
import university.selectioncommittee.entity.users.Parent;
import university.selectioncommittee.exception.ResourceNotFoundException;
import university.selectioncommittee.repository.users.EnrolleeRepository;
import university.selectioncommittee.service.users.EnrolleeService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EnrolleeServiceImpl implements EnrolleeService {

    private final EnrolleeRepository enrolleeRepository;

    public EnrolleeServiceImpl(EnrolleeRepository enrolleeRepository) {
        this.enrolleeRepository = enrolleeRepository;
    }

    @Override
    @Transactional
    public Enrollee create(EnrolleeCreateRequest request,
                           @NonNull AddressLiving addressLiving,
                           @NonNull AddressResidence addressResidence,
                           @NonNull AddressBirth addressBirth,
                           @NonNull Parent parent,
                           @NonNull Percs percs,
                           @NonNull Passport passport,
                           @NonNull Military military,
                           @NonNull EnrollmentDate enrollmentDate,
                           @NonNull Education education,
                           @NonNull EntryChallenge entryChallenge) {
        Enrollee enrollee = new Enrollee();
        enrollee.setFirstName(request.getFirstName());
        enrollee.setLastName(request.getLastName());
        enrollee.setMiddleName(request.getMiddleName());
        enrollee.setDob(request.getDob());
        enrollee.setEmail(request.getEmail());
        enrollee.setPhone(request.getPhone());
        enrollee.setGender(request.getGender());
        enrollee.setAddressLiving(addressLiving);
        enrollee.setAddressResidence(addressResidence);
        enrollee.setAddressBirth(addressBirth);
        enrollee.setParent(parent);
        enrollee.setPercs(percs);
        enrollee.setPassport(passport);
        enrollee.setMilitary(military);
        enrollee.setEnrollmentDate(enrollmentDate);
        enrollee.setEducation(education);
        enrollee.setEntryChallenge(entryChallenge);
        enrollee.setUpdateAt(LocalDateTime.now());
        return enrolleeRepository.save(enrollee);
    }

    @Override
    @Transactional
    public Enrollee put(@NonNull Long id,
                        EnrolleeUpdateRequest request,
                        @NonNull AddressLiving addressLiving,
                        @NonNull AddressResidence addressResidence,
                        @NonNull AddressBirth addressBirth,
                        @NonNull Parent parent,
                        @NonNull Percs percs,
                        @NonNull Passport passport,
                        @NonNull Military military,
                        @NonNull EnrollmentDate enrollmentDate,
                        @NonNull Education education,
                        @NonNull EntryChallenge entryChallenge) {
        Enrollee enrollee = retrieve(id);
        enrollee.setFirstName(request.getFirstName());
        enrollee.setLastName(request.getLastName());
        enrollee.setMiddleName(request.getMiddleName());
        enrollee.setDob(request.getDob());
        enrollee.setEmail(request.getEmail());
        enrollee.setPhone(request.getPhone());
        enrollee.setGender(request.getGender());
        enrollee.setAddressLiving(addressLiving);
        enrollee.setAddressResidence(addressResidence);
        enrollee.setAddressBirth(addressBirth);
        enrollee.setParent(parent);
        enrollee.setPercs(percs);
        enrollee.setPassport(passport);
        enrollee.setMilitary(military);
        enrollee.setEnrollmentDate(enrollmentDate);
        enrollee.setEducation(education);
        enrollee.setEntryChallenge(entryChallenge);
        enrollee.setUpdateAt(LocalDateTime.now());
        return enrolleeRepository.save(enrollee);
    }

    @Override
    @Transactional(readOnly = true)
    public Enrollee retrieve(@NonNull Long id) {
        return enrolleeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Enrollee with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Enrollee> list() {
        return enrolleeRepository.findAll();
    }
}
