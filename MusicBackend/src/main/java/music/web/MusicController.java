/**
 * Copyright (c) 2020, Alex Freedman
 * All rights reserved.
 * 
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. 
 */
package music.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import music.facade.ApplicationFacade;
import music.model.Vinyl;

@RestController
@CrossOrigin("*")
@RequestMapping("music")
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
public class MusicController {

	@Autowired
	private ApplicationFacade facade;
	
	@PostMapping(path="vinyl")
	public Vinyl createVinyl(@Validated @RequestBody Vinyl vinyl) {
		return facade.createVinyl(vinyl);
	}
	
	@GetMapping(path="vinyl")
	public List<Vinyl> getVinyls() {
		return facade.getVinyls();
	}
	
	@PutMapping(path="vinyl/{id}")
	public Vinyl updateVinyl(@PathVariable("id") Integer id, @Validated @RequestBody Vinyl vinyl) {
		return facade.updateVinyl(vinyl, id);
	}
	
	@DeleteMapping(path="vinyl/{id}")
	public void deleteVinyl(@PathVariable("id") Integer id) {
		facade.deleteVinylById(id);
	}
	
	@GetMapping(path="vinyl/{id}")
	public Vinyl getVinylById(@PathVariable("id") Integer id) {
		return facade.getVinylById(id);
	}
}
