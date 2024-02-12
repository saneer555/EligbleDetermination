package insurenceMain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ApplicantIncomeData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer incomeId;
	
	private Double montlySalary;
	
	private Double propertyIncome;
	
	private Double rentIncome;
	
	private Integer caseNum;

}
