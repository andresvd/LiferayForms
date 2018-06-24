package data;

public class FormAnswer {
	public String name;
	public String birthday;
	public String whyTestingField;
	
	// Empty constructor
	public FormAnswer(String name, String birthday, String whyTestingField){
		this.name = name;
		this.birthday = birthday;
		this.whyTestingField = whyTestingField;
	}
	
	// Getters and setters	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getWhyTestingField() {
		return whyTestingField;
	}

	public void setWhyTestingField(String whyTestingField) {
		this.whyTestingField = whyTestingField;
	}
	
}
