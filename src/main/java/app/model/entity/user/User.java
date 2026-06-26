package app.model.entity.user;

import app.model.entity.subscription.Subscription;
import app.model.entity.wallet.Wallet;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

//•	id – an UUID.
//•	username – a String, the username of the user
//•	firstName – a String, the first name of the user
//•	lastName – a String, the last name of the user
//•	profilePicture – a String, URL containing link to picture of the user
//•	email – a String, email of the user
//•	password – a String, password of the user
//•	role – a UserRole, enumerated value (ADMIN, USER)
//•	country – a Country, enumerated value (BULGARIA, GERMANY, FRANCE)
//•	isActive – a boolean value which indicates whether the User is active
//•	createdOn – LocalDateTime, the date and time the User account was initialized
//•	updatedOn – LocalDateTime, the date and time the User account was updated
//•	subscriptions – a List of Subscription containing user's subscriptions
//•	wallets – a List of Wallet containing user's wallets

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String username;

    private String firstName;

    private String lastName;

    private String profilePicture;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Enumerated(EnumType.STRING)
    private Country country;

    private boolean isActive;

    @Column(nullable = false)
    private LocalDateTime createdOn;

    @Column(nullable = false)
    private LocalDateTime updatedOn;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    @OrderBy("createdOn DESC")
    private List<Subscription> subscriptions = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    @OrderBy("createdOn DESC")
    private List<Wallet> wallets = new ArrayList<>();

}
