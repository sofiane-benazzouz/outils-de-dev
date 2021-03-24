package Exercice5Mock;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

//@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(MockitoExtension.class)
class ApplicationTest {
	
	@Mock
	StudentService studentServiceTest;
	
	
	Application application = new Application(studentServiceTest);
	
	
	
	
	
	
	@Test
	void FindAllVideTest() {
		List<Student> testList = new ArrayList<Student>();
		Mockito.when(studentServiceTest.findAll()).thenReturn(testList);
		List<String> listStudentName = application.findAllStudentNames();
		Mockito.verify(studentServiceTest).findAll();
		assertEquals(listStudentName,new ArrayList<String>());
	}

}
