package insurenceMain.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import insurenceMain.Entity.ApplicantData;

public interface ApplicantDataRepository extends JpaRepository<ApplicantData, Serializable>{
	
	public ApplicantData findByCaseNum(Integer caseNum);

}
