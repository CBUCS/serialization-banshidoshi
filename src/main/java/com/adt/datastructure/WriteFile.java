package com.adt.datastructure;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class WriteFile {
    static File file;
    static FileWriter fw;
    static BufferedWriter bw;
    //input: fileLocation (filename with its path)
    //perform: open the file and empty its content.
    //         Then, store 'content' on the first row
    //output:
    void writeln(String fileLocation, ArrayList<Integer> content) throws Exception{
        String contentText=content.toString().replace("[", "").replace("]", "")
                .replace(", ", ",");
        FileWriter writer = new FileWriter(fileLocation);
        System.out.println("Write to file: "+contentText);
        writer.write(contentText+'\n');
        writer.write('\n');
        writer.close();
    }

}