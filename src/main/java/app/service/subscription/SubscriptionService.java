package app.service.subscription;

import app.mapper.subscription.SubscriptionMapper;
import app.model.entity.subscription.Subscription;
import app.model.entity.user.User;
import app.repository.subscription.SubscriptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscription createDefaultSubscription(User user) {
        Subscription subscription = SubscriptionMapper.toSubscriptionEntity(user);

        // TODO: Log some proper info message
        subscriptionRepository.save(subscription);

        return subscription;
    }

}
