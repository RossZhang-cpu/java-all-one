package com.rosszhang.javaallinone.nio;// $Id$

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFile
{
  static public void main( String args[] ) throws Exception {
//    if (args.length<2) {
//      System.err.println( "Usage: java CopyFile infile outfile" );
//      System.exit( 1 );
//    }

//    String infile = args[0];
//    String outfile = args[1];
    var resourcePath = CopyFile.class.getClassLoader().getResource("output.txt").getPath();
    FileInputStream fin = new FileInputStream("E:\\CodeFiles\\javafiles\\myproject\\java-all-in-one\\src\\main\\resources\\readandshow.txt");
    FileOutputStream fout = new FileOutputStream("E:\\CodeFiles\\javafiles\\myproject\\java-all-in-one\\src\\main\\resources\\output.txt");

    FileChannel fcin = fin.getChannel();
    FileChannel fcout = fout.getChannel();


    ByteBuffer buffer = ByteBuffer.allocate( 1 );

    while (true) {
      buffer.clear();

      int r = fcin.read( buffer );

      if (r==-1) {
        break;
      }

      buffer.flip();

      fcout.write( buffer );
    }
  }
}
