package io.github.drclass.euler.api;

import java.util.Map;

// Currently, metadata is not used, but is included for the future if addition information is ever needed to be included
public record Result<T>(T value, Map<String, Object> metadata) {
    public Result(T value) {
        this(value, Map.of());
    }

    public String formatted() {
        if (null == value) {
            return "null";
        }
        // Include custom logic for printing objects like Lists if wanted.
        return String.valueOf(value);
    }
}
