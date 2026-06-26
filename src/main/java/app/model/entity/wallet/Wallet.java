package app.model.entity.wallet;

import app.model.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "wallet")
public class Wallet {

//    •	id – an UUID
//    •	owner – a User, the owner of the Wallet
//    •	status – a WalletStatus, enumerated value (ACTIVE, INACTIVE)
//    •	balance – a BigDecimal, the amount available in the wallet
//    •	currency – a Currency of the amount in the wallet
//    •	createdOn – LocalDateTime, the date and time the new Wallet was created
//    •	updatedOn – LocalDateTime, the date and time the Wallet state was updated

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WalletStatus status;

    private BigDecimal balance;

    @Column(nullable = false)
    private Currency currency;

    @Column(nullable = false)
    private LocalDateTime createdOn;

    @Column(nullable = false)
    private LocalDateTime updatedOn;
}
