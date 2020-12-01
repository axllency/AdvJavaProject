/**
 * Copyright (c) 2020, Alex Freedman
 * All rights reserved.
 * 
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. 
 */
package music.facade;

import java.util.List;

import music.model.Vinyl;

/**
 * ApplicationFacade
 * 
 * The Music Application Facade to all services
 * 
 * @author Alex Freedman
 * @since Created: October 27, 2020
 */
public interface ApplicationFacade {

	public Vinyl createVinyl(Vinyl vinyl);
	
	public List<Vinyl> getVinyls();
	
	public Vinyl updateVinyl(Vinyl vinyl, Integer id);
	
	public void deleteVinylById(Integer id);
	
	public void deleteVinylByEntity(Vinyl vinyl);
	
}
