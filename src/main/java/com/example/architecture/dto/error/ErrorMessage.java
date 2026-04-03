package com.example.architecture.dto.error;

import java.util.Date;

public record ErrorMessage(int statusCode, Date date, String message, String description) {
}
