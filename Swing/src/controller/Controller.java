package controller;
import gui.FormEvent;

import java.util.List;

import model.AgeCategory;
import model.Database;
import model.EmploymentCategory;
import model.Person;

public class Controller {
	Database db = new Database();
	
	public List<Person> getPeople(){
		return db.getPeople();
	}
	
	public void addPerson(FormEvent ev){
		String name = ev.getName();
		String occupation = ev.getOccupation();
		int ageCatId = ev.getAgeCategory();
		String empCat = ev.getEmploymentCat();
		boolean isUs = ev.isUsCitizen();
		String taxId = ev.getTaxID();
		
		AgeCategory ageCat = AgeCategory.adult;
		
		switch(ageCatId){
		case 0:
			ageCat = AgeCategory.child;
			break;
		case 1:
			ageCat = AgeCategory.adult;
			break;
		case 2:
			ageCat = AgeCategory.senior;
			break;	
		}
		
		EmploymentCategory empCategory;
		if(empCat.equals("employed")){
			empCategory = EmploymentCategory.employed;
		}
		else if(empCat.equals("self-employed")){
			empCategory = EmploymentCategory.selfEmployed;
		}
		else if(empCat.equals("unemployed")){
			empCategory = EmploymentCategory.unemployed;
		}
		else {
			empCategory = EmploymentCategory.other;
			System.err.println(empCat);
		}
		Person person = new Person(name, occupation, ageCat, empCategory, taxId, isUs);
		db.addPerson(person);
	}
}
