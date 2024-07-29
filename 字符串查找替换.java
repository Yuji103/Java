package jsj;

import java.util.Scanner;

public class StringDemo {
	String textString = "sdaf12312asdfasdf123123esadfasdfq";

	public static void main(String[] args) {

		menu();
	}

	public static void menu() {
		System.out.println("字符串方法Demo");
		System.out.println("----------------------------");
		System.out.println("1、查找");
		System.out.println("2、替换");
		System.out.println("3、全部替换");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入序号：");
		String input = sc.next();
		switch (input) {
		case "1":
			System.out.println("欢迎进入查找模式！");
			search();

			break;
		case "2":
			System.out.println("欢迎进入替换模式！");
			replace();

			break;
		case "3":
			System.out.println("欢迎进入全部替换模式！");
			replaceAll();

			break;
		default:
			System.out.println("输入的数字不正确...");
			break;
		}
	}

	public static void search() {
		String textString = "sdaf12312asdfasdf123123esadfasdfq";
		Scanner scanner = new Scanner(System.in);
		char cha = scanner.next().charAt(0);
		int index = textString.indexOf(cha);
		if (index != -1) {
			System.out.println("你要找的字符索引在：" + index);
		} else {
			System.out.println("未查到！");
		}
	}

	public static void replace() {
		String textString = "sdaf12312asdfasdf123123esadfasdfq";
		Scanner scanner = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你要替换的字符：");
		String sc1 = sc.nextLine();
		System.out.println("请输入替换后的值：");
		String sc2 = sc.nextLine();
		System.out.println("替换后的结果为：" + textString.replace(sc1, sc2));
	}

	public static void replaceAll() {
		String textString = "sdaf12312asdfasdf123123esadfasdfq";
		Scanner scanner = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你要替换的字符：");
		String sc3 = sc.nextLine();
		System.out.println("请输入全部替换后的值：");
		String sc4 = sc.nextLine();
		System.out.println("替换后的结果为：" + textString.replaceAll(sc3, sc4));
	}
}
