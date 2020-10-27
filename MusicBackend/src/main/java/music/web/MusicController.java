/**
 * Copyright (c) 2020, Alex Freedman
 * All rights reserved.
 * 
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. 
 */
package music.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import music.facade.ApplicationFacade;

@RestController
@CrossOrigin("*")
@RequestMapping("music")
public class MusicController {

	@Autowired
	private ApplicationFacade facade;
	
	//Need a C/U method that takes the contents of spotify queries. Object per query? Or leave as Json
	//Read: will need db queries for different params: artist/album by song name/ etc
	//delete update that deletes all of a user's information
	
	
	
}
