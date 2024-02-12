package insurenceMain.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import insurenceMain.Entity.EligiblityDetermination;

public interface EligibleDeterminationRepository extends JpaRepository<EligiblityDetermination, Serializable>{

}
