package com.manager.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.manager.db.UserDB;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm {

	private JFrame frame;
	private JTextField tfUserName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 353, 264);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("用户名");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(39, 43, 108, 47);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密  码");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(39, 114, 60, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		tfUserName = new JTextField();
		tfUserName.setBounds(118, 52, 145, 27);
		frame.getContentPane().add(tfUserName);
		tfUserName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(118, 116, 145, 27);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("登  录");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = UserDB.login(tfUserName.getText(),new String(passwordField.getPassword()) );
				if (flag) {
					JOptionPane.showMessageDialog(null, "登录成功！");
				}
				else {
					JOptionPane.showMessageDialog(null, "登录失败！");
				}
			}
		});
		btnLogin.setBounds(26, 183, 93, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnCancel = new JButton("取  消");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfUserName.setText("");
				passwordField.setText("");
			}
		});
		btnCancel.setBounds(200, 183, 93, 23);
		frame.getContentPane().add(btnCancel);
	}
}
