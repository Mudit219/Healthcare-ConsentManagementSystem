package com.springboot.ConsentManagement.Entities;

public class DoctorPublicProfile {
    private String name;
    private String specialization;
    private String metaId;
    private String phone;
    private String email;

    private String img;
    public DoctorPublicProfile(String name, String specialization, String metaId, String phone, String email, String img) {
        this.name = name;
        this.specialization = specialization;
        this.metaId = metaId;
        this.phone = phone;
        this.email = email;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getMetaId() {
        return metaId;
    }

    public void setMetaId(String metaId) {
        this.metaId = metaId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
