package insurenceMain.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import insurenceMain.Entity.ApplicantChildData;

public interface ApplicantChildDataRepository extends JpaRepository<ApplicantChildData, Serializable>{
	
	public List<ApplicantChildData> findByCaseNum(Integer caseNum);

}
