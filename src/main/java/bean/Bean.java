package bean;

public class Bean {
	String[] columnName;
	String[][] tableRecord;

	public Bean() {
		columnName = new String[1];
		tableRecord = new String[1][1];
	}

	public String[] getColumnName() {
		return columnName;
	}

	public void setColumnName(String[] columnName) {
		this.columnName = columnName;
	}

	public String[][] getTableRecord() {
		return tableRecord;
	}

	public void setTableRecord(String[][] tableRecord) {
		this.tableRecord = tableRecord;
	}
}
