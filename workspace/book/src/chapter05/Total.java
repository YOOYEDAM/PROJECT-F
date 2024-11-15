package chapter05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

@WebServlet(urlPatterns={"/chapter5/total"})
public class Total extends HttpServlet {
	public void doPost (
			HttpServletRequest request, HttpServletResponse response
			)throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();

		try {
			request.setCharacterEncoding("UTF-8");
			int price=Integer.parseInt(request.getParameter("price"));
			int count=Integer.parseInt(request.getParameter("count"));
			int delivery=Integer.parseInt(request.getParameter("delivery"));

			Page.header(out);
			out.println(price+"円×");
			out.println(count+"個＋");
			out.println("送料"+delivery+"円＝");
			out.println(price*count+delivery+"円");
			Page.footer(out);
		}catch (NumberFormatException e) {
			out.println("数値を入力してください。");
		}
	}
}