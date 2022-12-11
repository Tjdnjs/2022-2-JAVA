package FinalAssignment;

import java.util.*;

public class mainThread {
    public static void main(String[] args) {
        // FileSearch(from FileSearch.java)
        FileSearch file = new FileSearch();
        Scanner scan = new Scanner(System.in);
        
        //! 컬렉션 프레임워크
        Map<String, String> dic = new HashMap<String, String>();

        // 저장된 열거타입의(from Command.java) 각 요소(cmd)에 대해
        for (Command cmd : Command.values()){
            // getFilename() 을 사용하여 불러온 파일의 이름을 문자열 변수 tit에 저장
            String tit = cmd.getFilename();
            if (file.SearchFile(tit)){
                // tit을 제목으로 하는 파일을 읽어와, Map 컬렉션에 삽입한다.
                // 이때, 검색의 편의성을 위해 파일의 확장자(.txt)는 제거하여 삽입한다.
                String[] readFile = file.ReadFile(tit);
                dic.put(readFile[0].toString().replace(".txt", ""), readFile[1].toString());
            }
        }

        while(true){
            // 안내 문구 출력
            System.out.println("#############################################");
            System.out.println("아래의 파일 중 열람하고 싶은 파일명을 입력해주세요");
            System.out.println("Ex) what / !!! q을 입력하시면 검색이 종료됩니다 !!!");
            System.out.println("#############################################");

            // 어떤 명령어들이 존재하는 지 출력
            for (Command cmd : Command.values()){
                System.out.println(cmd.getFilename() + " : " + cmd.getDesc());
            }
            System.out.print(">>> ");

            // 입력받은 문자열을 소문자로 바꾸어 문자열 변수 keyword에 저장
            String keyword = scan.next().toLowerCase();
            
            // q가 입력으로 들어왔다면 시스템 종료
            if (keyword.equals("q")){
                System.out.println("시스템이 종료됩니다.");
                break;
            }

            // q가 아니라면 Map 컬렉션 dic에서 keyword 검색 후 변수 ans에 저장
            String ans = dic.get(keyword);

            // ans가 null이라면 에러 문구를 출력한 후 continue
            if (ans == null){
                System.out.println("잘못된 명령어입니다.");
                continue;
            }

            // 문제 없이 검색되었을 경우 검색 결과를 출력
            System.out.println(ans+"\n");
        }
        scan.close();
    }
}