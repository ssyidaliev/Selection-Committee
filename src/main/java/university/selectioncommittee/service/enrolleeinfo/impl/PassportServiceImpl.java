package university.selectioncommittee.service.enrolleeinfo.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.enrolleeinfo.passport.PassportCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.passport.PassportUpdateRequest;
import university.selectioncommittee.entity.enrolleeinfo.Passport;
import university.selectioncommittee.exception.ResourceNotFoundException;
import university.selectioncommittee.repository.enrolleeinfo.PassportRepository;
import university.selectioncommittee.service.enrolleeinfo.PassportService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PassportServiceImpl implements PassportService {

    private final PassportRepository passportRepository;

    public PassportServiceImpl(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Override
    @Transactional
    public Passport create(@NonNull PassportCreateRequest request) {
        Passport passport = new Passport();
        passport.setSerialNum(request.getSerialNum());
        passport.setMarried(request.getMarried());
        passport.setCitizenship(request.getCitizenship());
        passport.setIssuingAuth(request.getIssuingAuth());
        passport.setGetDateAuth(request.getGetDateAuth());
        passport.setCreateAt(LocalDateTime.now());
        return passportRepository.save(passport);
    }

    @Override
    @Transactional
    public Passport put(@NonNull Long id, @NonNull PassportUpdateRequest request) {
        Passport passport = retrieve(id);
        passport.setSerialNum(request.getSerialNum());
        passport.setMarried(request.getMarried());
        passport.setCitizenship(request.getCitizenship());
        passport.setIssuingAuth(request.getIssuingAuth());
        passport.setGetDateAuth(request.getGetDateAuth());
        passport.setUpdateAt(LocalDateTime.now());
        return passportRepository.save(passport);
    }

    @Override
    @Transactional(readOnly = true)
    public Passport retrieve(@NonNull Long id) {
        return passportRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Passport with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Passport> list() {
        return passportRepository.findAll();
    }
}
