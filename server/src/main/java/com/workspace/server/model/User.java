package com.workspace.server.model;

import com.workspace.server.model.audit.DateAudit;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class User extends DateAudit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank
    @Size(max = 200)
    private String name;

    @Column(name = "username")
    @NotBlank
    @Size(max = 50)
    private String username;

    @Column(name = "email")
    @NotBlank
    @Size(max = 254)
    @Email
    private String email;

    @Column(name = "password")
    @NotBlank
    @Size(max = 100)
    private String password;

    @Column(name = "phone", unique = true)
    @NotBlank
    @Size(max = 50)
    private String phone;

    @Column(name = "tg")
    @NotBlank
    @Size(max = 30)
    private String tg;

    @Column(name = "about")
    @Size(max = 300)
    private String about;

    @Column(name = "position")
    @NotBlank
    @Size(max = 50)
    private String position;

    @Column(name = "department")
    @NotBlank
    @Size(max = 300)
    private String department;

    @Column(name = "office")
    @NotBlank
    @Size(max = 3)
    private String office;

    @NotBlank
    @Column(name = "start_at")
    private LocalTime startAt;

    @NotBlank
    @Column(name = "end_at")
    private LocalTime endAt;

    @Column(name = "birthday")
    @NotBlank
    private LocalDate birthday;

    @Column(name = "secret_note")
    @NotBlank
    @Size(max = 300)
    private String secretNote;

    @Column(name = "status")
    @NotBlank
    @Size(max = 1)
    private char status;

    @Column(name = "status_date_start")
    private LocalDate statusDateStart;

    @Column(name = "status_date_finish")
    private LocalDate statusDateFinish;

    @Embedded
    private PasswordResetToken resetPasswordToken;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_name"))
    @EqualsAndHashCode.Exclude
    private Set<Role> roles;

    @ManyToMany(mappedBy = "users")
    @EqualsAndHashCode.Exclude
    private Set<Meeting> meetings;

    public User(PasswordResetToken resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }
}