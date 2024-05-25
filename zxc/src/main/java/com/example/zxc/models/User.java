package com.example.zxc.models;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Entity
@Data
@Table("users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;
    String Username;
    String Password;
    String Email;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(Id, that.Id) && Objects.equals(Username, that.Username) && Objects.equals(Password, that.Password) && Objects.equals(Email, that.Email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Username, Password, Email);
    }

    @Override
    public String toString() {
        return "User{" + 
                "Id=" + Id +
                ", Username='" + Username + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
