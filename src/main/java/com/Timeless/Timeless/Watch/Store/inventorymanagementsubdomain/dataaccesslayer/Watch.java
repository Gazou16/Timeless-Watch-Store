package com.Timeless.Timeless.Watch.Store.inventorymanagementsubdomain.dataaccesslayer;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;

import java.util.Objects;


@Embeddable
@EqualsAndHashCode
public class Watch {

    private String name;
    private String edition;
    private String brand;
    private Integer size;
    private Integer price;
    private Integer id;

    public Watch(@NotNull String name,@NotNull String edition,@NotNull String brand,@NotNull Integer size,@NotNull Integer price,@NotNull Integer id) {
        Objects.requireNonNull(this.name = name);
        Objects.requireNonNull(this.edition = edition);
        Objects.requireNonNull(this.brand = brand);
        Objects.requireNonNull(this.size = size);
        Objects.requireNonNull(this.price = price);
        Objects.requireNonNull(this.id = id);
    }

    public Watch() {

    }

    public @NotNull String getName() {
        return name;
    }

    public @NotNull String getEdition() {
        return edition;
    }

    public @NotNull String getBrand() {
        return brand;
    }

    public @NotNull Integer getSize() {
        return size;
    }

    public @NotNull Integer getPrice() {
        return price;
    }

    public @NotNull Integer getId() {
        return id;
    }
}
