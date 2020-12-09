package music.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * Vinyl
 * 
 * The Vinyl object
 * 
 * @author Alex Freedman
 * @since Created: December 1, 2020
 */
@Entity
@Data
public class Vinyl {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//album title - required
	@NotBlank
	private String albumTitle;
	
	//album artist - required
	@NotBlank
	private String artist;
	
	//album release date
	private String releaseDate;
	//album serial code
	private String serial;
	//publishing record label
	private String recordLabel;
	//album condition
	private String condition;
}
