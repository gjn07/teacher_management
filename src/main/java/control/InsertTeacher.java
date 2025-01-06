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

public class InsertTeacher extends HttpServlet {
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
			String tname = request.getParameter("tname");
			String identity = request.getParameter("identity");
			String dname = request.getParameter("dname");
			String oname = request.getParameter("oname");
			String comment = request.getParameter("comment");

			if (tid == null || tid.equals(""))
				tid = "0000";
			if (tname == null || tname.equals(""))
				tname = "��";
			if (identity == null || identity.equals(""))
				identity = "��";
			if (dname == null || dname.equals(""))
				dname = "��Ⱥ����";
			if (oname == null || oname.equals(""))
				oname = "���´�ҵѧԺ";
			if (comment == null || comment.equals(""))
				comment = "��";
			int did = 0, oid = 0;
			stmt = con.prepareStatement("SELECT * FROM department", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery();
			for (int i = 0; rs.next(); i++) {
				String str = rs.getString(2);
				if (dname.equals(str)) {
					did = rs.getInt(1);
					break;
				}
			}
			stmt = con.prepareStatement("SELECT * FROM office", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery();
			for (int i = 0; rs.next(); i++) {
				if (oname.equals(rs.getString(3))) {
					oid = rs.getInt(1);
					break;
				}
			}

			stmt = con.prepareStatement("INSERT INTO teacher SET tid=?,tname=?,identity=?,did=?,oid=?,comment=?");
			stmt.setString(1, tid);
			stmt.setString(2, tname);
			stmt.setString(3, identity);
			stmt.setInt(4, did);
			stmt.setInt(5, oid);
			stmt.setString(6, comment);
			stmt.executeUpdate();

			PrintWriter out = response.getWriter();
			out.print("<script>alert(\"��ӳɹ�\");</script>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("queryTeacher");
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