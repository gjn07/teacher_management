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

public class updateScoreProf extends HttpServlet {
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

			String[] pass = request.getParameterValues("selected");
			for (int i = 0; i < pass.length; i++) {
				String[] sp = pass[i].split("\\$");
				String year = sp[1];
				String term = sp[2];
				String tid = sp[3];
				String pname = sp[4];
				String type = sp[0];
				String result = request.getParameter("changed" + i);
				if (result == null || result.equals(""))
					result = sp[5];
				stmt = con.prepareStatement(
						"UPDATE score_prize SET pass=1,result=? WHERE year=? AND term=? AND tid=? AND pname=? AND type=?");
				stmt.setString(1, result);
				stmt.setString(2, year);
				stmt.setString(3, term);
				stmt.setString(4, tid);
				stmt.setString(5, pname);
				stmt.setString(6, type);
				stmt.executeUpdate();
			}

			PrintWriter out = response.getWriter();
			out.print("<script>alert(\"�޸ĳɹ�\");</script>");

			RequestDispatcher dispatcher = request.getRequestDispatcher("showScoreProf");
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