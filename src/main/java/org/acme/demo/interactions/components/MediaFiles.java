package org.acme.demo.interactions.components;

import lombok.Getter;
import org.acme.demo.file.parse.messages.Message;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MediaFiles{

    private final List<String> mediaPaths;


    public MediaFiles() {
        mediaPaths = new ArrayList<>();
    }


    public void addMedia(Message botMessage){
        if(botMessage.hasPhoto()){
            this.mediaPaths.add(botMessage.getPhotoPath());
        }
        else if (botMessage.hasVideo()){
            this.mediaPaths.add(botMessage.getVideoPath());
        }
    }

    public void addElementsIfTooShort() {
        int itemsToAdd = 3 - mediaPaths.size();
        for(int i = 0; i < itemsToAdd; i++){
            mediaPaths.add("");
        }
    }

    public String getMain(){
        return mediaPaths.get(0);
    }


    public boolean isEmpty(){
        return mediaPaths.isEmpty();
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("media: ");

        if(!mediaPaths.isEmpty()){
            builder.append(mediaPaths.get(0) + " ");
            builder.append(mediaPaths.get(1) + " ");
            builder.append(mediaPaths.get(2));
        }
        return builder.toString();
    }
}
