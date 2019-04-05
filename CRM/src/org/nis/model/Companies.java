package org.nis.model;

public class Companies {
	private String companyid;
	private String companyname;
	private String ownername;
	private String address;
	private String state;
	private String city;
	private String contactperson;
	private String emailid;
	private String mobileno;
	private String logo;
	
	public String getCompanyid(){
		return companyid;
	}
	public void setCompanyid(String companyid){
		this.companyid=companyid;
	}
	public String getCompanyname(){
		return companyname;
	}
	public void setCompanyname(String companyname){
		this.companyname=companyname;
	}
	public String getOwnername(){
		return ownername;
	}
	public void setOwnername(String ownername){
		this.ownername=ownername;
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getState(){
		return state;
	}
	public void setState(String state){
		this.state=state;
	}
	public String getCity(){
		return city;
	}
	public void setCity(String city){
		this.city=city;
	}
	public String getContactperson(){
		return contactperson;
	}
	public void setContactperson(String contactperson){
		this.contactperson=contactperson;
	}
	public String getEmailid(){
		return emailid;
	}
	public void setEmailid(String emailid){
		this.emailid=emailid;
	}
	public String getMobileno(){
		return mobileno;
	}
	public void setMobileno(String mobileno){
		this.mobileno=mobileno;
	}
	public String getLogo(){
		return logo;
	}
	public void setLogo(String logo){
		this.logo=logo;
	}

}
