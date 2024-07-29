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

public class UpdateCompanyInner extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfnewID;
	private JTextField tfnewName;
	private JTextField tfnewAge;
	private JTextField tfnewAddress;
	private JTextField tfnewSalary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCompanyInner frame = new UpdateCompanyInner();
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
	public UpdateCompanyInner() {
		setClosable(true);
		setBounds(230, 100, 321, 445);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("修改员工信息");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 26));
		lblNewLabel.setBounds(59, 22, 161, 27);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 23));
		lblNewLabel_1.setBounds(46, 68, 61, 18);
		getContentPane().add(lblNewLabel_1);
		
		tfnewID = new JTextField();
		tfnewID.setBounds(132, 67, 99, 21);
		getContentPane().add(tfnewID);
		tfnewID.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("姓 名");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.BOLD, 23));
		lblNewLabel_1_1.setBounds(46, 114, 61, 18);
		getContentPane().add(lblNewLabel_1_1);
		
		tfnewName = new JTextField();
		tfnewName.setColumns(10);
		tfnewName.setBounds(132, 113, 99, 21);
		getContentPane().add(tfnewName);
		
		JLabel lblNewLabel_1_2 = new JLabel("年 龄");
		lblNewLabel_1_2.setFont(new Font("宋体", Font.BOLD, 23));
		lblNewLabel_1_2.setBounds(46, 167, 61, 18);
		getContentPane().add(lblNewLabel_1_2);
		
		tfnewAge = new JTextField();
		tfnewAge.setColumns(10);
		tfnewAge.setBounds(132, 166, 99, 21);
		getContentPane().add(tfnewAge);
		
		JLabel lblNewLabel_1_3 = new JLabel("地 址");
		lblNewLabel_1_3.setFont(new Font("宋体", Font.BOLD, 23));
		lblNewLabel_1_3.setBounds(46, 221, 61, 18);
		getContentPane().add(lblNewLabel_1_3);
		
		tfnewAddress = new JTextField();
		tfnewAddress.setColumns(10);
		tfnewAddress.setBounds(132, 220, 99, 21);
		getContentPane().add(tfnewAddress);
		
		JLabel lblNewLabel_1_4 = new JLabel("薪 资");
		lblNewLabel_1_4.setFont(new Font("宋体", Font.BOLD, 23));
		lblNewLabel_1_4.setBounds(46, 276, 61, 18);
		getContentPane().add(lblNewLabel_1_4);
		
		tfnewSalary = new JTextField();
		tfnewSalary.setColumns(10);
		tfnewSalary.setBounds(132, 275, 99, 21);
		getContentPane().add(tfnewSalary);
		
		JButton btnUpdate = new JButton("确认修改");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(tfnewID.getText().trim());
				String name = tfnewName.getText().trim();
				int age = Integer.parseInt(tfnewAge.getText().trim());
				String addresString = tfnewAddress.getText().trim();
				Double salary = Double.parseDouble(tfnewSalary.getText().trim());
				Boolean flag = CompanyDB.update(new Company(id,name,age,addresString,salary));
				if (flag) {
					JOptionPane.showMessageDialog(null, "修改成功！");
				} else {
					JOptionPane.showMessageDialog(null, "修改失败！");

				}
			}
		});
		btnUpdate.setBounds(22, 356, 93, 23);
		getContentPane().add(btnUpdate);
		
		JButton btnCancel = new JButton("取  消");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfnewName.setText("");
				tfnewID.setText("");
				tfnewAge.setText("");
				tfnewAddress.setText("");
				tfnewSalary.setText("");
			}
		});
		btnCancel.setBounds(166, 356, 93, 23);
		getContentPane().add(btnCancel);

	}
}
