package com.university.university_application.util;

public interface CommandLineRequest {
    void execute(String input);

    boolean isMatched(String input);
}
