package com.example.noteexcercise.storage;

import com.example.noteexcercise.model.Note;

import java.util.ArrayList;

public class NoteStorage {

    private static ArrayList<Note> list;
    private static FileStorage fileStorage;

    private static final String fileName = "data.dat";

    static { //used to initialized static variables
        list = new ArrayList<>();
    }

    public static Note getNote(int index){
        return list.get(index);
    }

    public static int getSize(){
        return list.size();
    }

    public static ArrayList<Note> getList() {
        return list;
    }

    public static void setFileStorage(FileStorage fs) {
        fileStorage = fs;
    }

    public static void saveNotesToFile(){
        fileStorage.saveToFile(list, fileName);
    }

    public static void readNotesFromFile(){
        Object obj = fileStorage.readObject(fileName);
        if (obj != null){
            list = (ArrayList<Note>) obj;
        }
    }
}
