package com.Timeless.Timeless.Watch.Store.common;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Getter
public class VehicleIdentifier {

    private String vin;

    public VehicleIdentifier(String vin) {
        this.vin = vin;
    }

}