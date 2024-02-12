package insurenceMain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ApplicantEducationData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer educationId;
	
	private Integer caseNum;
	
	private String higestDegree;
	
	private String universityName;
	
	private Integer graduationYear;

}
