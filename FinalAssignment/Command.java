package FinalAssignment;

//! 열거타입
public enum Command {
    what("what.txt", "한류란 무엇인가 ?"),
    food("food.txt", "한국의 음식"),
    music("music.txt", "한국의 음악"),
    drama("drama.txt", "한국의 드라마");

    private final String filename;
    private final String desc;

    private Command(String filename, String desc){
        this.filename = filename;
        this.desc = desc;
    }

    // filename 반환
    public String getFilename(){
        return this.filename;
    }
    
    // desc 반환
    public String getDesc(){
        return this.desc;
    }
}