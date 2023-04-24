package com.exampless.demoJ.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Consumer {

    @Id
    @GeneratedValue
    private Long id;
    private String fnam;
    private  String lnam;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFnam() {
        return fnam;
    }

    public void setFnam(String fnam) {
        this.fnam = fnam;
    }

    public String getLnam() {
        return lnam;
    }

    public void setLnam(String lnam) {
        this.lnam = lnam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
