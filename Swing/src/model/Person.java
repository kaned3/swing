package model;

public class Person {
	
	private static int count = 0;
	
	private int id;
	private String name;
	private String occupation;
	private AgeCategory ageCategory;
	private EmploymentCategory employmentCategory;
	private String taxID;
	private boolean usCitizen;
	
	public Person(String name, String occupation, AgeCategory ageCategory, 
			EmploymentCategory employmentCategory, String taxID, 
			boolean usCitizen){
		this.name = name;
		this.occupation = occupation;
		this.ageCategory = ageCategory;
		this.employmentCategory = employmentCategory;
		this.taxID = taxID;
		this.usCitizen = usCitizen;
		this.id = count;
		count++;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public AgeCategory getAgeCategory() {
		return ageCategory;
	}
	public void setAgeCategory(AgeCategory ageCategory) {
		this.ageCategory = ageCategory;
	}
	public EmploymentCategory getEmploymentCategory() {
		return employmentCategory;
	}
	public void setEmploymentCategory(EmploymentCategory employmentCat) {
		this.employmentCategory = employmentCat;
	}
	public String getTaxID() {
		return taxID;
	}
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}
	public boolean isUsCitizen() {
		return usCitizen;
	}
	public void setUsCitizen(boolean usCitizen) {
		this.usCitizen = usCitizen;
	}
	
	
	
}
