package com.Timeless.Timeless.Watch.Store.common;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class WatchIdentifier {
    private String watchId;

    public WatchIdentifier() {
        this.watchId = UUID.randomUUID().toString();
    }

    public WatchIdentifier(String employeeId) {
        this.watchId = watchId;
    }
}
