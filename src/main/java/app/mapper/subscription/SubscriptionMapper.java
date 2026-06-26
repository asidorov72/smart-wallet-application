package app.mapper.subscription;

import app.model.dto.subscription.SubscriptionDto;
import app.model.entity.subscription.Subscription;
import app.model.entity.subscription.SubscriptionPeriod;
import app.model.entity.subscription.SubscriptionStatus;
import app.model.entity.subscription.SubscriptionType;
import app.model.entity.user.User;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
public class SubscriptionMapper {

    public static SubscriptionDto toSubscriptionDto(Subscription subscription) {
        if (subscription == null) {
            return null;
        }

        return SubscriptionDto.builder()
                .id(subscription.getId())
                .owner(subscription.getOwner())
                .status(subscription.getStatus())
                .period(subscription.getPeriod())
                .type(subscription.getType())
                .price(subscription.getPrice())
                .renewalAllowed(subscription.isRenewalAllowed())
                .createdOn(subscription.getCreatedOn())
                .completedOn(subscription.getCompletedOn())
                .build();
    }

    public static Subscription toSubscriptionEntity(User user) {
        if (user == null) {
            return null;
        }

        LocalDateTime now = LocalDateTime.now();

        return Subscription.builder()
                .owner(user)
                .period(SubscriptionPeriod.MONTHLY)
                .status(SubscriptionStatus.ACTIVE)
                .type(SubscriptionType.DEFAULT)
                .price(BigDecimal.ZERO)
                .completedOn(now.plusMonths(1))
                .renewalAllowed(true)
                .createdOn(now)
                .build();
    }
}
