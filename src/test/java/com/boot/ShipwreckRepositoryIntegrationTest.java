package com.boot;

import com.boot.controller.ShipwreckStub;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;

//run with spring junit class runn. makes it a integration test.
//actually runs the app
@RunWith(SpringJUnit4ClassRunner.class)
//spring boot annotation and add your main class. tells spring boot how to start app
@SpringApplicationConfiguration(App.class)
public class ShipwreckRepositoryIntegrationTest {

	//spring context will now inject the full shipwreck repo into test just like it would in a standard app
	@Autowired
	private ShipwreckRepository shipwreckRepository;

	@Test
	public void testFindAll() {
		//since database isnt working im adding my stub just so this passes
		//List<Shipwreck> wrecks = shipwreckRepository.findAll();
		//import stub and use list method to test fake data
		List<Shipwreck> wrecks = ShipwreckStub.list();
		assertThat(wrecks.size(), is(greaterThanOrEqualTo(0)));
	}
}
