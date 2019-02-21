package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cats")
public class Cat {
	// Spencer Davis
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="BREED")
	private String breed;
	
	
	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cat(String name, String breed) {
		this.name = name;
		this.breed = breed;
	}
	
	public String returnCatDetails() {
		return name + ": " + breed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}


	

	

}
