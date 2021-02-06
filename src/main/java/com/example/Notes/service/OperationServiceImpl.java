package com.example.Notes.service;

import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class OperationServiceImpl implements OperationService {
    @Override
    public boolean createNote(String note) {
        String filename="NotesMockDB.txt";
        try{
            File file=new File(filename);
            file.createNewFile();
            BufferedWriter br= new BufferedWriter(new FileWriter(filename, true));
            br.write(note+"\n");
            br.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String retrieveAllNotes() {
        String filename="NotesMockDB.txt";
        try{
            BufferedReader br=new BufferedReader(new FileReader(filename));
            String note, notes="";
            while((note=br.readLine())!=null){
                notes=notes+note+"\n";
            }
            if(notes.length()==0){
                return "/* No notes are stored. */";
            }
            return notes;
        }catch (Exception e){
            e.printStackTrace();
            return "Notes retrival Failed.";
        }
    }
}
