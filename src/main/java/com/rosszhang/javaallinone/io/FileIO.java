package com.rosszhang.javaallinone.io;

import java.io.*;

public class FileIO {

    public void formatSqlByFile(){
        File readFile = new File("C:\\Users\\14549\\Downloads\\data1605512013117.csv");
        File writeFile = new File("C:\\Users\\14549\\Desktop\\new1.txt");
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try{
            reader = new BufferedReader(new FileReader(readFile));
            writer = new BufferedWriter(new FileWriter(writeFile));

            String tempString = null;
            int line = 1;
            while ((tempString = reader.readLine()) != null){//BufferedReader有readLine()，可以实现按行读取
                if(line == 1){
                   tempString = "(" + tempString + ",'0101'" + ",'0'" + ")";
//                   tempString = "'" + tempString + "'";
               }else {
                   tempString = " ,(" + tempString  + ",'0101'" + ",'0'" +")";
//                   tempString = " ,'" + tempString + "'";
               }
               writer.write(tempString);
               writer.newLine();
               ++line;
               System.out.println(tempString);
            }
            reader.close();
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try{
                    reader.close();
                }catch(IOException e){
                }
            }
        }

    }

    public void formatSqlByFile2(){
        File readFile = new File("C:\\Users\\14549\\Desktop\\ss1.txt");
        File writeFile = new File("C:\\Users\\14549\\Desktop\\ss2.txt");
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try{
            reader = new BufferedReader(new FileReader(readFile));

            writer = new BufferedWriter(new FileWriter(writeFile));

            String tempString = null;

            while ((tempString = reader.readLine()) != null){//BufferedReader有readLine()，可以实现按行读取
                tempString = "'" + tempString + "',";
                writer.write(tempString);
                writer.newLine();
                System.out.println(tempString);
            }
            reader.close();
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try{
                    reader.close();
                }catch(IOException e){
                }
            }
        }
    }

    public static void main(String[] args) {
        new FileIO().formatSqlByFile2();
    }
}
