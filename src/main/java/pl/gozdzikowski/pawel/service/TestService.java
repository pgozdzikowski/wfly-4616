package pl.gozdzikowski.pawel.service;

import javax.ejb.Stateless;

@Stateless
public class TestService {
	
	public void testLong() {
		long start = System.currentTimeMillis();

		while (System.currentTimeMillis() - start < 20000)
			continue;

	}

	public String hello() {
		return "Hello";
	}

}
