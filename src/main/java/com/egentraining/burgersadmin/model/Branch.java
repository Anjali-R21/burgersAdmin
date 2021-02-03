package com.egentraining.burgersadmin.model;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.UUID;

//@Data
@Accessors(fluent = true)
@Document(collection = "locations")
public class Branch extends Location{
    @Id
    private @NonNull String id;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Field("branchName")
    private @NonNull String name;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    private @NonNull String contact;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    private @NonNull String phone;

    @DBRef(lazy = true)
    private List<Menu> items;

    public Branch() {
        super();
    }

    public Branch (String name, String contactNumber, String contactPerson, Double lat, Double longitude) {
        super(name, lat,longitude);
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.phone = contactNumber;
        this.contact = contactPerson;

    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Branch{");
        sb.append(", Branch Name='").append(name).append('\'');
        sb.append(", Contact Person='").append(contact).append('\'');
        sb.append(", Contact NUmber='").append(phone).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
