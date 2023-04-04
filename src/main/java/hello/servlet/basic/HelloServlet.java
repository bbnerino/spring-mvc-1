package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "helloServlet", urlPatterns = "/hello")// 서블릿 매핑 정보
public class HelloServlet extends HttpServlet {
    @Override// 서블릿이 호출되면 서비스 메서드가 호출된다.
    protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // HttpServletRequest, HttpServletResponse 는 HTTP 요청과 응답 정보를 편리하게 사용할 수 있는 기능을 제공한다.
        // HTTP 요청 메시지를 편리하게 조회할 수 있고, HTTP 응답 메시지를 편리하게 생성할 수 있다.

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // HTTP 응답 메시지의 Content-Type 헤더를 설정한다.
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        // HTTP 응답 메시지의 Body에 데이터를 직접 입력한다.
        response.getWriter().write("hello " + username);

    }
}
