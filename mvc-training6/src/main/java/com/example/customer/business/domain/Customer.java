package com.example.customer.business.domain;

import javax.validation.constraints.AssertFalse;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Customer implements java.io.Serializable {

	private int id;
	
    @NotBlank
    @Length(max = 20)
    private String name;

    @NotBlank
    @Length(max = 100)
    private String address;

    @NotBlank
    @Email
    private String emailAddress;
    
    @NotBlank
    private String membershipType;
    
    @NotBlank
    private String graduate;
    
    @AssertFalse(message = "{errors.ngemail}")
    public boolean isNgEmail() {
        // ドメイン名が「ng.foo.baz」であれば使用不可のアドレスと見なす
        return emailAddress.matches(".*@ng.foo.baz$");
    }

    public Customer() {
    }

	public Customer(String name, String address, String emailAddress, String membershipType, String graduate) {
        this.name = name;
        this.address = address;
        this.emailAddress = emailAddress;
        this.membershipType = membershipType;
        this.graduate = graduate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    
    public String getMembershipType() {
		return membershipType;
	}

	public String getGraduate() {
		return graduate;
	}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}
    
	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", emailAddress=" + emailAddress
				+ ", membershipType=" + membershipType + ", graduate=" + graduate + "]";
	}

	private static final long serialVersionUID = 3428490997353904743L;
}
