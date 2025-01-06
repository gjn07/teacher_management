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

public class InsertScore extends HttpServlet {
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
			String s11 = request.getParameter("s11");
			String s12 = request.getParameter("s12");
			String s21 = request.getParameter("s21");
			String s22 = request.getParameter("s22");
			String s23 = request.getParameter("s23");
			String s24 = request.getParameter("s24");
			String s31 = request.getParameter("s31");
			String s32 = request.getParameter("s32");
			String s33 = request.getParameter("s33");
			String s34 = request.getParameter("s34");
			String s41 = request.getParameter("s41");
			String s51 = request.getParameter("s51");
			String s52 = request.getParameter("s52");
			String s53 = request.getParameter("s53");
			String s54 = request.getParameter("s54");

			if (s11 == null || s11.equals(""))
				s11 = "10";
			if (s12 == null || s12.equals(""))
				s12 = "10";
			if (s21 == null || s21.equals(""))
				s21 = "15";
			if (s22 == null || s22.equals(""))
				s22 = "15";
			if (s23 == null || s23.equals(""))
				s23 = "10";
			if (s24 == null || s24.equals(""))
				s24 = "5";
			if (s31 == null || s31.equals(""))
				s31 = "5";
			if (s32 == null || s32.equals(""))
				s32 = "10";
			if (s33 == null || s33.equals(""))
				s33 = "5";
			if (s34 == null || s34.equals(""))
				s34 = "5";
			if (s41 == null || s41.equals(""))
				s41 = "10";
			if (s51 == null || s51.equals(""))
				s51 = "0";
			if (s52 == null || s52.equals(""))
				s52 = "0";
			if (s53 == null || s53.equals(""))
				s53 = "0";
			if (s54 == null || s54.equals(""))
				s54 = "0";

			stmt = con.prepareStatement("INSERT INTO score SET tid=?,iid=?,eid=?,result=?");
			stmt.setString(1, tid);
			stmt.setString(2, "1");
			stmt.setString(3, "1");
			stmt.setString(4, s11);
			stmt.executeUpdate();

			stmt = con.prepareStatement("INSERT INTO score SET tid=?,iid=?,eid=?,result=?");
			stmt.setString(1, tid);
			stmt.setString(2, "1");
			stmt.setString(3, "2");
			stmt.setString(4, s12);
			stmt.executeUpdate();

			stmt = con.prepareStatement("INSERT INTO score SET tid=?,iid=?,eid=?,result=?");
			stmt.setString(1, tid);
			stmt.setString(2, "2");
			stmt.setString(3, "3");
			stmt.setString(4, s21);
			stmt.executeUpdate();

			stmt = con.prepareStatement("INSERT INTO score SET tid=?,iid=?,eid=?,result=?");
			stmt.setString(1, tid);
			stmt.setString(2, "2");
			stmt.setString(3, "4");
			stmt.setString(4, s22);
			stmt.executeUpdate();

			stmt = con.prepareStatement("INSERT INTO score SET tid=?,iid=?,eid=?,result=?");
			stmt.setString(1, tid);
			stmt.setString(2, "2");
			stmt.setString(3, "5");
			stmt.setString(4, s23);
			stmt.executeUpdate();

			stmt = con.prepareStatement("INSERT INTO score SET tid=?,iid=?,eid=?,result=?");
			stmt.setString(1, tid);
			stmt.setString(2, "2");
			stmt.setString(3, "6");
			stmt.setString(4, s24);
			stmt.executeUpdate();

			stmt = con.prepareStatement("INSERT INTO score SET tid=?,iid=?,eid=?,result=?");
			stmt.setString(1, tid);
			stmt.setString(2, "3");
			stmt.setString(3, "7");
			stmt.setString(4, s31);
			stmt.executeUpdate();

			stmt = con.prepareStatement("INSERT INTO score SET tid=?,iid=?,eid=?,result=?");
			stmt.setString(1, tid);
			stmt.setString(2, "3");
			stmt.setString(3, "8");
			stmt.setString(4, s32);
			stmt.executeUpdate();

			stmt = con.prepareStatement("INSERT INTO score SET tid=?,iid=?,eid=?,result=?");
			stmt.setString(1, tid);
			stmt.setString(2, "3");
			stmt.setString(3, "9");
			stmt.setString(4, s33);
			stmt.executeUpdate();

			stmt = con.prepareStatement("INSERT INTO score SET tid=?,iid=?,eid=?,result=?");
			stmt.setString(1, tid);
			stmt.setString(2, "3");
			stmt.setString(3, "10");
			stmt.setString(4, s34);
			stmt.executeUpdate();

			stmt = con.prepareStatement("INSERT INTO score SET tid=?,iid=?,eid=?,result=?");
			stmt.setString(1, tid);
			stmt.setString(2, "4");
			stmt.setString(3, "11");
			stmt.setString(4, s41);
			stmt.executeUpdate();

			stmt = con.prepareStatement("INSERT INTO score SET tid=?,iid=?,eid=?,result=?");
			stmt.setString(1, tid);
			stmt.setString(2, "5");
			stmt.setString(3, "12");
			stmt.setString(4, "-" + s51);
			stmt.executeUpdate();

			stmt = con.prepareStatement("INSERT INTO score SET tid=?,iid=?,eid=?,result=?");
			stmt.setString(1, tid);
			stmt.setString(2, "5");
			stmt.setString(3, "13");
			stmt.setString(4, "-" + s52);
			stmt.executeUpdate();

			stmt = con.prepareStatement("INSERT INTO score SET tid=?,iid=?,eid=?,result=?");
			stmt.setString(1, tid);
			stmt.setString(2, "5");
			stmt.setString(3, "14");
			stmt.setString(4, s53);
			stmt.executeUpdate();

			stmt = con.prepareStatement("INSERT INTO score SET tid=?,iid=?,eid=?,result=?");
			stmt.setString(1, tid);
			stmt.setString(2, "5");
			stmt.setString(3, "15");
			stmt.setString(4, s54);
			stmt.executeUpdate();

			PrintWriter out = response.getWriter();
			out.print("<script>alert(\"��ӳɹ�\");</script>");
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