package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // [status-line]
        response.setStatus(HttpServletResponse.SC_OK); //

        // [response-headers]
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 캐시 무효화
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello");// 임의의 헤더 추가

        // [Header 편의 메서드]
        content(response);
        cookie(response);
        redirect(response);

        // [message body]
        PrintWriter writer = response.getWriter();
        writer.println("ok");
    }

    private void content(HttpServletResponse response) {
        // Content-Type: text/plain;charset=utf-8
        // Content-Length: 2
        // response.setHeader("Content-Type", "text/plain;charset=utf-8");
        // response.getWriter().write("안녕");

        // Content-Type: text/plain;charset=utf-8
        // response.setContentType("text/plain");
         response.setCharacterEncoding("utf-8");
        // response.getWriter().write("안녕");

        // Content-Type: text/plain;charset=utf-8
        response.setContentType("text/plain;charset=utf-8");
    }
    private void cookie(HttpServletResponse response) {
        // Set-Cookie: myCookie=good; Max-Age=600; // 쿠키는 헤더에 추가한다.
        // response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); // 쿠키 유효 시간을 600초로 설정
        response.addCookie(cookie);
    }
    private void redirect(HttpServletResponse response) throws IOException {
        // Status Code 302
        // Location: /basic/hello-form.html

//         response.setStatus(HttpServletResponse.SC_FOUND); // 302 // 302는 임시 리다이렉트
//         response.setHeader("Location", "/basic/hello-form.html");// 리다이렉트할 경로를 헤더에 추가
         response.sendRedirect("/basic/hello-form.html");// 편리한 리다이렉트 기능
    }

}
