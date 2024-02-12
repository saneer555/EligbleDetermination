package insurenceMain.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import insurenceMain.Binding.EligibleResponse;
import insurenceMain.Services.EligiblityServices;

@RestController
public class EligiblityDeterminationController {
	
	@Autowired
	private EligiblityServices elgServices;
	
	  @GetMapping("/check-eligibility/{caseNum}")
	    public EligibleResponse checkEligibility(@PathVariable Integer caseNum) {
	        return elgServices.getCitizenData(caseNum);
	
	  }	

}
