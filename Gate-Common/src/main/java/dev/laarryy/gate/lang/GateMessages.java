package dev.laarryy.gate.lang;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;

@ConfigSerializable
public class GateMessages {

    String enterPasswordMessage;
    String wrongPasswordMessage;
    String wrongPasswordKickMessage;

    public GateMessages() {
        this.enterPasswordMessage = "";
        this.wrongPasswordMessage = "";
        this.wrongPasswordKickMessage = "";
    }

    public String getEnterPassword() {
        TextComponent component = Component.text().build();
        return component.content(enterPasswordMessage).toBuilder().build().toString();
    }

    public String getWrongPassword() {
        TextComponent component = Component.text().build();
        return component.content(wrongPasswordMessage).toBuilder().build().toString();
    }

    public String getWrongPasswordKickMessage() {
        TextComponent component = Component.text().build();
        return component.content(wrongPasswordKickMessage).toBuilder().build().toString();
    }
}
