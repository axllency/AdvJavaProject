/**
 * Copyright (c) 2020, Alex Freedman
 * All rights reserved.
 * 
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. 
 */
package music.facade;

import org.springframework.beans.factory.annotation.Autowired;

import music.services.SpotifyService;

/**
 * ApplicationFacade
 * 
 * The Music Application Facade Implementation for access to all services.
 */
public class ApplicationFacadeImpl implements ApplicationFacade {
	
	@Autowired
	private SpotifyService spotifyService;
	
}
