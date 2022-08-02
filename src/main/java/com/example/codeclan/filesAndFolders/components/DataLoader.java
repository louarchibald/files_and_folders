package com.example.codeclan.filesAndFolders.components;

import com.example.codeclan.filesAndFolders.models.File;
import com.example.codeclan.filesAndFolders.models.Folder;
import com.example.codeclan.filesAndFolders.models.Person;
import com.example.codeclan.filesAndFolders.repositories.FileRepository;
import com.example.codeclan.filesAndFolders.repositories.FolderRepository;
import com.example.codeclan.filesAndFolders.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){

        Person chris = new Person("Chris Boyle");
        personRepository.save(chris);

        Person louise = new Person("Louise Archibald");
        personRepository.save(louise);

        Folder codeclan = new Folder("Codeclan Work", chris);
        folderRepository.save(codeclan);

        Folder codeclan1 = new Folder("Codeclan Stuff", louise);
//
        File annotations = new File("Annotations", ".java", 500, codeclan);
        fileRepository.save(annotations);

        File annotations1 = new File ("Annotations", ".py", 400, codeclan1);

    }
}
