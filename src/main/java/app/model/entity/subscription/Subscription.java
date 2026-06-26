package app.model.entity.subscription;

import app.model.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "subscription")
public class Subscription {
//    •	id – an UUID
//    •	owner – a User, the owner of the Subscription
//    •	status – a SubscriptionStatus, enumerated value (ACTIVE, COMPLETED, TERMINATED)
//    •	period – a SubscriptionPeriod, enumerated value (MONTHLY, YEARLY)
//    •	type – a SubscriptionType, enumerated value (DEFAULT, PREMIUM, ULTIMATE)
//    •	price – a BigDecimal, the price of the subscription the user paid
//    •	renewalAllowed – a boolean value which indicates whether the Subscription plan can be automatically renewed by our system - if the user buys a monthly subscription, then the system will automatically renew their subscription when the time comes, if the subscription is yearly, there will be no automatic renewal for the subscription
//    •	createdOn – LocalDateTime, the date the Subscription was created
//    •	completedOn – LocalDateTime, the date the Subscription was completed - that could happen due to subscription change

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SubscriptionStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SubscriptionPeriod period;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SubscriptionType type;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private boolean renewalAllowed;

    @Column(nullable = false)
    private LocalDateTime createdOn;

    @Column(nullable = false)
    private LocalDateTime completedOn;
}
