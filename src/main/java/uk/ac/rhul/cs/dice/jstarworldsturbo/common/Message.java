package uk.ac.rhul.cs.dice.jstarworldsturbo.common;

import java.io.Serializable;
import java.util.List;

public interface Message extends Perception {
    public Serializable getContent();

    public String getSenderID();

    public List<String> getRecipientsIDs();
}
