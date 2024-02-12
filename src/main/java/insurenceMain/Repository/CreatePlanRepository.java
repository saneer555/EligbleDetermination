package insurenceMain.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import insurenceMain.Entity.CreatePlan;

public interface CreatePlanRepository extends JpaRepository<CreatePlan, Serializable>{

}
