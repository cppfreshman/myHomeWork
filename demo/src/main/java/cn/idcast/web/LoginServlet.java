package cn.idcast.web;

import cn.idcast.dao.UserDao;
import cn.idcast.domain.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、设置编码
        req.setCharacterEncoding("utf-8");
        //2、获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //3、封装User
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        //4、调用UserDao中的login方法
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        if(user == null){
            //登录失败
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else{
            //登录成功
            //存储数据
            req.setAttribute("user",user);
            req.getRequestDispatcher("/successServlet").forward(req,resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
