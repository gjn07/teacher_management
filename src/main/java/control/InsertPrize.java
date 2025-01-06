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

public class InsertPrize extends HttpServlet {
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
			String tid = request.getParameter("tid");
			String pname = request.getParameter("pname");
			String level = request.getParameter("level");
			String rank = request.getParameter("rank");
			String comment = request.getParameter("comment");
			String type = request.getParameter("type");

			if (tid == null || tid.equals(""))
				tid = "0000";
			if (pname == null || pname.equals(""))
				pname = "��";
			if (level == null || level.equals(""))
				level = "ʡ��";
			if (rank == null || rank.equals(""))
				rank = "���Ƚ�";
			if (comment == null || comment.equals(""))
				comment = "��";
			if (type == null || type.equals(""))
				type = "��ѧ�༼�ܱ���";

			String result;
			if (type.equals("��ѧ�༼�ܱ���")) {
				if (level.equals("���Ҽ�")) {
					if (rank.equals("һ�Ƚ�")) {
						result = "12";
					} else if (rank.equals("���Ƚ�")) {
						result = "8";
					} else {
						result = "6";
					}
				} else {
					if (rank.equals("һ�Ƚ�")) {
						result = "7";
					} else if (rank.equals("���Ƚ�")) {
						result = "5";
					} else {
						result = "2";
					}
				}
			} else {
				if (level.equals("���Ҽ�")) {
					if (rank.equals("һ�Ƚ�")) {
						result = "14";
					} else if (rank.equals("���Ƚ�")) {
						result = "10";
					} else {
						result = "8";
					}
				} else if (level.equals("���Ҽ�")) {
					if (rank.equals("һ�Ƚ�")) {
						result = "12";
					} else if (rank.equals("���Ƚ�")) {
						result = "8";
					} else {
						result = "6";
					}
				} else {
					if (rank.equals("һ�Ƚ�")) {
						result = "7";
					} else if (rank.equals("���Ƚ�")) {
						result = "5";
					} else {
						result = "2";
					}
				}
			}

			stmt = con.prepareStatement(
					"INSERT INTO score_prize SET YEAR=?,term=?,tid=?,pname=?,LEVEL=?,pRANK=?,COMMENT=?,TYPE=?,result=?");
			stmt.setString(1, year);
			stmt.setString(2, term);
			stmt.setString(3, tid);
			stmt.setString(4, pname);
			stmt.setString(5, level);
			stmt.setString(6, rank);
			stmt.setString(7, comment);
			stmt.setString(8, type);
			stmt.setString(9, result);
			stmt.executeUpdate();

			PrintWriter out = response.getWriter();
			out.print("<script>alert(\"��ӳɹ�\");</script>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("insertPrize.jsp");
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