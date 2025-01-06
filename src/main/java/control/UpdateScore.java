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

public class UpdateScore extends HttpServlet {
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
			stmt = con.prepareStatement("SELECT * FROM score WHERE tid=?", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			stmt.setString(1, tid);
			rs = stmt.executeQuery();
			rs.next();
			String s11 = rs.getString(4);
			rs.next();
			String s12 = rs.getString(4);
			rs.next();
			String s21 = rs.getString(4);
			rs.next();
			String s22 = rs.getString(4);
			rs.next();
			String s23 = rs.getString(4);
			rs.next();
			String s24 = rs.getString(4);
			rs.next();
			String s31 = rs.getString(4);
			rs.next();
			String s32 = rs.getString(4);
			rs.next();
			String s33 = rs.getString(4);
			rs.next();
			String s34 = rs.getString(4);
			rs.next();
			String s41 = rs.getString(4);
			rs.next();
			String s51 = rs.getString(4);
			rs.next();
			String s52 = rs.getString(4);
			rs.next();
			String s53 = rs.getString(4);
			rs.next();
			String s54 = rs.getString(4);

			if (request.getParameter("s11") != null && request.getParameter("s11").length() != 0) {
				s11 = request.getParameter("s11");
				stmt = con.prepareStatement("UPDATE score SET result=? WHERE tid=? AND eid=1");
				stmt.setString(1, s11);
				stmt.setString(2, tid);
				stmt.executeUpdate();
			}
			if (request.getParameter("s12") != null && request.getParameter("s12").length() != 0) {
				s12 = request.getParameter("s12");
				stmt = con.prepareStatement("UPDATE score SET result=? WHERE tid=? AND eid=2");
				stmt.setString(1, s12);
				stmt.setString(2, tid);
				stmt.executeUpdate();
			}
			if (request.getParameter("s21") != null && request.getParameter("s21").length() != 0) {
				s21 = request.getParameter("s21");
				stmt = con.prepareStatement("UPDATE score SET result=? WHERE tid=? AND eid=3");
				stmt.setString(1, s21);
				stmt.setString(2, tid);
				stmt.executeUpdate();
			}
			if (request.getParameter("s22") != null && request.getParameter("s22").length() != 0) {
				s22 = request.getParameter("s22");
				stmt = con.prepareStatement("UPDATE score SET result=? WHERE tid=? AND eid=4");
				stmt.setString(1, s22);
				stmt.setString(2, tid);
				stmt.executeUpdate();
			}
			if (request.getParameter("s23") != null && request.getParameter("s23").length() != 0) {
				s23 = request.getParameter("s23");
				stmt = con.prepareStatement("UPDATE score SET result=? WHERE tid=? AND eid=5");
				stmt.setString(1, s23);
				stmt.setString(2, tid);
				stmt.executeUpdate();
			}
			if (request.getParameter("s24") != null && request.getParameter("s24").length() != 0) {
				s24 = request.getParameter("s24");
				stmt = con.prepareStatement("UPDATE score SET result=? WHERE tid=? AND eid=6");
				stmt.setString(1, s24);
				stmt.setString(2, tid);
				stmt.executeUpdate();
			}
			if (request.getParameter("s31") != null && request.getParameter("s31").length() != 0) {
				s31 = request.getParameter("s31");
				stmt = con.prepareStatement("UPDATE score SET result=? WHERE tid=? AND eid=7");
				stmt.setString(1, s31);
				stmt.setString(2, tid);
				stmt.executeUpdate();
			}
			if (request.getParameter("s32") != null && request.getParameter("s32").length() != 0) {
				s32 = request.getParameter("s32");
				stmt = con.prepareStatement("UPDATE score SET result=? WHERE tid=? AND eid=8");
				stmt.setString(1, s32);
				stmt.setString(2, tid);
				stmt.executeUpdate();
			}
			if (request.getParameter("s33") != null && request.getParameter("s33").length() != 0) {
				s33 = request.getParameter("s33");
				stmt = con.prepareStatement("UPDATE score SET result=? WHERE tid=? AND eid=9");
				stmt.setString(1, s33);
				stmt.setString(2, tid);
				stmt.executeUpdate();
			}
			if (request.getParameter("s34") != null && request.getParameter("s34").length() != 0) {
				s34 = request.getParameter("s34");
				stmt = con.prepareStatement("UPDATE score SET result=? WHERE tid=? AND eid=10");
				stmt.setString(1, s34);
				stmt.setString(2, tid);
				stmt.executeUpdate();
			}
			if (request.getParameter("s41") != null && request.getParameter("s41").length() != 0) {
				s41 = request.getParameter("s41");
				stmt = con.prepareStatement("UPDATE score SET result=? WHERE tid=? AND eid=11");
				stmt.setString(1, s41);
				stmt.setString(2, tid);
				stmt.executeUpdate();
			}
			if (request.getParameter("s51") != null && request.getParameter("s51").length() != 0) {
				s51 = request.getParameter("s51");
				stmt = con.prepareStatement("UPDATE score SET result=? WHERE tid=? AND eid=12");
				stmt.setString(1, "-" + s51);
				stmt.setString(2, tid);
				stmt.executeUpdate();
			}
			if (request.getParameter("s52") != null && request.getParameter("s52").length() != 0) {
				s52 = request.getParameter("s52");
				stmt = con.prepareStatement("UPDATE score SET result=? WHERE tid=? AND eid=13");
				stmt.setString(1, "-" + s52);
				stmt.setString(2, tid);
				stmt.executeUpdate();
			}
			if (request.getParameter("s53") != null && request.getParameter("s53").length() != 0) {
				s53 = request.getParameter("s53");
				stmt = con.prepareStatement("UPDATE score SET result=? WHERE tid=? AND eid=14");
				stmt.setString(1, s53);
				stmt.setString(2, tid);
				stmt.executeUpdate();
			}
			if (request.getParameter("s54") != null && request.getParameter("s54").length() != 0) {
				s54 = request.getParameter("s54");
				stmt = con.prepareStatement("UPDATE score SET result=? WHERE tid=? AND eid=15");
				stmt.setString(1, s54);
				stmt.setString(2, tid);
				stmt.executeUpdate();
			}

			PrintWriter out = response.getWriter();
			out.print("<script>alert(\"�޸ĳɹ�\");</script>");

			RequestDispatcher dispatcher = request.getRequestDispatcher("queryScore");
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