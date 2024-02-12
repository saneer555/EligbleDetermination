package insurenceMain.Binding;

import java.time.LocalDate;

import lombok.Data;
@Data
public class EligibleResponse {
	

	private String planName;
	
	private String planStatus;
	
	private LocalDate planStartDate;
	
	private LocalDate planEndDate;
	
	private Double benfitAmount;
	
	private String denialResion;

}
