package FinalAssignment;

import java.io.*;

interface FileSystem{
    String title = null;
    String content = null;
    String[] ReadFile(String title);
    boolean SearchFile(String keyword);
}

class FileClass implements FileSystem{
    String title;
    String content;

    public String[] ReadFile(String title){
        this.title = title;
        this.content = "";
        String address = "/Users/cesw/Desktop/HUFS/hufs_java/src/FinalAssignment/files/";
        if (!title.equals("what.txt")){
            address += "sep/";
        }
        address += title;
        try{
            File file = new File(address);
            FileReader fr = new FileReader(file);
            int cur = 0;
            while((cur = fr.read()) != -1){
                this.content += (char)cur;
            }
            fr.close();
            return new String[] {this.title, this.content};
        }catch (FileNotFoundException e){
            return new String[] {null};
        }catch(IOException e){
            e.getStackTrace();
            return new String[] {null};
        }
    }

    public boolean SearchFile(String keyword){
        return (this.ReadFile(keyword)[0] != null);
    }
}

public class FileSearch extends FileClass{
    @Override
    public boolean SearchFile(String keyword){
        boolean TorF = this.ReadFile(keyword)[0] != null;
        if (TorF){
            System.out.println("- "+keyword+"에 해당하는 정보를 정상적으로 불러왔습니다");
        }
        return TorF;
    }
}