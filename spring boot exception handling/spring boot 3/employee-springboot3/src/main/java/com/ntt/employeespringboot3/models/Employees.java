package com.ntt.employeespringboot3.models;

import com.ntt.employeespringboot3.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNullFields;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "employees")
public class Employees implements Serializable {

    @Id
    private String id;
    @NotNull
    private String name;
    private String level;
    @Indexed
    private String email;
    private String community;
    private Status status = Status.ACTIVE;
    public Employees(String name, String level, String email, String community) {
        this.name = name;
        this.level = level;
        this.email = email;
        this.community = community;

    }

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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
