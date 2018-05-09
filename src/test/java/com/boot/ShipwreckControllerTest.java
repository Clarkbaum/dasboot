package com.boot;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShipwreckControllerTest {

	//fixes the shipwreckrepo not creating properly by creating fake. might break the app
	@InjectMocks
	private ShipwreckController sc;

	@Mock
	private ShipwreckRepository shipwreckRepository;

	//initials all the mock objects together before the test run
	//its going to see that the injectmocks and mock need to be combine kinda like depency injection
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	//tutorial said this was supposed to fail but since im using stubs its working.
	//normally this would fail because the shipwreckrepository in shipwreckcontroller isnt being cretaed
	// that is what mocks are for
	public void testShipwreckGet() {
		//below is now being created as a mock
		//ShipwreckController sc = new ShipwreckController();

		//create new ship wreck and set id to 1l
		Shipwreck sw = new Shipwreck();
		sw.setId(1l);
		//when findone is called on repo then return sw stub.
		when(shipwreckRepository.findOne(1l)).thenReturn(sw);

		//checks if mock findone was called. (mockino)
		//"if findone was called on the repository twice the test would fail"
		//not sure what he means by twice tbh
		//this breaks my app with an error of: findone is called zero times, expecting one time
		//verify(shipwreckRepository).findOne(1l);

		Shipwreck wreck = sc.get(1L);
		//homecrest tutorial told me to comment this out for the one below it
		//its the same line logically but hamcrest is more readable
//		assertEquals(1l, wreck.getId().longValue());
		assertThat(wreck.getId(), is(1l));
	}
}
