package com.alvin.design.demo.test;

import com.alvin.design.demo.QuestionBankController;
import org.junit.Test;

public class ApiTest {

    @Test
    public void testQuestionBank() {
        QuestionBankController questionBankController = new QuestionBankController();
        System.out.println(questionBankController.createPaper("花花", "1000001921032"));
        System.out.println(questionBankController.createPaper("豆豆", "1000001921772"));
        System.out.println(questionBankController.createPaper("皮皮", "1000001921332"));
    }
}
