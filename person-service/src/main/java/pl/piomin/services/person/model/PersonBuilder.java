package pl.piomin.services.person.model;

import java.util.Date;

public class PersonBuilder {

	private Integer id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private Gender gender;
	private String phoneNo;
	private String email;
	private String country;
	private String city;
	private String postalCode;
	private String street;
	private int houseNo;
	private String accountNo;
	
	public PersonBuilder withId(Integer id) {
		this.id = id;
		return this;
	}
	
	public PersonBuilder withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public PersonBuilder withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public PersonBuilder withAccountNo(String accountNo) {
		this.accountNo = accountNo;
		return this;
	}
	
	public PersonBuilder withPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
		return this;
	}
	
	public PersonBuilder withEmail(String email) {
		this.email = email;
		return this;
	}
	
	public PersonBuilder withCountry(String country) {
		this.country = country;
		return this;
	}
	
	public PersonBuilder withCity(String city) {
		this.city = city;
		return this;
	}
	
	public PersonBuilder withStreet(String street) {
		this.street = street;
		return this;
	}
	
	public PersonBuilder withPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}
	
	public PersonBuilder withHouseNo(int houseNo) {
		this.houseNo = houseNo;
		return this;
	}
	
	public PersonBuilder withGender(Gender gender) {
		this.gender = gender;
		return this;
	}
	
	public PersonBuilder withBirthDate(Date birthDate) {
		this.birthDate = birthDate;
		return this;
	}
	
	public Person build() {
		Person p = new Person();
		p.setId(id);
		p.setFirstName(firstName);
		p.setLastName(lastName);
		p.setAccountNumber(accountNo);
		p.setGender(gender);
		p.setBirthDate(birthDate);
		Contact c = new Contact();
		c.setEmail(email);
		c.setPhoneNo(phoneNo);
		p.setContact(c);
		Address a = new Address();
		a.setCity(city);
		a.setCountry(country);
		a.setHouseNo(houseNo);
		a.setPostalCode(postalCode);
		a.setStreet(street);
		p.setAddress(a);
		return p;
	}
	
}
