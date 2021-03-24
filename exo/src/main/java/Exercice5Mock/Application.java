package Exercice5Mock;

import java.util.ArrayList;
import java.util.List;

import utilities.StringUtils;

import java.util.stream.*;

public class Application {
	public  List<String> ListNameEtudiant;
	private StudentService serviceEtudiant ;
	

	public Application(StudentService serviceEtudiant) {
		this.serviceEtudiant = serviceEtudiant;
	}
	
	List<String> findAllStudentNames(){
		try {
			System.out.println("je suis dedans");
			List<Student> listEtudiant = this.serviceEtudiant.findAll();
			for(Student etudiant : listEtudiant) {
				ListNameEtudiant.add(StringUtils.capitalize(etudiant.getName()));
			}
		} catch (NullPointerException e) {
			return new ArrayList<String>();
		}
		return ListNameEtudiant;
	}
	
	List<String> findAllStudentNames(String name){
		try {
			List<Student> listEtudiant = this.serviceEtudiant.findAll(name);
			//listEtudiant.stream().map(s -> s.getName()).collect(Collectors.toList());
			for(Student etudiant : listEtudiant) {
				ListNameEtudiant.add(StringUtils.capitalize(etudiant.getName()));
			}
		} catch (NullPointerException e) {
			return new ArrayList<String>();
		}
			return ListNameEtudiant;
		}
	
	String getStudent(int id) {	
		List<Student> listEtudiant = this.serviceEtudiant.findAll();
		listEtudiant.stream().filter(s -> s.getId() == id);
		return listEtudiant.get(0).getName();
	}
}
