package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.ConnectionUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Login extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO �Զ����ɵķ������
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
			stmt = con.prepareStatement("SELECT * FROM teacher", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery();
			String tid = request.getParameter("tid");
			String tpassword = request.getParameter("password");
			int row, column;
			rs.last();
			row = rs.getRow();
			rs.beforeFirst();
			int flag = 0;// 0�˺Ŵ���1�������,2��¼
			for (int i = 0; rs.next(); i++) {
				if (tid.equals(rs.getString(1))) {
					flag = 1;
					if (tpassword.equals(rs.getString(7))) {
						flag = 2;
					}
				}
			}
			if (flag == 2) {
				ServletContext application = this.getServletContext();
				application.setAttribute("tid", tid);
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			} else if (flag == 1) {
				String msg = "�������";
				request.setAttribute("msg", msg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("relogin.jsp");
				dispatcher.forward(request, response);
			} else {
				String msg = "�˺Ŵ���";
				request.setAttribute("msg", msg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("relogin.jsp");
				dispatcher.forward(request, response);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, stmt, rs);
		}
	}

	@Override
	public void destroy() {
		// TODO �Զ����ɵķ������
		super.destroy();
	}
}