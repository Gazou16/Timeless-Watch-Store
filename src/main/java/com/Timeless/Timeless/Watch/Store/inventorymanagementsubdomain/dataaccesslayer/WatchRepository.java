package com.Timeless.Timeless.Watch.Store.inventorymanagementsubdomain.dataaccesslayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchRepository extends JpaRepository<Watch, Integer> {

    Watch findByWatchIdentifier_WatchId(String watchId);

}
