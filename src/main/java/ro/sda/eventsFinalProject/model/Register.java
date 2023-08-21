package ro.sda.eventsFinalProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;

//    @Override
//    public String toString() {
//        return "Register{" +
//                "id=" + id +
//                ", userName='" + userName + '\'' +
//                '}';
//    }
}
