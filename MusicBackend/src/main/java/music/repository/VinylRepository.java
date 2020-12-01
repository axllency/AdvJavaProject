package music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import music.model.Vinyl;

/**
 * VinylRepository
 * 
 * The repository for Vinyl objects
 * 
 * @author Alex Freedman
 * @since Created: December 1, 2020
 */
@Repository
public interface VinylRepository extends JpaRepository<Vinyl, Integer> {

}
