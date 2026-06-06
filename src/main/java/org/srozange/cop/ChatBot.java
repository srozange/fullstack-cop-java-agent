package org.srozange.cop;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.quarkus.runtime.Quarkus;
import jakarta.enterprise.context.control.ActivateRequestContext;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@QuarkusMain
public class ChatBot implements QuarkusApplication {

    @RegisterAiService
    public interface Bot {
        @SystemMessage("""
                Réponds directement et uniquement à la question, sans phrases d'introduction, sans métacommentaires et sans justification. Utilise uniquement la même langue que la question. Si la question est en français, la réponse doit être entièrement en français. Formate toujours la réponse en Markdown.
                """)
        String chat(@UserMessage String question);
    }

    @Inject
    Bot assistant;

    @Override
    @ActivateRequestContext
    public int run(String... args) {
        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            while (true) {
                System.out.print("\nYou > ");
                String userInput = scanner.nextLine();
                if ("quit".equalsIgnoreCase(userInput) || "exit".equalsIgnoreCase(userInput)) {
                    break;
                }
                System.out.print("\nAgent > ");
                String response = assistant.chat(userInput);
                System.out.println(response);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Quarkus.run(ChatBot.class, args);
    }
}