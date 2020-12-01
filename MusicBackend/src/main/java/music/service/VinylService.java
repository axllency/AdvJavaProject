package music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import music.model.Vinyl;
import music.repository.VinylRepository;

@Service
public class VinylService {

		@Autowired
		VinylRepository vinylRepository;
		
		public Vinyl createVinyl(Vinyl vinyl) {
			return vinylRepository.save(vinyl);
		}
		
		public List<Vinyl> getVinyls() {
			return vinylRepository.findAll();
		}
		
		public Vinyl updateVinyl(Vinyl vinyl, Integer id) {
			vinyl.setId(id);
			return vinylRepository.save(vinyl);
		}
		
		public void deleteVinylById(Integer id) {
			vinylRepository.deleteById(id);
		}
		
		public void deleteVinylByEntity(Vinyl vinyl) {
			vinylRepository.delete(vinyl);
		}
}
