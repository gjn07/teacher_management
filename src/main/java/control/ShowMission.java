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

public class ShowMission extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO 自动生成的方法存根
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
			stmt = con.prepareStatement("SELECT * FROM record_view", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery();
			Bean bean = new Bean();
			int row, column;
			rs.next();
			ResultSetMetaData metaData = rs.getMetaData();
			column = metaData.getColumnCount();
			rs.last();
			row = rs.getRow();
			rs.beforeFirst();
			String[] columnName = new String[column];
			String[][] tableRecord = new String[row][column];
			for (int i = 0; i < column; i++)
				columnName[i] = metaData.getColumnName(i + 1);
			for (int i = 0; rs.next(); i++) {
				for (int j = 0; j < column; j++) {
					tableRecord[i][j] = rs.getString(j + 1);
				}
			}
			bean.setColumnName(columnName);
			bean.setTableRecord(tableRecord);
			request.setAttribute("bean", bean);
			RequestDispatcher dispatcher = request.getRequestDispatcher("showMission.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
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
		// TODO 自动生成的方法存根
		super.destroy();
	}
}