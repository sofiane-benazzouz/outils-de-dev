package Exercice5Mock;

import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;

import utilities.StringUtils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;



//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class ApplicationTest {
	
	@Mock
	StudentService studentServiceTest;
	Application application;
	
	@BeforeEach
	void setUp() {
		application = new Application(studentServiceTest);
	}
	
	
	@ParameterizedTest(name="{0} was found")
	@ValueSource(strings= {"Jeremy","Marwa","Sofiane"})
	@DisplayName("cette fonction teste le cas ou la listes des étudiants n est pas vide")
	void findAllTest(String str) {
		List<Student> testList = new ArrayList<Student>();
		testList.add(new Student(1234,"jeremy"));
		testList.add(new Student(3124,"marwa"));
		testList.add(new Student(2134,"sofiane"));
		Mockito.when(studentServiceTest.findAll()).thenReturn(testList);
		List<String> listStudentName = application.findAllStudentNames();
		Mockito.verify(studentServiceTest,Mockito.times(1)).findAll();
		assertEquals(listStudentName.size(),3);
		assertTrue(listStudentName.contains(str));
		
	}
	
	@Test
	@DisplayName("cette fonction teste le cas ou la listes des étudiants est vide")
	void FindAllVideTest() {
		List<Student> testList = new ArrayList<Student>();
		Mockito.when(studentServiceTest.findAll()).thenReturn(testList);
		List<String> listStudentName = application.findAllStudentNames();
		Mockito.verify(studentServiceTest,Mockito.times(1)).findAll();
		assertEquals(listStudentName,new ArrayList<String>());
	}
	
	@ParameterizedTest(name="{0} was not found")
	@ValueSource(strings= {"jeremy","marwa","sofiane"})
	@DisplayName("cette fonction teste le cas ou la listes des étudiants est vide")
	void FindAllNullStudentFindTest(String str) {
		List<Student> testList = new ArrayList<Student>();
		Mockito.when(studentServiceTest.findAll(str)).thenReturn(testList);
		List<String> listStudentName = application.findAllStudentNames(str);
		Mockito.verify(studentServiceTest,Mockito.times(1)).findAll(str);
		assertEquals(listStudentName,new ArrayList<String>());
	}
	
	@ParameterizedTest(name="{0} was found")
	@ValueSource(strings= {"jeremy","marwa","sofiane"})
	@DisplayName("cette fonction teste le cas ou l étudiant rechercher est trouve")
	void FindAllStudentTest(String str) {
		List<Student> testList = new ArrayList<Student>();
		testList.add(new Student(1234,"jeremy"));
		testList.add(new Student(3124,"marwa"));
		testList.add(new Student(2134,"sofiane"));
		Mockito.when(studentServiceTest.findAll(str)).thenReturn(testList.stream().filter(s -> s.getName().equals(str)).collect(Collectors.toList()));
		List<String> listStudentName = application.findAllStudentNames(str);
		Mockito.verify(studentServiceTest,Mockito.times(1)).findAll(str);
		System.out.println(str);
		assertEquals(listStudentName.size(),1);
		assertTrue(listStudentName.contains(StringUtils.capitalize(str)));
	}
	
	
	@Test
	@DisplayName("cette fonction teste le cas ou l étudiant rechercher n est pas trouve")
	void FindAllStudentNotFindTest() {
		Mockito.when(studentServiceTest.findAll("jeremy")).thenReturn(null);
		Exception exception = assertThrows(NullPointerException.class,() -> application.findAllStudentNames("jeremy"));
		Mockito.verify(studentServiceTest,Mockito.times(1)).findAll("jeremy");
		assertNull(exception.getMessage());
		
		
	}
	

}
