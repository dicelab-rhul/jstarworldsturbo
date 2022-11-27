package uk.ac.rhul.cs.dice.jstarworldsturbo.common;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractMessage implements Message {
    private final Serializable content;
    private final String senderID;
    private List<String> recipientsIDs;
    
    protected AbstractMessage(Serializable content, String senderID, List<String> recipientsIDs) {
        this.content = content;
        this.senderID = senderID;
        this.recipientsIDs = recipientsIDs;
    }

    @Override
    public Serializable getContent() {
        return this.content;
    }

    @Override
    public String getSenderID() {
        return this.senderID;
    }

    @Override
    public List<String> getRecipientsIDs() {
        return this.recipientsIDs;
    }

    public void overrideRecipientsIDs(List<String> receipientsIDs) {
        this.recipientsIDs = receipientsIDs;
    }
}
