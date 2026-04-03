package com.example.architecture.dto;

import java.io.Serializable;

public record UserCreatedEvent(
        int userId,
        String name
) implements Serializable {}