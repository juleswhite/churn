package org.magnum.churn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ChurnApplication.class)
@WebAppConfiguration
public class ChurnApplicationTests {

	@Before
	public void setUp(){
		//load data into ES for testing
	}
	
	@After
	public void tearDown(){
		// delete loaded test data from ES
	}
	
	@Test
	public void contextLoads() {
	}

	
	// Fangzhou, create an integration test to prove that your
	// controller works. 
}
