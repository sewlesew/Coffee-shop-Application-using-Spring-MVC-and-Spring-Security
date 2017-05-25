package edu.mum.clientApplication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

    private int id;
    private String city;
    private String state;
    private String country;
    private String zipcode;

    public Address() {
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

    
    @Override
    public String toString() {
        return "Adress{" +
                "City='" + city + '\'' +
                ", State=" + state +
                 "Country='" + country + '\'' +
                  "Zip Code='" + zipcode + '\'' +
                '}';
    }
}