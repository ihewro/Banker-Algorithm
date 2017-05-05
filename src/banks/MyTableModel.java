package banks;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
	Object[][] progressResource = new String[5][5];//表中的数据
	String[] Names={"process", "Max", "Allocation", "Need", "Availble"};//列名称
	public MyTableModel() {
		// TODO 自动生成的构造函数存根
        for (int i = 0; i < 5; i++) {
        	progressResource[i][0] = "p" + i;
        }
	}
	@Override
	/*获取列名称*/
	public String getColumnName(int column)
	{
		return Names[column];
	}
	@Override
	/*获取列数目*/
	public int getColumnCount() {
		// TODO 自动生成的方法存根
		//得到表格列数
		return Names.length;
	}

	@Override
	/*获取行数目*/
	public int getRowCount() {
		// TODO 自动生成的方法存根
		//得到表格行数
		return progressResource.length;
	}

	@Override
	/*获取某一位置的值*/
	public Object getValueAt(int rowIndex, int columIndex) {
		// TODO 自动生成的方法存根
		return progressResource[rowIndex][columIndex];
	}
	@Override
	/*设置某一位置的值*/
	public void setValueAt(Object aValue, int rowIndex, int columnIndex)
	{
		progressResource[rowIndex][columnIndex] = (String) aValue;
		/*通知监听器数据单元数据已经改变*/
		fireTableCellUpdated(rowIndex, columnIndex);
	}
	public static void reloadJTable(MyTableModel dtm){
    	Main Maininstance = new Main();
    	Progress[] progresses = Maininstance.GetProgresses();
		for (int i = 0; i < 5;i++){
			dtm.setValueAt("p" + i, i, 0);
			dtm.setValueAt(progresses[i].MaxSource.gerResouceNumber(), i, 1);
			dtm.setValueAt(progresses[i].AllocSource.gerResouceNumber(), i, 2);
			dtm.setValueAt(progresses[i].NeedSource.gerResouceNumber(), i, 3);
		}
		dtm.setValueAt(Maininstance.GetAvailableResource().gerResouceNumber(), 0, 4);
		
		Maininstance.GetJTable().updateUI();
	}
	
	
}
