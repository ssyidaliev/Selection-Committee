package university.selectioncommittee.entity.enrolleeinfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "entry_challenge")
public class EntryChallenge {

    private String passedOrt;
    private String certificateNum;
    private String certificateColor;
    private String sumScore;
    private String tourNum;
    private String afterCollage;
    private String dontAppear;
    private String noSatisfied;
    private String passedInsideTest;
    private String insideTest;
    private LocalDateTime date;
}
