package uk.ac.rhul.cs.dice.jstarworldsturbo.common;

import java.io.Serializable;
import java.util.List;

public class BccMessage extends AbstractMessage {
    public BccMessage(Serializable content, String senderID, String recipientID) {
        super(content, senderID, List.of(recipientID));
    }

    @Override
    public String toString() {
        return "message: [from=" + this.getSenderID() + ", content=" + this.getContent() + "]";
    }
}
