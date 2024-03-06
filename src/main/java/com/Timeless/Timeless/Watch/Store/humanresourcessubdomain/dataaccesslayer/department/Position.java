package com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.dataaccesslayer.department;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Christine Gerard
 * @created 01/30/2024
 * @project cardealership-ws-2024
 */

@Embeddable
@Getter
@NoArgsConstructor
public class Position {

    private String title;
    private String code;

    public Position(@NotNull String title, @NotNull String code) {
        this.title = title;
        this.code = code;
    }
}
