package com.example.httpclient.dto;

import java.util.List;

public record MultipleUsers(
        List<User> users,
        int total,
        int skip,
        int limit
) {
}
