package jsj.com;

import java.util.Scanner;

public class RegexTest {
public static void main(String[] args) {
	checkPhone();
}

public static void checkPhone() {
	while (true) {
	System.out.println("请输入您的电话号码：");
	Scanner sc = new Scanner(System.in);
	String phone =sc.nextLine();
	if (phone.matches("(1[3-9]\\d{9})")) {
		System.out.println("您输入的号码格式正确");
		break;
	}else {
		System.out.println("您输入的号码格式不正确");
	}
}
}
}
