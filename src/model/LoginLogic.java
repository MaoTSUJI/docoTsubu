package model;

public class LoginLogic {

	public boolean excute(User user) {	// 実行メソッド
		if(user.getPass().equals("1234")) {
			return true;
		}
		return false;
	}
}
