package chat_GPT_6;

import java.io.*;
import java.util.*;

public class autosave extends Thread {
    private Set<Account> accSet; // AccountManager에서 넘겨받을 계좌정보
    private boolean running = true; // 루프 제어용

    public autosave(Set<Account> accSet) {
        this.accSet = accSet;
        setDaemon(true); // ✅ 프로그램 종료 시 자동으로 같이 종료
    }

    @Override
    public void run() {
        while (running) {
            try {
                saveToTextFile(); // 5초마다 저장
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("[자동저장 쓰레드 종료됨]");
                return; // ✅ interrupt() 호출 시 안전하게 종료
            } catch (IOException e) {
                System.out.println("자동저장 중 오류 발생: " + e.getMessage());
            }
        }
    }

    // 텍스트 파일로 계좌정보 저장
    private void saveToTextFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("AutoSaveAccount.txt"))) {
            for (Account acc : accSet) {
                writer.write(acc.toString());
                writer.newLine();
                writer.write("-------------");
                writer.newLine();
            }
        }
        System.out.println("[자동저장 완료]");
    }
}
