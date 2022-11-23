package fr.lernejo.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/message")
public class ChatMessageController {

    private final ChatMessageRepository chatMessageRepository;

    public ChatMessageController(ChatMessageRepository chatMessageRepository){
        this.chatMessageRepository = chatMessageRepository;
    };

    @GetMapping
    public Iterable<String>getLastTenMessage()
    {
        return chatMessageRepository.getLastTenMessages();
    }
}
