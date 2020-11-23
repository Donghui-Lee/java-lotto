package step2.lotto.automatic.view;

import java.util.Scanner;

public class InputLottoView {

    private static String INPUT_THE_PURCHASE_AMOUNT = "구매금액을 입력해주세요";
    private static String INPUTTHE_LAST_WEEK_WINNING_AMOUNT = "지난주 당첨 결과를 입력해주세요";


    private static Scanner sc = new Scanner(System.in);



    private InputLottoView(){

    }

    public static int inputValue() {
        System.out.println(INPUT_THE_PURCHASE_AMOUNT);
        return Integer.parseInt(sc.nextLine());
    }

    public static String inputWinningLottoNumbers() {
        System.out.println();
        System.out.println(INPUTTHE_LAST_WEEK_WINNING_AMOUNT);

        return sc.nextLine();
    }
}
