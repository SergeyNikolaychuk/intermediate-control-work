import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Notes {
    private List<Note> notes;
    private String filePath = "notes.json";

    public Notes() {
        if (Files.exists(Paths.get(filePath))) {
            try {
                Reader reader = new FileReader(filePath);
                this.notes = new Gson().fromJson(reader, new TypeToken<List<Note>>(){}.getType());
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            this.notes = new ArrayList<>();
        }
    }

    public void add(Note note) {
        notes.add(note);
        saveToFile();
    }

    public void remove(String id) {
        notes.removeIf(note -> note.getId().equals(id));
        saveToFile();
    }

    public Note get(String id) {
        for (Note note : notes) {
            if (note.getId().equals(id)) {
                return note;
            }
        }
        return null;
    }

    public List<Note> getAll() {
        return notes;
    }

    public void update(Note updatedNote) {
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId().equals(updatedNote.getId())) {
                notes.set(i, updatedNote);
                saveToFile();
                break;
            }
        }
    }

    private void saveToFile() {
        try {
            Writer writer = new FileWriter(filePath);
            new Gson().toJson(notes, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}