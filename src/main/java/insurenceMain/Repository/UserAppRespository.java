package insurenceMain.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import insurenceMain.Entity.UserApp;

public interface UserAppRespository extends JpaRepository<UserApp, Serializable>{

}
