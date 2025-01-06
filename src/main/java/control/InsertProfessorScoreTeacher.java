package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;

import bean.Bean;
import dao.ConnectionUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertProfessorScoreTeacher extends HttpServlet {
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

			LocalDate currentDate = LocalDate.now();
			String year;
			String term;
			int month = currentDate.getMonthValue();
			if (month <= 8)
				year = (currentDate.getYear() - 1) + "~" + currentDate.getYear();
			else
				year = currentDate.getYear() + "~" + (currentDate.getYear() + 1);
			if (month >= 2 && month <= 8)
				term = "��";
			else
				term = "һ";

			String professor = request.getParameter("professor");
			String tid = request.getParameter("ttid");
			String cname = request.getParameter("cname");
			String address = request.getParameter("address");
			String time = request.getParameter("time");
			String content = request.getParameter("content");
			String pass = request.getParameter("content");
			String result = request.getParameter("result");

			if (professor == null || professor.equals(""))
				professor = "0000";
			if (tid == null || tid.equals(""))
				tid = "0000";
			if (cname == null || cname.equals(""))
				cname = "��";
			if (time == null || time.equals(""))
				time = "��";
			if (content == null || content.equals(""))
				content = "��";
			if (result == null || result.equals(""))
				result = "100";
			if (pass == null || pass.equals(""))
				pass = "0";

			String times = "1";
			stmt = con.prepareStatement("SELECT times FROM score_prof WHERE professor=? AND tid=? ORDER BY times DESC",
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.setString(1, professor);
			stmt.setString(2, tid);
			rs = stmt.executeQuery();
			rs.next();
			int temp = rs.getInt(1) + 1;
			times = String.valueOf(temp);

			String tname = "1";
			stmt = con.prepareStatement("SELECT tname FROM teacher WHERE tid=?", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			stmt.setString(1, tid);
			rs = stmt.executeQuery();
			rs.next();
			tname = rs.getString(1);

			stmt = con.prepareStatement(
					"INSERT INTO score_prof SET YEAR=?,term=?,times=?,professor=?,tid=?,tname=?,cname=?,address=?,TIME=?,content=?,pass=?,result=?");
			stmt.setString(1, year);
			stmt.setString(2, term);
			stmt.setString(3, times);
			stmt.setString(4, professor);
			stmt.setString(5, tid);
			stmt.setString(6, tname);
			stmt.setString(7, cname);
			stmt.setString(8, address);
			stmt.setString(9, time);
			stmt.setString(10, content);
			stmt.setString(11, pass);
			stmt.setString(12, result);
			stmt.executeUpdate();

			PrintWriter out = response.getWriter();
			out.print("<script>alert(\"��ӳɹ�\");</script>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("updateScoreProf");
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