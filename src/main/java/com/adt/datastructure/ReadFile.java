package com.adt.datastructure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadFile {

    //input: fileLocation (i.e. the path and the filename)
    //perform:read the first line or row of the file
    //output:
    ArrayList<Integer> readln(String fileLocation) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
        String result="";
        String line="";
        if ((line=reader.readLine())!=null){
            result=line;
        }
        reader.close();
        System.out.println("Read from file: "+result);
        ArrayList<Integer> a= new ArrayList<Integer>();
        String s[]= result.split(",");
        for(int i=0;i<s.length;i++) a.add( Integer.parseInt(s[i]));

        return a;
    }
}