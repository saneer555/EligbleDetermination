package insurenceMain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity
@Data
public class CoTriggres {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer coId;
	
	private Integer caseNum;
	
	@Lob
	private byte[] copdf;
	
	private String coStatus;

}
