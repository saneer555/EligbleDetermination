package insurenceMain.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class EligiblityDetermination {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eligibleId;
	
	private Integer caseNum;
	
	private String planName;
	
	private String planStatus;
	
	private LocalDate planStartDate;
	
	private LocalDate planEndDate;
	
	private Double benfitAmount;
	
	private String denialResion;
	
	private String holderName;
	
	private String holderSsn;
	
	private LocalDate createdDate;
	
	private LocalDate updatedDate;
	
	private String createdBy;
	
	private String updatedBy;

}
