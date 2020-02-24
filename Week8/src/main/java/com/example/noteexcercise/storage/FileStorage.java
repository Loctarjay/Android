package com.example.noteexcercise.storage;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileStorage {

    private Context context;

    public FileStorage(Context context) {
        this.context = context;
    }

    public void saveToFile(Object obj, String filname){
        try {
            FileOutputStream fos = new FileOutputStream(getFileObject(filname));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
            Log.i("all", "OK writing ");
        } catch (Exception e) {
            Log.i("all", "error writing " + e.getMessage());
        }
    }

    public Object readObject(String filname){
        Object obj = null;
        try {
            FileInputStream fis = new FileInputStream(getFileObject(filname));
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = ois.readObject();
            ois.close();
        }catch (Exception e){
            Log.i("all", "error reading " + e.getMessage());
        }
        return obj;
    }



    public File getFileObject(String fileName){
        File path = context.getFilesDir();
        return new File(path, fileName);
    }
}
