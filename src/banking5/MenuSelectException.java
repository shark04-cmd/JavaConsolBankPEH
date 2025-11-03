package banking5;

public class MenuSelectException extends Exception {
//	사용자 정의 예외를 만듦
	
	public MenuSelectException() {
		super(" 1~6 안에있는 정수만 써주세요! ");
	}
}
/*
예외처리 하는 곳
 */
