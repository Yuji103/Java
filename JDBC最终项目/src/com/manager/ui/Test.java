package com.manager.ui;

import java.sql.Connection;

import com.manager.db.CompanyDB;
import com.manager.db.DBhelper;
import com.manager.db.UserDB;
import com.manager.pojo.Company;

public class Test {
	public static void main(String[] args) {
		System.out.println(CompanyDB.getAllCompany().size());
	}
}
