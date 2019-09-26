package com.boot;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.boot.model.Candidate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import com.boot.controller.CandidateController;
import com.boot.repository.CandidateRepository;

//Need to run with power mock
public class CandidateControllerTest {

	@InjectMocks
	private CandidateController sc;

	@Mock
	private CandidateRepository candidateRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testShipwreckGet() {
    	Candidate sw = new Candidate();
    	sw.setId(1l);
		when(candidateRepository.findOne(1l)).thenReturn(sw);

		Candidate wreck = sc.get(1L);

		verify(candidateRepository).findOne(1l);

//		assertEquals(1l, wreck.getId().longValue());	
		assertThat(wreck.getId(), is(1l));
	}

}
