package insurenceMain.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserApp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	private String fullName;
	
	private String email;
	
	private String mobile;
	
	private String gender;
	
	private LocalDate dob;
	
	private String ssn;
	
	private String sateName;
	
	private String createdBy;
	
	private String updatedBy;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate updatedDate;

}
