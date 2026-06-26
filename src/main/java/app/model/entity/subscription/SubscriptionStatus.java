package app.model.entity.subscription;

import jakarta.persistence.Enumerated;

public enum SubscriptionStatus {
    ACTIVE,
    COMPLETED,
    TERMINATED
}
