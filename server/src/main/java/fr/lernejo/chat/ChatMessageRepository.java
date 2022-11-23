package fr.lernejo.chat;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

@Repository
public class ChatMessageRepository {

    private final ArrayList<String> lastTenMessage = new ArrayList<>(10);
    private int index = 0;

    void addChatMessage(String message)
    {
        if (lastTenMessage.size() >= 10)
            lastTenMessage.remove(0);
        lastTenMessage.add(message);
    }

    Iterable<String> getLastTenMessages()
    {
        return lastTenMessage;
    }
}
