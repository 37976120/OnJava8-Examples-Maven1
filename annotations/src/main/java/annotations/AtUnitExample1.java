// annotations/AtUnitExample1.java
// (c)2017 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {java onjava.atunit.AtUnit
// build/classes/main/annotations/AtUnitExample1.class}
package annotations;

import onjava.atunit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class AtUnitExample1 {

    public static void copyFiles(File file) throws Exception {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                File one = files[i];
                copyFiles(one);
            }
        }
        if (file.isDirectory()) {
            return;
        }
        File newFile = newFileName(file);

        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel srcChannel = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream(newFile);
        FileChannel tarChannel = fileOutputStream.getChannel();
        tarChannel.transferFrom(srcChannel, 0, srcChannel.size());
        fileInputStream.close();
        fileOutputStream.close();
    }

    public static File newFileName(File file) {
        int j = 1;
        String absolutePath = file.getAbsolutePath();
        int i = absolutePath.lastIndexOf(".");
        String dotSub = absolutePath.substring(i);
        File newFile = null;
        while (true) {
            String replace = absolutePath.replace(dotSub, "(" + j + ")" + dotSub);
            newFile = new File(replace);
            if (!newFile.exists()) {
                break;
            }
            j++;
        }
        return newFile;
    }

    public static void main(String[] args) throws Exception {
        File srcFile = new File("D:\\text");
        copyFiles(srcFile);

//        ByteBuffer buffer = ByteBuffer.allocate(1024);
//        while (true) {
//            buffer.clear();
//            int read = srcChannel.read(buffer);
//            if (read == -1) {
//                break;
//            }
//            buffer.flip();
//            tarChannel.write(buffer);
//
//        }
//        srcFileInputStream.close();
//        tarFileInputStream.close();
    }

    public String methodOne() {
        return "This is methodOne";
    }

    public int methodTwo() {
        System.out.println("This is methodTwo");
        return 2;
    }

    @Test
    boolean methodOneTest() {
        return methodOne().equals("This is methodOne");
    }

    @Test
    boolean m2() {
        return methodTwo() == 2;
    }

    @Test
    private boolean m3() {
        return true;
    }

    // Shows output for failure:
    @Test
    boolean failureTest() {
        return false;
    }

    @Test
    boolean anotherDisappointment() {
        return false;
    }
}

class par implements allte {
    public void say() {
        System.out.println("par:say");
    }
}

class chi extends par {
    @Override
    public void say() {
        System.out.printf("chi:say");
    }
}

class tow extends par {
    public char i;

    @Override
    public void say() {
        System.out.println("tow:say");
    }
}

interface allte {
    public void say();
}

class mainipulation {
//    public dosome
}


/* Output:
annotations.AtUnitExample1
  . m3
  . methodOneTest
  . m2 This is methodTwo

  . failureTest (failed)
  . anotherDisappointment (failed)
(5 tests)

>>> 2 FAILURES <<<
  annotations.AtUnitExample1: failureTest
  annotations.AtUnitExample1: anotherDisappointment
*/
