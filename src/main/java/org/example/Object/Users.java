package org.example.Object;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String passWord;

    private String email;

    private String phone;
    private String fullName;
    private String avatarURL;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Posts> post = new ArrayList<>();

    //Constructor :
    public Users(int userId, String userName, String passWord, String email, String phone, String fullName, String avatarURL) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.phone = phone;
        this.fullName = fullName;
        this.avatarURL = avatarURL;
    }

    public Users() {

    }

    //Getter method :
    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    //Setter method :
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public void printUser() {
        System.out.printf("%-20d %-20s %-20s %-20s %-20s %-20s %-20s\n", userId, userName, passWord, email, phone, fullName, avatarURL);
    }
}

