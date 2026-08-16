package com.abubakirkarimov.calculator;

import com.abubakirkarimov.calculator.calculator.HistoryManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HistoryManagerTest {
    HistoryManager historyManager = new HistoryManager();
    @Test
    void historyStoresOperations() {
        historyManager.addHistory(  2);
        assertEquals(1, historyManager.history.size());
    }

    @Test
    void historyClearHistory(){

        historyManager.clearHistory();
        assertEquals(0, historyManager.history.size());
    }

    @Test
    void historyLastOperation(){
        historyManager.addHistory(  2);
        historyManager.addHistory(3);
        double number = 3;
        assertEquals(number, historyManager.history.get(historyManager.history.size()-1));
    }

    @Test
    void getHistory(){
        historyManager.addHistory(  2);
        historyManager.addHistory(3);

        assertEquals(2, historyManager.history.size());
        assertEquals(2, historyManager.history.get(0));
        assertEquals(3, historyManager.history.get(1));
    }


}
