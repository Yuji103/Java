package com.manager.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static MainForm frame;
	NewCompanyIner newCompanyIner =  new NewCompanyIner();
	SearchCompanyIner searchCompanyIner = new SearchCompanyIner();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainForm();
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
	public MainForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 753);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("用户管理");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("新增用户");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("员工管理");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem miNewCompany = new JMenuItem("新增员工");
		miNewCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCompanyIner newCompanyIner = new NewCompanyIner();
				frame.getContentPane().add(newCompanyIner);
				newCompanyIner.setVisible(true);
			}
		});
		mnNewMenu_1.add(miNewCompany);
		
		JMenuItem miSearchCompany = new JMenuItem("查看员工");
		miSearchCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().add(searchCompanyIner);
				searchCompanyIner.setVisible(true);
			}
		});
		mnNewMenu_1.add(miSearchCompany);
		
		JMenuItem miUpdateCompany = new JMenuItem("修改员工");
		miUpdateCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCompanyInner updateCompanyInner =new UpdateCompanyInner();
				frame.getContentPane().add(updateCompanyInner);
				updateCompanyInner.setVisible(true);
			} 
		});
		mnNewMenu_1.add(miUpdateCompany);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
