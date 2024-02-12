package insurenceMain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ApplicantChildData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer childId;
	
	private Integer caseNum;
	
	private String childName;
	
	private Integer childAge;
	
	private String childSsn;
}
