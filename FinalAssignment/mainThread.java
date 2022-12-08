package FinalAssignment;

import java.util.*;

public class mainThread {
    public static void main(String[] args) {
        FileSearch file = new FileSearch();
        Scanner scan = new Scanner(System.in);

        Map<String, String> dic = new HashMap<String, String>();

        for (Command cmd : Command.values()){
            String tit = cmd.getFilename();
            if (file.SearchFile(tit)){
                String[] readFile = file.ReadFile(tit);
                dic.put(readFile[0].toString().replace(".txt", ""), readFile[1].toString());
            }
        }

        while(true){
            System.out.println("#############################################");
            System.out.println("아래의 파일 중 열람하고 싶은 파일명을 입력해주세요");
            System.out.println("Ex) what / !!! q을 입력하시면 검색이 종료됩니다 !!!");
            System.out.println("#############################################");
            for (Command cmd : Command.values()){
                System.out.println(cmd.getFilename() + " : " + cmd.getDesc());
            }
            System.out.print(">>> ");
            String keyword = scan.next().toLowerCase();
            
            if (keyword.equals("q")){
                System.out.println("시스템이 종료됩니다.");
                break;
            }

            String ans = dic.get(keyword);

            if (ans == null){
                System.out.println("잘못된 명령어입니다.");
                continue;
            }

            System.out.println(ans+"\n");
        }
        scan.close();
    }
}