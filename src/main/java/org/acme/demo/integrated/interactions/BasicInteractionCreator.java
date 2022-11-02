package org.acme.demo.integrated.interactions;

import org.acme.demo.integrated.utils.DataTransformUtils;

import lombok.Getter;
import org.acme.demo.integrated.messages.Message;

@Getter
public class BasicInteractionCreator {

    private BasicInteraction previousInteraction;


    public BasicInteractionCreator(){
        Message firstMessage = Message.createFirstMessage();
        previousInteraction = createJustInteraction(firstMessage);
    }


    public boolean isBlank(BasicInteraction basicInteraction) {
        return basicInteraction.getBotTexts().get(0).equals(DataTransformUtils.BLANK_MESSAGE_TEXT);
    }


    public BasicInteraction createBlankInteraction(){
        Message blankMessage = new Message();
        blankMessage.setText(DataTransformUtils.BLANK_MESSAGE_TEXT);
        blankMessage.setDateTime(previousInteraction.getBotInquireDateTime());

        return createInteractionFromMessage(blankMessage);
    }


    public BasicInteraction createInteractionFromMessage(Message message) {
        BasicInteraction interaction = createJustInteraction(message);

        checkDateTimeProperty(interaction);

        previousInteraction = interaction;
        return interaction;
    }


    private void checkDateTimeProperty(BasicInteraction interaction) {

        boolean areNotBlank = !isBlank(interaction) && !isBlank(previousInteraction);
        boolean haveSameDateTime = interaction.getBotInquireDateTime()
                == previousInteraction.getBotInquireDateTime();

        if(areNotBlank && haveSameDateTime ){
            throw new SameUserBotDateTimeException();
        }
    }


    private BasicInteraction createJustInteraction(Message botMessage){
        BasicInteraction interaction = new BasicInteraction();

        interaction.setIndex(botMessage.getId());
        interaction.setBotInquireDateTime(botMessage.getDateTime());

        interaction.addGeneralBotMessage(botMessage);

        return interaction;
    }
}
