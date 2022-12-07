package uk.ac.rhul.cs.dice.jstarworldsturbo.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.json.JSONObject;

import uk.ac.rhul.cs.dice.jstarworldsturbo.elements.Actor;
import uk.ac.rhul.cs.dice.jstarworldsturbo.elements.Body;
import uk.ac.rhul.cs.dice.jstarworldsturbo.environment.Ambient;
import uk.ac.rhul.cs.dice.jstarworldsturbo.environment.Environment;

public abstract class SaveStateManager<M extends Ambient, A extends Actor, B extends Body> {
    private String savedStatesParentDirStringPath;
    private Path savedStatesParentDirPath;

    protected SaveStateManager(String savedStatesParentDirStringPath) {
        this.savedStatesParentDirStringPath = savedStatesParentDirStringPath;
        this.savedStatesParentDirPath = Path.of(this.savedStatesParentDirStringPath);

        try {
            if (Files.exists(savedStatesParentDirPath) && !Files.isDirectory(savedStatesParentDirPath)) {
                throw new IllegalArgumentException(savedStatesParentDirStringPath + " already exists, but it is not a directory.");
            }
            else if (!Files.exists(savedStatesParentDirPath)) {
                Files.createDirectory(savedStatesParentDirPath);
            }
        }
        catch (IOException e) {
            throw new IllegalArgumentException("The " + savedStatesParentDirStringPath + " directory could not be created.");
        }
    }

    public String getSavedStatesParentDirStringPath() {
        return this.savedStatesParentDirStringPath;
    }

    public Path getSavedStatesParentDirPath() {
        return this.savedStatesParentDirPath;
    }

    public abstract void saveState(JSONObject state);

    public abstract Environment<M, A, B> loadState(String filename);

    public boolean exists(String filename) {
        return Files.exists(Path.of(this.savedStatesParentDirStringPath, filename));
    }
}
