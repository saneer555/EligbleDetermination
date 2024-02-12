package insurenceMain.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name ="CREATE_PLAN")
public class CreatePlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer planId;
	
	@Column(name ="PLAN_NAME")
	private String planName;
	
	@Column(name = "PLANE_START_DATE")
	private LocalDate planStartDate;
	
	@Column(name = "PLANE_END_DATE")
	private LocalDate planEndDate;
	
	@Column(name = "PLANE_CATEGORY")
	private Integer planCategory;
	
	@Column(name = "PLANE_STATUS")
	private String activeStatus;
	
	@Column(name = "PLANE_CREATED_DATE",updatable = false)
	@CreationTimestamp
	private LocalDate createDate;
	
	@Column(name = "PLANE_UPDATED_DATE",insertable = false)
	@UpdateTimestamp
	private LocalDate updatedDate;
	
	@Column(name = "PLANE_CREATED_BY")
	private LocalDate createBy;
	
	@Column(name = "PLANE_UPDATED_BY")
	private LocalDate updatedBy;

}
