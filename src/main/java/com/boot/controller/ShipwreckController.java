package com.boot.controller;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ShipwreckController {

	@Autowired
	private ShipwreckRepository shipwreckRepository;

	@RequestMapping(value = "shipwrecks", method = RequestMethod.GET) //expecting a GET only to api/v1/shipwreck

	public List<Shipwreck> list() {
		//return ShipwreckStub.list();
		//now that we arnt using a stub anymore replace the stubs with the repository (this might break the app)
		//so the app still rusn the but endpoints of course dont actually work. database isnt working
		return shipwreckRepository.findAll();

	}

	@RequestMapping(value = "shipwrecks", method = RequestMethod.POST)

	public Shipwreck create(@RequestBody Shipwreck shipwreck) {
		//return ShipwreckStub.create(shipwreck);
		return shipwreckRepository.saveAndFlush(shipwreck);

	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)

	public Shipwreck get(@PathVariable Long id) {
		//return ShipwreckStub.get(id);
		return shipwreckRepository.findOne(id);

	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)

	public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
		//return ShipwreckStub.update(id, shipwreck);
		Shipwreck existingShipwreck = shipwreckRepository.findOne(id);
		BeanUtils.copyProperties(shipwreck, existingShipwreck);
		return shipwreckRepository.saveAndFlush(existingShipwreck);
	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)

	public Shipwreck delete(@PathVariable Long id) {
		//return ShipwreckStub.delete(id);
		Shipwreck existingShipwreck = shipwreckRepository.findOne(id);
		shipwreckRepository.delete(existingShipwreck);
		return existingShipwreck;

	}
}
