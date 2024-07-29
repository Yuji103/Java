package com.manager.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.manager.db.CompanyDB;
import com.manager.pojo.Company;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class SearchCompanyIner extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfName;
	private JTable table;
	private JScrollPane scrollPane;
	private JPopupMenu popupMenu;
	private JMenuItem miDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchCompanyIner frame = new SearchCompanyIner();
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
	public SearchCompanyIner() {
		setClosable(true);
		setBounds(200, 100, 371, 352);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("姓 名");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		
		tfName = new JTextField();
		panel.add(tfName);
		tfName.setColumns(20);
		
		JButton btnSearch = new JButton("搜  索");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Company> coms = CompanyDB.getCompanyByName(tfName.getText().trim());
				loadData(coms);
			}
		});
		btnSearch.setFont(new Font("宋体", Font.PLAIN, 15));
		panel.add(btnSearch);
		
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		loadData(CompanyDB.getAllCompany());
		scrollPane.setViewportView(table);

	}
	
	public void loadData(ArrayList<Company> coms) {
		String[] headers = {"员工ID","员工姓名","年龄","地址","薪资"};
		//从ArrayList转换成二维数组
		Object[] companyObjects = coms.toArray();
		Object[][] data = new Object[companyObjects.length][];
		for (int i = 0;i < companyObjects.length;i++) {
			data[i] = new Object[5];
			data[i][0] = ((Company) companyObjects[i]).getId();
			data[i][1] = ((Company) companyObjects[i]).getName();
			data[i][2] = ((Company) companyObjects[i]).getAge();
			data[i][3] = ((Company) companyObjects[i]).getAddress();
			data[i][4] = ((Company) companyObjects[i]).getSalary();
		}
		
		popupMenu = new JPopupMenu();
		
		miDelete = new JMenuItem("删除");
		miDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "是否确认删除？","",JOptionPane.YES_NO_OPTION);
				if (option == 0) {
					String id = table.getValueAt(table.getSelectedRow(), 0).toString();
					boolean flag = CompanyDB.deleteById(Integer.parseInt(id));
					if (flag) {
						ArrayList<Company> comsArrayList=CompanyDB.getAllCompany();
						loadData(comsArrayList);
						JOptionPane.showMessageDialog(null, "删除成功！");
					}
					else {
						JOptionPane.showMessageDialog(null, "删除失败！");
					}
				}
					else if (option == 0) {
						JOptionPane.showConfirmDialog(null, "取消成功！");
					}
				}
				
		});
		popupMenu.add(miDelete);
		table = new JTable(data,headers);
		addPopup(table, popupMenu);
		scrollPane.setViewportView(table);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
