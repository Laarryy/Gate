package dev.laarryy.gate.utils;

import dev.laarryy.gate.config.GateConfiguration;

public class PasswordCheckUtil {

    private GateConfiguration configuration;

    public boolean checkPassword(String password) {
        return password.equalsIgnoreCase(configuration.getPassword());
    }
}
