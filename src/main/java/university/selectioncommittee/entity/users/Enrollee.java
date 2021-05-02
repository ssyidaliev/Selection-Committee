package university.selectioncommittee.entity.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import university.selectioncommittee.entity.base.TimedEntity;
import university.selectioncommittee.entity.education.Education;
import university.selectioncommittee.entity.enrolleeinfo.*;
import university.selectioncommittee.entity.locations.AddressBirth;
import university.selectioncommittee.entity.locations.AddressLiving;
import university.selectioncommittee.entity.locations.AddressResidence;
import university.selectioncommittee.enums.GenderType;

import javax.persistence.*;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "enrollee")
public class Enrollee extends TimedEntity {

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "middle_name")
    private String middleName;

    @NotNull
    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private GenderType gender;

    @ManyToOne
    @JoinColumn(name = "address_living_id")
    private AddressLiving addressLiving;

    @ManyToOne
    @JoinColumn(name = "address_residence_id")
    private AddressResidence addressResidence;

    @ManyToOne
    @JoinColumn(name = "address_birth_id")
    private AddressBirth addressBirth;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "percs_id")
    private Percs percs;

    @ManyToOne
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @ManyToOne
    @JoinColumn(name = "military_id")
    private Military military;

    @ManyToOne
    @JoinColumn(name = "enrollment_date_id")
    private EnrollmentDate enrollmentDate;

    @ManyToOne
    @JoinColumn(name = "education_id")
    private Education education;

    @ManyToOne
    @JoinColumn(name = "entry_challenge_id")
    private EntryChallenge entryChallenge;
}
