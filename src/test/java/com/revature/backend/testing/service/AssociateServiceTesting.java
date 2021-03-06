package com.revature.backend.testing.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.backend.model.Associate;
import com.revature.backend.model.AssociateStatus;
import com.revature.backend.model.Batch;
import com.revature.backend.model.Manager;
import com.revature.backend.repository.AssociateRepository;
import com.revature.backend.repository.BatchRepository;
import com.revature.backend.service.AssociateServiceImpl;

@SpringBootTest
public class AssociateServiceTesting {

	@Mock
	private AssociateRepository associateRepo;
	
	@Mock
	private BatchRepository batchRepo;
	
	@InjectMocks
	private AssociateServiceImpl associateServ = mock(AssociateServiceImpl.class);
	
	
	Associate associate;
	Associate associate1;
	Manager manager;
	Batch batch1;
	Batch batch2;
	@BeforeEach 
	public void Setup() throws Exception {
		batch1 = new Batch(1,"Reston","Sophia","1","Java Full Stack");
		manager = new Manager(2,"test@revature.com","REAL_TEST_EMAIL","usery");
		associate = new Associate(1, "testemail@email.com", "test", "associate","1A", manager, batch1, AssociateStatus.STAGING);
		doNothing().when(associateServ).updateAssociate(associate);
	}
	
	@Test
	public void TestUpdateSuccess() {
		associateServ.updateAssociate(associate);
		verify(associateServ, times(1)).updateAssociate(associate);
	}
}
