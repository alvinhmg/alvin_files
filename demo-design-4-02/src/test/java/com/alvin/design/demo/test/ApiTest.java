package com.alvin.design.demo.test;

import com.alvin.design.demo.QuestionBankController;
import org.junit.Test;

public class ApiTest {

    @Test
    public void testQuestionBankController() throws CloneNotSupportedException {
        QuestionBankController questionBankController = new QuestionBankController();
        System.out.println(questionBankController.creatPaper("花花", "1000001921032"));
        System.out.println(questionBankController.creatPaper("豆豆", "1000001921051"));
        System.out.println(questionBankController.creatPaper("大宝", "1000001921987"));
    }
}
