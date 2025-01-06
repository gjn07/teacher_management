package control;

import java.io.IOException;
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

public class InsertSelectTeacher extends HttpServlet {
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

			String tids[] = request.getParameterValues("selected");
			String year1 = request.getParameter("year1");
			String year2 = request.getParameter("year2");
			String year = year1 + "~" + year2;
			String term = request.getParameter("term");
			int n = tids.length;
			String names[] = new String[n];

			for (int i = 0; i < n; i++) {
				stmt = con.prepareStatement("SELECT tname FROM teacher WHERE tid=?", ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				stmt.setString(1, tids[i]);
				rs = stmt.executeQuery();
				rs.next();
				names[i] = rs.getString(1);
			}

			for (int i = 0; i < n; i++) {
				stmt = con.prepareStatement("INSERT INTO examine_record SET year=?,term=?,tid=?,name=?,status=?");
				stmt.setString(1, year);
				stmt.setString(2, term);
				stmt.setString(3, tids[i]);
				stmt.setString(4, names[i]);
				stmt.setString(5, "��ʦ");
				stmt.executeUpdate();
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("showSelectedTeacher");
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