package cn.idcast.web;

import cn.idcast.domain.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;



@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getAttribute("user");
        //判断非空，设置编码并输出语句
        if (user != null) {
            resp.setContentType("test/html;charset=utf-8");
            resp.getWriter().write("登陆成功! 2秒后跳转"); //遇到无法解决的问题：无法在前端界面输出而会直接下载结果，并且无法往下执行
            resp.setHeader("refresh", "2;url=/doServe.jsp");
        }
    }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doGet(req, resp);
        }

}
