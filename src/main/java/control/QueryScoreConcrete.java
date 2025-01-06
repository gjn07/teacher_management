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

public class QueryScoreConcrete extends HttpServlet {
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
			stmt = con.prepareStatement("SELECT * FROM teacher WHERE tid=?", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			stmt.setString(1, tid);
			rs = stmt.executeQuery();
			rs.next();
			String tname = rs.getString(4);
			stmt = con.prepareStatement("SELECT * FROM score WHERE tid=?", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			stmt.setString(1, tid);
			rs = stmt.executeQuery();
			Bean bean = new Bean();
			int row, column;
			rs.next();
			ResultSetMetaData metaData = rs.getMetaData();
			column = metaData.getColumnCount();
			rs.last();
			row = rs.getRow();
			rs.beforeFirst();
			String[] columnName = new String[5];
			String[][] tableRecord = new String[12][5];
			for (int i = 0; i < 5; i++)
				columnName[i] = "";
			for (int i = 0; i < 12; i++)
				for (int j = 0; j < 5; j++)
					tableRecord[i][j] = " ";
			tableRecord[0][0] = "����";
			tableRecord[0][1] = tid;
			tableRecord[1][0] = "��ʦ����";
			tableRecord[1][1] = tname;
			tableRecord[3][0] = "����";
			tableRecord[5][0] = "����";
			tableRecord[7][0] = "����";
			tableRecord[9][0] = "����";
			tableRecord[11][0] = "����";
			tableRecord[2][0] = "ʦ��ʦ��";
			tableRecord[2][1] = "��������ѧϰ����";
			tableRecord[2][2] = "�������缰�������ֿ���";
			tableRecord[4][0] = "��ѧ����";
			tableRecord[4][1] = "ר������";
			tableRecord[4][2] = "��ѧ����";
			tableRecord[4][3] = "��ѧ�������ճ�";
			tableRecord[4][4] = "�γ�˼��";
			tableRecord[6][0] = "Ժ(��)����";
			tableRecord[6][1] = "ѧ�罨��";
			tableRecord[6][2] = "Ժ(��)����";
			tableRecord[6][3] = "ͬ������";
			tableRecord[6][4] = "��ʦ����רҵ��չ";
			tableRecord[8][0] = "������ʵ����ѧ����";
			tableRecord[8][1] = "������ʵ����ѧ����";
			tableRecord[10][0] = "�����۷���ͼӷ���";
			tableRecord[10][1] = "��ѧ�¹ʴ���";
			tableRecord[10][2] = "��ȫ�¹ʴ���";
			tableRecord[10][3] = "��ʦ�μӽ�ѧ�༼�ܱ���";
			tableRecord[10][4] = "��ѧ�ɹ���������";
			for (int i = 1; rs.next() && i <= 2; i++)
				tableRecord[3][i] = rs.getString(4);
			rs.previous();
			for (int i = 1; rs.next() && i <= 4; i++)
				tableRecord[5][i] = rs.getString(4);
			rs.previous();
			for (int i = 1; rs.next() && i <= 4; i++)
				tableRecord[7][i] = rs.getString(4);
			rs.previous();
			for (int i = 1; rs.next() && i <= 1; i++)
				tableRecord[9][i] = rs.getString(4);
			rs.previous();
			for (int i = 1; rs.next() && i <= 4; i++)
				tableRecord[11][i] = rs.getString(4);
			bean.setColumnName(columnName);
			bean.setTableRecord(tableRecord);
			request.setAttribute("bean", bean);
			RequestDispatcher dispatcher = request.getRequestDispatcher("showScore.jsp");
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