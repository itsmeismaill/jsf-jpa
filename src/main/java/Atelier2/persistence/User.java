package Atelier2.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user ;

    private String username ;
    private String email ;

    private String password ;

    private Long id_panier ;


    public User() {
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id_etudiant=" + id_user +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password=" + password +
                '}';
    }

    public User(Long id_user, String username, String email, String password) {
        this.id_user = id_user;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username,String email, String password) {

        this.username = username;
        this.email = email ;
        this.password = password;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Long getId_panier() {
        return id_panier;
    }
    public void setId_panier(Long id_panier) {
        this.id_panier = id_panier;
    }
}
