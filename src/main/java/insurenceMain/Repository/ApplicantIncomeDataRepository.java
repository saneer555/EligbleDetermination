package insurenceMain.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import insurenceMain.Entity.ApplicantIncomeData;

public interface ApplicantIncomeDataRepository extends JpaRepository<ApplicantIncomeData, Serializable>{
	
	public ApplicantIncomeData findByCaseNum(Integer caseNum);

}
