package com.example.Notes.controller;

import com.example.Notes.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {

    @Autowired
    private OperationService operationService;

    @ResponseBody
    @RequestMapping(value = "write", method = RequestMethod.POST)
    public String writeNote(@RequestParam(value = "Note", required = true) String note){
        if(operationService.createNote(note)){
            return "Note recorded successfully.";
        }else{
            return "Note recording failed.";
        }
    }

    @ResponseBody
    @RequestMapping(value = "read", method = RequestMethod.GET)
    public String readAllNotes(){
        String notes=operationService.retrieveAllNotes();
        return notes;
    }

}
