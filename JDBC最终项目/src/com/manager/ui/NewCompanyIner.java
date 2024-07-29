package com.manager.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.manager.db.CompanyDB;
import com.manager.pojo.Company;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewCompanyIner extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfID;
	private JTextField tfName;
	private JTextField tfAge;
	private JTextField tfAddress;
	private JTextField tfSalary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCompanyIner frame = new NewCompanyIner();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewCompanyIner() {
		setClosable(true);
		setBounds(200, 100, 380, 472);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("新增员工信息");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 25));
		lblNewLabel.setBounds(92, 10, 197, 82);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(55, 91, 54, 36);
		getContentPane().add(lblNewLabel_1);
		
		tfID = new JTextField();
		tfID.setBounds(135, 102, 182, 21);
		getContentPane().add(tfID);
		tfID.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("姓 名");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 23));
		lblNewLabel_1_1.setBounds(39, 137, 70, 36);
		getContentPane().add(lblNewLabel_1_1);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(135, 148, 182, 21);
		getContentPane().add(tfName);
		
		JLabel lblNewLabel_1_2 = new JLabel("年 龄");
		lblNewLabel_1_2.setFont(new Font("宋体", Font.PLAIN, 23));
		lblNewLabel_1_2.setBounds(39, 194, 70, 36);
		getContentPane().add(lblNewLabel_1_2);
		
		tfAge = new JTextField();
		tfAge.setColumns(10);
		tfAge.setBounds(135, 205, 182, 21);
		getContentPane().add(tfAge);
		
		JLabel lblNewLabel_1_3 = new JLabel("地 址");
		lblNewLabel_1_3.setFont(new Font("宋体", Font.PLAIN, 23));
		lblNewLabel_1_3.setBounds(39, 250, 70, 36);
		getContentPane().add(lblNewLabel_1_3);
		
		tfAddress = new JTextField();
		tfAddress.setColumns(10);
		tfAddress.setBounds(135, 261, 182, 21);
		getContentPane().add(tfAddress);
		
		JLabel lblNewLabel_1_4 = new JLabel("薪 资");
		lblNewLabel_1_4.setFont(new Font("宋体", Font.PLAIN, 23));
		lblNewLabel_1_4.setBounds(39, 296, 70, 36);
		getContentPane().add(lblNewLabel_1_4);
		
		tfSalary = new JTextField();
		tfSalary.setColumns(10);
		tfSalary.setBounds(135, 307, 182, 21);
		getContentPane().add(tfSalary);
		
		JButton btnEnter = new JButton("提  交");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(tfID.getText().trim());
				String name = tfName.getText().trim();
				int age = Integer.parseInt(tfAge.getText().trim());
				String addresString = tfAddress.getText().trim();
				Double salary = Double.parseDouble(tfSalary.getText().trim());
				Boolean flag = CompanyDB.add(new Company(id,name,age,addresString,salary));
				if (flag) {
					JOptionPane.showConfirmDialog(null, "添加成功！");
				}
				else {
					JOptionPane.showConfirmDialog(null, "添加失败！");
				}
				
			}
		});
		btnEnter.setFont(new Font("宋体", Font.PLAIN, 16));
		btnEnter.setBounds(29, 368, 93, 23);
		getContentPane().add(btnEnter);
		
		JButton btnCancel = new JButton("取  消");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfID.setText("");
				tfName.setText("");
				tfAge.setText("");
				tfAddress.setText("");
				tfSalary.setText("");
			}
		});
		btnCancel.setFont(new Font("宋体", Font.PLAIN, 16));
		btnCancel.setBounds(233, 368, 93, 23);
		getContentPane().add(btnCancel);

	}
}
