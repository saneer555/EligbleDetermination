package insurenceMain.Services;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import insurenceMain.Binding.EligibleResponse;
import insurenceMain.Entity.ApplicantChildData;
import insurenceMain.Entity.ApplicantData;
import insurenceMain.Entity.ApplicantEducationData;
import insurenceMain.Entity.ApplicantIncomeData;
import insurenceMain.Entity.CoTriggres;
import insurenceMain.Entity.CreatePlan;
import insurenceMain.Entity.EligiblityDetermination;
import insurenceMain.Entity.UserApp;
import insurenceMain.Repository.ApplicantChildDataRepository;
import insurenceMain.Repository.ApplicantDataRepository;
import insurenceMain.Repository.ApplicantEducationDataRepository;
import insurenceMain.Repository.ApplicantIncomeDataRepository;
import insurenceMain.Repository.CoTriggersRepository;
import insurenceMain.Repository.CreatePlanRepository;
import insurenceMain.Repository.EligibleDeterminationRepository;
import insurenceMain.Repository.UserAppRespository;

@Service
public class EligiblityServicesImpl implements EligiblityServices{

	@Autowired
	private ApplicantDataRepository dataRepo;

	@Autowired
	private CreatePlanRepository planRepo;

	@Autowired
	private ApplicantIncomeDataRepository incomeRepo;

	@Autowired
	private ApplicantEducationDataRepository eduRepo;

	@Autowired
	private ApplicantChildDataRepository childRepo;

	@Autowired
	private UserAppRespository appRepo;

	@Autowired
	private EligibleDeterminationRepository eligRepo;

	@Autowired
	private CoTriggersRepository coRepo;



	@Override
	public EligibleResponse getCitizenData(Integer caseNum) {
		ApplicantData applicantData = dataRepo.findByCaseNum(caseNum);
		String planName = null;
		Integer planId = null;
		Integer appId = null;
		if(applicantData!=null) {
			planId = applicantData.getPlanId();
			appId = applicantData.getAppId();
		}
		Optional<CreatePlan> byId = planRepo.findById(planId);
		if(byId.isPresent()) {
			CreatePlan plan = byId.get();
			planName = plan.getPlanName();
		}

		Optional<UserApp> byId2 = appRepo.findById(appId);
		int age =0;
		UserApp userApp = null;
		if(byId2.isPresent()) {
			userApp=byId2.get();
			LocalDate dob = userApp.getDob();
			LocalDate now = LocalDate.now();
			age = Period.between(dob, now).getYears();

		}


		EligibleResponse planEntity = planEntity(caseNum, planName, age);

		EligiblityDetermination eld = new EligiblityDetermination();

		BeanUtils.copyProperties(planEntity, eld);
		eld.setCaseNum(caseNum);
		eld.setHolderName(userApp.getFullName());
		eld.setHolderSsn(userApp.getSsn());

		eligRepo.save(eld);

		CoTriggres co = new CoTriggres();
		co.setCaseNum(caseNum);
		co.setCoStatus("Pending");

		coRepo.save(co);

		return planEntity;
	}



	private EligibleResponse planEntity(Integer caseNum,String planName, Integer age) {
		EligibleResponse response = new  EligibleResponse();
		response.setPlanName(planName);

		if("SNAP".equals(planName)) {
			ApplicantIncomeData incomeData = incomeRepo.findByCaseNum(caseNum);
			Double montlySalary = incomeData.getMontlySalary();
			if(montlySalary<=300) {
				response.setPlanName("AP");

			}else {
				response.setPlanStatus("DN");
				response.setDenialResion("High Income");
			}



		}else if("CCAP".equals(planName)) {

			boolean ageCondition = true;

			boolean kidsCountCondition = false;

			List<ApplicantChildData> childData = childRepo.findByCaseNum(caseNum);
			if(!childData.isEmpty()) {
				kidsCountCondition = true;
				for(ApplicantChildData childs : childData ) {
					Integer childAge = childs.getChildAge();
					if(childAge > 16) {
						ageCondition = false;
						break;
					}
				}
			}
			ApplicantIncomeData incomeData = incomeRepo.findByCaseNum(caseNum);
			Double montlySalary = incomeData.getMontlySalary();
			if(montlySalary <=300 && kidsCountCondition && ageCondition) {
				response.setPlanStatus("AP");
			}else {
				response.setPlanStatus("DN");
				response.setDenialResion("Not Sastisfed Bussiness Rules");
			}




		}else if("MEDICAID".equalsIgnoreCase(planName)) {
			ApplicantIncomeData incomeData = incomeRepo.findByCaseNum(caseNum);
			Double montlySalary = incomeData.getMontlySalary();
			Double propertyIncome = incomeData.getPropertyIncome();

			if(montlySalary <=300 && propertyIncome ==0) {
				response.setPlanStatus("AP");
			}else {
				response.setPlanStatus("DN");
				response.setDenialResion("High Income");
			}



		}else if("MEDICARE".equalsIgnoreCase(planName)) {


			if(age >= 65) {
				response.setPlanStatus("AP");
			}else {
				response.setPlanStatus("DN");
				response.setDenialResion("Age is Not Matched");
			}
		}


		else if("NJW".equalsIgnoreCase(planName)) {
			ApplicantEducationData findByCaseNum = eduRepo.findByCaseNum(caseNum);
			Integer graduationYear = findByCaseNum.getGraduationYear();
			int year = LocalDate.now().getYear();
			ApplicantIncomeData incomeData = incomeRepo.findByCaseNum(caseNum);
			Double montlySalary = incomeData.getMontlySalary();
			if(montlySalary <= 0 && graduationYear < year) {
				response.setPlanStatus("AP");
			}else {
				response.setPlanStatus("DN");
				response.setDenialResion("Age not Matched");
			}


		}
		if(response.getPlanStatus().equals("AP")) {
			response.setPlanStartDate(LocalDate.now());
			response.setPlanEndDate(LocalDate.now().plusMonths(6));
			response.setBenfitAmount(350.00);

		}
		return response;

	}

}
