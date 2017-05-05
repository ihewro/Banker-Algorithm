package banks;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main extends JFrame {
	private JPanel contentPane;
	static JTextField textField;
	public static JTable table;
	public static Resource AvailableResource = new Resource();
	static int SafeArgs[] = new int [5];//记录安全序列
	final static MyTableModel dtm = new MyTableModel();
	static int RequestSource [] = new int [4];
	//静态变量对于一个类的所有对象公用！
	public static Progress[] progresses = new Progress[5];

	JTextField info;
	JTextField safeArgsInfo;
	//info 和 safeArgsInfo 如果用static 修饰，只能settext() 一次，原因不清楚！
	public JTable GetJTable(){
		return table;
	}
	public Progress[] GetProgresses(){
		return progresses;
	}
	public Resource GetAvailableResource(){
		return AvailableResource;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Main mainInstance = new Main();
		System.out.println("Runnnig there!1");
		mainInstance.InitProgressResouce();
		MyTableModel.reloadJTable(dtm);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		if(mainInstance.SafeCheck() == false){
			textField.setForeground(Color.WHITE);
			textField.setBackground(Color.RED);
			textField.setText("不安全");
		}
		
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		JTextField RequestProgressName;
		JTextField RequestProgressA;
		JTextField RequestProgressB;
		JTextField RequestProgressC;
		/*一开始我把这个变量放在成员变量位置，并用static修饰，发现无法获取到用户输入的值*/
		setAlwaysOnTop(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 750, 420);
		//setBounds(int x, int y, int width, int height) 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\u5F53\u524D\u7CFB\u7EDF\u7684\u72B6\u6001\u662F\uFF1A ");
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.GREEN);
		textField.setText("\u5B89\u5168");
		panel.add(textField);
		textField.setColumns(10);
		
		table  = new JTable(dtm);
		table.setEnabled(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "\u8D44\u6E90\u5206\u914D\u8868", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);
	
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_6.add(scrollPane_1);
		scrollPane_1.setBorder(new TitledBorder(null, "\u8F93\u5165\u533A\u57DF", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		scrollPane_1.setColumnHeaderView(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u6C42\u7684\u8FDB\u7A0B\u540D\u79F0\uFF1A  ");
		panel_8.add(lblNewLabel_1);
		
		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9);
		
		RequestProgressName = new JTextField();
		RequestProgressName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				//RequestSource[0] = Integer.parseInt(RequestProgressName.getText());
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
		panel_9.add(RequestProgressName);
		RequestProgressName.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JPanel panel_10 = new JPanel();
		panel_3.add(panel_10);
		
		JLabel lblNewLabel_2 = new JLabel("A\u7C7B\u8D44\u6E90\u8BF7\u6C42\u6570\u76EE\uFF1A");
		panel_10.add(lblNewLabel_2);
		
		JPanel panel_11 = new JPanel();
		panel_3.add(panel_11);
		
		RequestProgressA = new JTextField();
		RequestProgressA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				//RequestSource[1] = Integer.parseInt(RequestProgressA.getText());
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
		panel_11.add(RequestProgressA);
		RequestProgressA.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JPanel panel_12 = new JPanel();
		panel_4.add(panel_12);
		
		JLabel lblB = new JLabel("B\u7C7B\u8D44\u6E90\u8BF7\u6C42\u6570\u76EE\uFF1A");
		panel_12.add(lblB);
		
		JPanel panel_13 = new JPanel();
		panel_4.add(panel_13);
		
		RequestProgressB = new JTextField();
		RequestProgressB.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				//RequestSource[2] = Integer.parseInt(RequestProgressB.getText());
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
		panel_13.add(RequestProgressB);
		RequestProgressB.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		JPanel panel_14 = new JPanel();
		panel_5.add(panel_14);
		
		JLabel lblC = new JLabel("C\u7C7B\u8D44\u6E90\u8BF7\u6C42\u6570\u76EE\uFF1A");
		panel_14.add(lblC);
		
		JPanel panel_15 = new JPanel();
		panel_5.add(panel_15);
		
		RequestProgressC = new JTextField();
		RequestProgressC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				//RequestSource[3] = Integer.parseInt(RequestProgressC.getText());
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
		panel_15.add(RequestProgressC);
		RequestProgressC.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		scrollPane_1.setViewportView(panel_7);
		
		JButton btnNewButton_1 = new JButton("\u6E05\u7A7A");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RequestProgressName.setText("");
				RequestProgressA.setText("");
				RequestProgressB.setText("");
				RequestProgressC.setText("");
			}
		});
		panel_7.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		panel_7.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(RequestProgressName.getText().isEmpty() || RequestProgressA.getText().isEmpty() ||
						RequestProgressB.getText().isEmpty() || RequestProgressC.getText().isEmpty()){
					safeArgsInfo.setText("请填入正确的数字！");
				}else if (!isNumeric(RequestProgressName.getText()) || !isNumeric(RequestProgressA.getText()) ||
						!isNumeric(RequestProgressB.getText()) || !isNumeric(RequestProgressC.getText())) {
					safeArgsInfo.setText("只能填写数字！");
				}
				else {
					System.out.println("输入名称：" + RequestProgressName.getText());
					System.out.println("A： " + RequestProgressA.getText());
					System.out.println("B： " + RequestProgressB.getText());
					System.out.println("C： " + RequestProgressC.getText());
					RequestSource[0] = Integer.parseInt(RequestProgressName.getText());
					RequestSource[1] = Integer.parseInt(RequestProgressA.getText());
					RequestSource[2] = Integer.parseInt(RequestProgressB.getText());
					RequestSource[3] = Integer.parseInt(RequestProgressC.getText());
					Main mainInstance = new Main();
					if(Request(RequestSource)){
						MyTableModel.reloadJTable(dtm);
					}
					if(mainInstance.SafeCheck() == false){
						textField.setForeground(Color.WHITE);
						textField.setBackground(Color.RED);
						textField.setText("不安全");
					}
				}
			}
		});
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBorder(new TitledBorder(null, "\u53CD\u9988\u4FE1\u606F\u533A\u57DF", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.add(scrollPane_2);
		
		JPanel panel_16 = new JPanel();
		scrollPane_2.setViewportView(panel_16);
		panel_16.setLayout(new BoxLayout(panel_16, BoxLayout.Y_AXIS));
		
		JPanel panel_17 = new JPanel();
		panel_16.add(panel_17);
		panel_17.setLayout(new BoxLayout(panel_17, BoxLayout.Y_AXIS));
		
		JPanel panel_19 = new JPanel();
		panel_17.add(panel_19);
		panel_19.setLayout(new BoxLayout(panel_19, BoxLayout.Y_AXIS));
		
		JLabel label = new JLabel("\u5206\u914D\u4FE1\u606F\uFF1A");
		panel_19.add(label);
		
		info = new JTextField();
		panel_19.add(info);
		info.setColumns(10);
		
		JPanel panel_18 = new JPanel();
		panel_16.add(panel_18);
		
		JLabel label_1 = new JLabel("\u5B89\u5168\u5E8F\u5217\uFF1A");
		panel_18.add(label_1);
		
		safeArgsInfo = new JTextField();
		panel_18.add(safeArgsInfo);
		safeArgsInfo.setColumns(20);
		
		
	}
	
	public void InitProgressResouce(){
		for(int i = 0; i < 5; i++){
			progresses[i] = new Progress();
		}
		/*设定5个进程最大所需资源的数目*/
		System.out.println("Runnnig there!2");
		progresses[0].setMaxSourceNumber(7,5,3);
		progresses[1].setMaxSourceNumber(3,2,2);
		progresses[2].setMaxSourceNumber(9,0,2);
		progresses[3].setMaxSourceNumber(2,2,2);
		progresses[4].setMaxSourceNumber(4,3,3);
		/*设定5个进程已经分配的资源数目*/
		progresses[0].setAllocSourceNumber(0,1,0);
		progresses[1].setAllocSourceNumber(2,0,0);
		progresses[2].setAllocSourceNumber(3,0,2);
		progresses[3].setAllocSourceNumber(2,1,1);
		progresses[4].setAllocSourceNumber(0,0,2);	
		
		for(int i = 0; i < 5; i++){
			progresses[i].setName(i);//设定5个进程的名称
			progresses[i].setNeedSourceNumber();//设定5个进程剩余所需的资源数目
		}
		
		AvailableResource.setResouceNumber(3,3,2);
		
	}

	public boolean SafeCheck(){
		Resource Work = new Resource();
		Work.setResouceNumber(AvailableResource.getResouceA(), AvailableResource.getResouceB(), AvailableResource.getResouceC());
		//Work = AvailableResource;大错特错！！
		boolean Finish[] = {false,false,false,false,false};
		int j =0;
		for (int i = 0; i < Finish.length; i++) {
			if (Finish[i] == false) {
				if (progresses[i].NeedSource.getResouceA() <= Work.getResouceA() 
						&& progresses[i].NeedSource.getResouceB() <= Work.getResouceB()
						&& progresses[i].NeedSource.getResouceC() <= Work.getResouceC()) {
					
					Work.setResouceNumber(progresses[i].AllocSource.getResouceA() + Work.getResouceA(),
							progresses[i].AllocSource.getResouceB() + Work.getResouceB(),
							progresses[i].AllocSource.getResouceC() + Work.getResouceC());
					//这中间有两步：一是分配资源给进程，二是进程释放分配的进程。最终的结果是可使用的资源 = 原来可使用的资源 
					//+ 分配出去的资源（现在已经释放回收回来了）
					Finish[i] = true;
					SafeArgs[j++] = i;
					i = -1;//重新遍历整个进程！！
				}
				
			}
			
		}
		
		for(int i = 0;i < 5; i++){
			if (Finish[i] == false) {
				return false;
			}
		}

		return true;
	}

	public boolean Request(int RequesSource []){
		System.out.println("Running there4!");
		System.out.println("Running there5!");
		if (RequesSource[1] <= progresses[RequesSource[0]].NeedSource.getResouceA() &&
				RequesSource[2] <= progresses[RequesSource[0]].NeedSource.getResouceB() &&
				RequesSource[3] <= progresses[RequesSource[0]].NeedSource.getResouceC()) {
			if (RequesSource[1] <= AvailableResource.getResouceA() &&
				RequesSource[2] <= AvailableResource.getResouceB() &&
				RequesSource[3] <= AvailableResource.getResouceC()) {
				ProbeAlloc(RequesSource);
				if(SafeCheck()){
					System.out.println("分配成功");
					info.setText("分配成功");
					safeArgsInfo.setText("" + "p" +SafeArgs[0] + "p"+ SafeArgs[1]+ "p" + SafeArgs[2] + "p" + SafeArgs[3] + "p" + SafeArgs[4]);
					return true;
				}else {
					System.out.println("分配失败。原因：系统将进入不安全状态，有可能引起死锁。");
					info.setText("安全性检查失败。原因：系统将进入不安全状态，有可能引起死锁。\n 试探性分配将会回滚。");
					safeArgsInfo.setText("无安全序列");
					RollBack(RequesSource);
				}
			}else{
				System.out.println("分配失败。原因：请求向量大于可利用资源向量。");
				info.setText("安全性检查失败。原因：请求向量大于可利用资源向量。\n");
				safeArgsInfo.setText("无安全序列");
			}
		}else {
			System.out.println("分配失败。原因：请求向量大于需求向量。");
			info.setText("安全性检查失败。原因：请求向量大于需求向量。\n");
			safeArgsInfo.setText("无安全序列");
		}
		return false;
	}
	
	public void ProbeAlloc(int RequesSource []){
		System.out.println("Running there!6");
		System.out.println("当前请求资源的进程" + RequesSource[0]);
		System.out.println("请求A数目：" + RequesSource[1]);
		System.out.println("请求B数目：" + RequesSource[2]);
		System.out.println("请求C数目：" + RequesSource[3]);
		int tempA = AvailableResource.getResouceA() ;
		int tempB = AvailableResource.getResouceB() ;
		int tempC = AvailableResource.getResouceC() ;
		System.out.printf("A : %d, B: %d, C:%d ",tempA, tempB, tempC);
		AvailableResource.setResouceNumber(AvailableResource.getResouceA() - RequesSource[1], 
				AvailableResource.getResouceB() - RequesSource[2],
				AvailableResource.getResouceC() - RequesSource[3]);
		progresses[RequesSource[0]].AllocSource.setResouceNumber(progresses[RequesSource[0]].AllocSource.getResouceA() + RequesSource[1],
				progresses[RequesSource[0]].AllocSource.getResouceB() + RequesSource[2],
				progresses[RequesSource[0]].AllocSource.getResouceC() + RequesSource[3]);
		
		progresses[RequesSource[0]].NeedSource.setResouceNumber(progresses[RequesSource[0]].NeedSource.getResouceA() - RequesSource[1],
				progresses[RequesSource[0]].NeedSource.getResouceB() - RequesSource[2],
				progresses[RequesSource[0]].NeedSource.getResouceC() - RequesSource[3]);
		System.out.println("Running there!7");
		System.out.println("Avalible: " + AvailableResource.gerResouceNumber());
	}
	
	public void RollBack(int RequesSource []){
		AvailableResource.setResouceNumber(AvailableResource.getResouceA() + RequesSource[1], 
				AvailableResource.getResouceB() + RequesSource[2],
				AvailableResource.getResouceC() + RequesSource[3]);
		progresses[RequesSource[0]].AllocSource.setResouceNumber(progresses[RequesSource[0]].AllocSource.getResouceA() - RequesSource[1],
				progresses[RequesSource[0]].AllocSource.getResouceB() - RequesSource[2],
				progresses[RequesSource[0]].AllocSource.getResouceC() - RequesSource[3]);
		
		progresses[RequesSource[0]].NeedSource.setResouceNumber(progresses[RequesSource[0]].NeedSource.getResouceA() - RequesSource[1],
				progresses[RequesSource[0]].NeedSource.getResouceB() - RequesSource[2],
				progresses[RequesSource[0]].NeedSource.getResouceC() - RequesSource[3]);
	}
	
	public static boolean isNumeric(String str){  
		  for (int i = str.length();--i>=0;){    
		   if (!Character.isDigit(str.charAt(i))){  
		    return false;  
		   }  
		  }  
		  return true;  
		}  
}
