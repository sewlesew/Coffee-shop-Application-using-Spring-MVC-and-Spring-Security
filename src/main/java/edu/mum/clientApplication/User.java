package edu.mum.clientApplication;





import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private String phone;
    private String enable;
    

    public User() {
    }

    

    


	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEnable() {
		return enable;
	}



	public void setEnable(String enable) {
		this.enable = enable;
	}
	
	@Override
    public String toString() {
		
		return "Person{" +
                "id=" + id +
                ", First Name='" + firstName + '\'' +
                ", Last Name='" + lastName + '\'' +
                ", First Name='" + firstName + '\'' +
                ", email='" + firstName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", Enable='" + enable + '\'' +
                '}';
    }

}
