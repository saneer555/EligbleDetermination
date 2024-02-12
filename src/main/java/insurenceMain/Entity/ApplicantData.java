package insurenceMain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ApplicantData {
	
	private Integer appId;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer caseNum;
	
	private String planName;
	
	private Integer planId;
	
	

}
