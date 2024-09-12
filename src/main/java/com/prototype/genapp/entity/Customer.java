package com.prototype.genapp.entity;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customernumber")
    private int customernumber; // PK

    @Column(name = "firstname", length = 10)
    private String firstname;

    @Column(name = "lastname", length = 20)
    private String lastname;

    @Column(name = "dateofbirth")
    private Date dateofbirth;

    @Column(name = "housename", length = 20)
    private String housename;

    @Column(name = "housenumber", length = 4)
    private String housenumber;

    @Column(name = "postcode", length = 8)
    private String postcode;

    @Column(name = "phonehome", length = 20)
    private String phonehome;

    @Column(name = "phonemobile", length = 20)
    private String phonemobile;

    @Column(name = "emailaddress", length = 100)
    private String emailaddress; // Unique key

    @Column(name = "password", length = 100)
    private String password = "PASSW0RD"; // Default password

    public int getId() {
        return customernumber;
    }
    
    private String username;

    @PrePersist
    public void generateUsername() {
        this.username = this.firstname + this.lastname;
    }


//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "customer_roles",
//            joinColumns = @JoinColumn(name = "customer_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
    
   // private Set<Role> roles;

	

	public Object orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
