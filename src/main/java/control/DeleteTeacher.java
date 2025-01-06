package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import bean.Bean;
import dao.ConnectionUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteTeacher extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO �Զ����ɵķ������
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "root";
			String password = "123456";
			String url = "jdbc:mysql://127.0.0.1:3306/teacher_management";
			con = DriverManager.getConnection(url, user, password);
			String tid = request.getParameter("tid");
			stmt = con.prepareStatement("DELETE FROM teacher WHERE tid=?");
			stmt.setString(1, tid);
			stmt.executeUpdate();

			PrintWriter out = response.getWriter();
			out.print("<script>alert(\"ɾ���ɹ�\");</script>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, stmt, rs);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
	}

	@Override
	public void destroy() {
		// TODO �Զ����ɵķ������
		super.destroy();
	}
}