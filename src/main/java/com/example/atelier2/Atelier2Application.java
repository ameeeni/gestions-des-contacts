package com.example.atelier2;

import com.example.atelier2.entities.Contact;
import com.example.atelier2.dao.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;

@SpringBootApplication
public class Atelier2Application implements CommandLineRunner {
@Autowired
ContactRepository contactRepository;
    public static void main(String[] args) {
        SpringApplication.run(Atelier2Application.class, args);


    }
    SimpleDateFormat readFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
    SimpleDateFormat writeFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");


    @Override
    public void run(String... args) throws Exception {
     contactRepository.save(new Contact(null ,"Bramli" , "Ameni" ,"20/05/2000" , "58661316"));
     contactRepository.save(new Contact(null ,"Nefzi" , "Eya" ,"05/02/2001" , "96316302"));
     contactRepository.save(new Contact(null ,"Elayeb" , "Mayssa" ,"18/09/2001" , "5245585"));

    }
}
