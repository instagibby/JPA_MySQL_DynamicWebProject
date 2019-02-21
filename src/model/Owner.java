package model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cat_servants")
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HOOMAN_ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "BIRTHDAY")
	private Date birthday;
	@Column(name = "CAT_OVERLORD_ID")
	private int catOverlordId;
	

	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Owner(int id, String name, Date birthday, int catOverLordId) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.catOverlordId = catOverLordId;
	}
	
	public Owner(String name, Date birthday, int catOverLordId) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.catOverlordId = catOverLordId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwnerName() {
		return name;
	}

	public void setOwnerName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getCatOverlordId() {
		return catOverlordId;
	}

	public void setCatOverlordId(int catOverlordId) {
		this.catOverlordId = catOverlordId;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", birthday=" + birthday + ", catOverlordID=" + catOverlordId
				+ "]";
	}
}
