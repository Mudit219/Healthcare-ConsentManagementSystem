package com.springboot.ConsentManagement.Entities;

public class PatientPublicProfile {
    private String name;
    private String metaId;

    private String img;

    public PatientPublicProfile(String name, String metaId,String img) {
        this.name = name;
        this.metaId = metaId;
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

    public String getMetaId() {
        return metaId;
    }

    public void setMetaId(String metaId) {
        this.metaId = metaId;
    }
}
