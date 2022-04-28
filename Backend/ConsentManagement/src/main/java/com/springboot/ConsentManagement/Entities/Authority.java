package com.springboot.ConsentManagement.Entities;

import javax.persistence.*;

@Entity
@Table(name="Authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Authority",nullable = false)
    private String authority;

    public Authority() {
        super();
    }

    public Authority(String authority) {
        super();
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
