package Exercice5Mock;

import java.util.List;

public interface StudentService {
	List<Student> findAll() throws NullPointerException;
	List<Student> findAll(String name) throws NullPointerException;
	Student getStudent(String id);
}
