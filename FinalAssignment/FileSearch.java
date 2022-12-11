package FinalAssignment;

import java.io.*;

//! FileSystem에 대한 인터페이스
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

        // 파일이 저장된 루트를 address에 저장
        String address = "/Users/cesw/Desktop/HUFS/hufs_java/src/FinalAssignment/files/";
        // what.txt를 제외한 텍스트 파일은 sep 폴더 내에 위치하므로, title이 what.txt가 아닐 경우 주소에 sep/ 추가
        if (!title.equals("what.txt")){
            address += "sep/";
        }
        address += title;

        //! 파일 입/출력, 예외처리
        try{
            File file = new File(address);
            FileReader fr = new FileReader(file);
            int cur = 0;
            // 파일을 한 자씩 읽어 content에 더함
            while((cur = fr.read()) != -1){
                this.content += (char)cur;
            }
            fr.close();
            // title, content를 배열로 묶어 return
            return new String[] {this.title, this.content};
        }catch (FileNotFoundException e){
            // 파일이 존재하지 않는 경우
            return new String[] {null};
        }catch(IOException e){
            // IOException이 발생한 경우
            e.getStackTrace();
            return new String[] {null};
        }
    }

    // SearchFile 선언
    public boolean SearchFile(String keyword){
        return (this.ReadFile(keyword)[0] != null);
    }
}

public class FileSearch extends FileClass{
    //! 클래스 상속 및 다형성
    @Override
    public boolean SearchFile(String keyword){
        boolean TorF = this.ReadFile(keyword)[0] != null;
        // 정상적으로 파일을 불러왔다면 TorF 변수는 true, 불러오지 못했다면 false를 지닌다
        if (TorF){
            // 정상적으로 불러왔을 경우 문구 출력
            System.out.println("- "+keyword+"에 해당하는 정보를 정상적으로 불러왔습니다");
        }
        // 파일을 불러올 수 있는 지에 대한 boolean 값 반환
        return TorF;
    }
}