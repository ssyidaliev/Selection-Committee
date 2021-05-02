package university.selectioncommittee.endpoint.users.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.users.enrollee.EnrolleeCreateRequest;
import university.selectioncommittee.dto.users.enrollee.EnrolleeResponse;
import university.selectioncommittee.dto.users.enrollee.EnrolleeUpdateRequest;
import university.selectioncommittee.endpoint.users.EnrolleeEndpoint;
import university.selectioncommittee.entity.education.Education;
import university.selectioncommittee.entity.enrolleeinfo.*;
import university.selectioncommittee.entity.locations.AddressBirth;
import university.selectioncommittee.entity.locations.AddressLiving;
import university.selectioncommittee.entity.locations.AddressResidence;
import university.selectioncommittee.entity.users.Parent;
import university.selectioncommittee.mapper.EnrolleeMapper;
import university.selectioncommittee.service.education.EducationService;
import university.selectioncommittee.service.enrolleeinfo.*;
import university.selectioncommittee.service.locations.AddressBirthService;
import university.selectioncommittee.service.locations.AddressLivingService;
import university.selectioncommittee.service.locations.AddressResidenceService;
import university.selectioncommittee.service.users.EnrolleeService;
import university.selectioncommittee.service.users.ParentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrolleeEndpointImpl implements EnrolleeEndpoint {

    private final EnrolleeService enrolleeService;
    private final EnrolleeMapper enrolleeMapper;
    private final AddressLivingService addressLivingService;
    private final AddressResidenceService addressResidenceService;
    private final AddressBirthService addressBirthService;
    private final ParentService parentService;
    private final PercsService percsService;
    private final PassportService passportService;
    private final MilitaryService militaryService;
    private final EnrollmentDateService enrollmentDateService;
    private final EducationService educationService;
    private final EntryChallengeService entryChallengeService;

    public EnrolleeEndpointImpl(EnrolleeService enrolleeService,
                                EnrolleeMapper enrolleeMapper,
                                AddressLivingService addressLivingService,
                                AddressResidenceService addressResidenceService,
                                AddressBirthService addressBirthService,
                                ParentService parentService,
                                PercsService percsService,
                                PassportService passportService,
                                MilitaryService militaryService,
                                EnrollmentDateService enrollmentDateService,
                                EducationService educationService,
                                EntryChallengeService entryChallengeService) {
        this.enrolleeService = enrolleeService;
        this.enrolleeMapper = enrolleeMapper;
        this.addressLivingService = addressLivingService;
        this.addressResidenceService = addressResidenceService;
        this.addressBirthService = addressBirthService;
        this.parentService = parentService;
        this.percsService = percsService;
        this.passportService = passportService;
        this.militaryService = militaryService;
        this.enrollmentDateService = enrollmentDateService;
        this.educationService = educationService;
        this.entryChallengeService = entryChallengeService;
    }

    @Override
    @Transactional
    public EnrolleeResponse add(EnrolleeCreateRequest request) {
        AddressLiving addressLiving = addressLivingService.retrieve(request.getAddressLivingId());
        AddressResidence addressResidence = addressResidenceService.retrieve(request.getAddressResidenceId());
        AddressBirth addressBirth = addressBirthService.retrieve(request.getAddressBirthId());
        Parent parent = parentService.retrieve(request.getParentId());
        Percs percs = percsService.retrieve(request.getPercsId());
        Passport passport = passportService.retrieve(request.getPassportId());
        Military military = militaryService.retrieve(request.getMilitaryId());
        EnrollmentDate enrollmentDate = enrollmentDateService.retrieve(request.getEnrollmentDateId());
        Education education = educationService.retrieve(request.getEducationId());
        EntryChallenge entryChallenge = entryChallengeService.retrieve(request.getEntryChallengeId());
        return enrolleeMapper.toEnrolleeResponse(enrolleeService.create(request, addressLiving, addressResidence, addressBirth, parent, percs, passport, military, enrollmentDate, education, entryChallenge));

    }

    @Override
    @Transactional
    public EnrolleeResponse update(@NonNull Long id, EnrolleeUpdateRequest request) {
        AddressLiving addressLiving = addressLivingService.retrieve(request.getAddressLivingId());
        AddressResidence addressResidence = addressResidenceService.retrieve(request.getAddressResidenceId());
        AddressBirth addressBirth = addressBirthService.retrieve(request.getAddressBirthId());
        Parent parent = parentService.retrieve(request.getParentId());
        Percs percs = percsService.retrieve(request.getPercsId());
        Passport passport = passportService.retrieve(request.getPassportId());
        Military military = militaryService.retrieve(request.getMilitaryId());
        EnrollmentDate enrollmentDate = enrollmentDateService.retrieve(request.getEnrollmentDateId());
        Education education = educationService.retrieve(request.getEducationId());
        EntryChallenge entryChallenge = entryChallengeService.retrieve(request.getEntryChallengeId());
        return enrolleeMapper.toEnrolleeResponse(enrolleeService.put(id, request, addressLiving, addressResidence, addressBirth, parent, percs, passport, military, enrollmentDate, education, entryChallenge));
    }

    @Override
    @Transactional(readOnly = true)
    public EnrolleeResponse getById(@NonNull Long id) {
        return enrolleeMapper.toEnrolleeResponse(enrolleeService.retrieve(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<EnrolleeResponse> getAll() {
        return enrolleeService.list()
                .stream()
                .map(enrolleeMapper::toEnrolleeResponse)
                .collect(Collectors.toList());
    }
}
