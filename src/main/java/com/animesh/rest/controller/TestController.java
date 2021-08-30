package com.animesh.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
@RequestMapping("/normal")
public class TestController {

    @GetMapping("/value/{name}")
    public String getValues(@PathVariable String name){
        return "Hello "+name+" !!!";
    }

    @GetMapping("/value/numbers")
    public ResponseEntity<IntStream> showNumbers(){
        ResponseEntity<IntStream> responseEntity = ResponseEntity.of(Optional.of(IntStream.range(1,10000)));
        return responseEntity;
    }

    @GetMapping("/value/fileData")
    public ResponseEntity<Stream> showNumbers2(){
        FileReader fileInputStream = null;
        BufferedReader bufferedReader = null;
        try {
             fileInputStream = new FileReader("src/main/resources/ReadMe.txt");
             bufferedReader = new BufferedReader(fileInputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<Stream>(HttpStatus.OK).of(
                Optional.of(bufferedReader.lines().map(s -> s.toCharArray())));
    }
}