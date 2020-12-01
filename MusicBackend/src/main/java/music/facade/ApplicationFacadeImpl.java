/**
 * Copyright (c) 2020, Alex Freedman
 * All rights reserved.
 * 
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. 
 */
package music.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import music.model.Vinyl;
import music.repository.VinylRepository;
import music.service.SpotifyService;
import music.service.VinylService;

/**
 * ApplicationFacade
 * 
 * The Music Application Facade Implementation for access to all services.
 */
@Component
public class ApplicationFacadeImpl implements ApplicationFacade {
	
	@Autowired
	private VinylService vinylService;
	
	public Vinyl createVinyl(Vinyl vinyl) {
		return vinylService.createVinyl(vinyl);
	}
	
	public List<Vinyl> getVinyls() {
		return vinylService.getVinyls();
	}
	
	public Vinyl updateVinyl(Vinyl vinyl, Integer id) {
		return vinylService.updateVinyl(vinyl, id);
	}
	
	public void deleteVinylById(Integer id) {
		vinylService.deleteVinylById(id);
	}
	
	public void deleteVinylByEntity(Vinyl vinyl) {
		vinylService.deleteVinylByEntity(vinyl);
	}
}
