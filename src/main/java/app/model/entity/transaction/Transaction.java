package app.model.entity.transaction;

import app.model.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transaction")
public class Transaction {

//    •	id – an UUID.
//    •	owner – a User, the user for which the Transaction was initiated for
//    •	sender – a String, identifier of the wallet from which we take the money
//    •	receiver – a String, identifier of the wallet to which we give the money
//    •	amount – a BigDecimal, the amount of the Transaction
//    •	balanceLeft – a BigDecimal, the remaining amount after the Transaction
//    •	currency – a Currency used for the Transaction
//    •	type – a TransactionType, enumerated value (DEPOSIT, WITHDRAWAL)
//    •	status – a TransactionStatus, enumerated value (SUCCEEDED, FAILED)
//    •	description – a String, description of the Transaction
//    •	failureReason – a String, the reason for the failed Transaction - in case the transaction can’t be executed for some reason
//    •	createdOn – LocalDateTime, the date the Transaction was made


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(nullable = false)
    private String sender;

    @Column(nullable = false)
    private String receiver;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private BigDecimal balanceLeft;

    @Column(nullable = false)
    private Currency currency;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status;

    @Column(nullable = false)
    private String description;

    private String failureReason;

    @Column(nullable = false)
    private LocalDateTime createdOn;
}
