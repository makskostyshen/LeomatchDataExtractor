package org.acme.demo.file.parse;

import java.nio.file.Path;
import java.util.List;
import org.acme.demo.old.messages.Message;
import org.acme.demo.old.messages.MessagesGetter;
import org.acme.demo.old.interactions.BasicInteraction;
import org.acme.demo.old.interactions.BasicInteractionsGetter;
import org.acme.demo.statistics.StatisticsData;
import org.acme.demo.utils.ConsolePrinter;
import org.springframework.stereotype.Service;

@Service
public class FileParseService {

  public StatisticsData parse(Path filePath) {
    try {
      MessagesGetter messagesGetter = new MessagesGetter(filePath);
      List<Message> messages = messagesGetter.getMessages();

      BasicInteractionsGetter interactionGetter = new BasicInteractionsGetter();
      List<BasicInteraction> basicInteractions = interactionGetter.getInteractions(messages);
      ConsolePrinter.printInteractions(basicInteractions);
    }
    catch (Exception e){
      System.out.println("ERROR");
      e.printStackTrace();
    }
    return StatisticsData.getEmptyStatisticsData();
  }
}
