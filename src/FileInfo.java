// Report some basic information about a file

import java.io.*; // for File class

public class FileInfo {

    public static void main(String[] args) {
        File f = new File("C:\\Users\\masp9\\Kap 6\\text");
        System.out.println("exists returns: " + f.exists());
        System.out.println("canRead returns: " + f.canRead());
        System.out.println("length returns: " + f.length());
        System.out.println("getAbsolutePath returns : " + f.getAbsolutePath());


    }

}
