package main.java.ch04_inheritance_polymorphism.advanced.ch07.exam;

public class FileDownloadServlet extends HttpServlet{
    @Override
    public void service(){
        System.out.println("파일 다운로드합니다.");
    }
}
