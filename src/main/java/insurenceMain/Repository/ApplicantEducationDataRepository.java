package insurenceMain.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import insurenceMain.Entity.ApplicantEducationData;

public interface ApplicantEducationDataRepository extends JpaRepository<ApplicantEducationData, Serializable>{
	
	public ApplicantEducationData findByCaseNum(Integer caseNum);

}
