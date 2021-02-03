package com.egentraining.burgersadmin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@RestController
@RequestMapping("/branches/{id}/items")
public class MenuController {

    public void setRegMenu(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] cols = line.split(",");
                regMenu.add(new MenuItem(cols[0], cols[1], Double.parseDouble(cols[2])));
            }
        } catch (FileNotFoundException ex){
            System.out.println(ex);
        }
    }

}
