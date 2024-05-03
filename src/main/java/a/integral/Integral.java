/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package a.integral;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ekaterina
 */
public class Integral {

    public static void main(String[] args) {
        
        double begin = 0;
        double end = 1;
        int intervalCount = 1000;
        int n = Runtime.getRuntime().availableProcessors();
        
        
        List<SumTask> list = new ArrayList();
        
        long time1start = System.nanoTime();
        for (int i = 1; i <= n; ++i) {
            SumTask task = new SumTask((((begin + end) / n) * (i - 1)), ((begin + end) / n) * i, n, intervalCount);
            task.run();
            list.add(task);
        }
        
        long time1end = System.nanoTime() - time1start;
        System.out.println("Данные для 8 потоков: ");
        System.out.println("Результат: " + list.stream().mapToDouble(s -> s.getSum()).sum());
        System.out.println("Время выполнения: " + time1end);
        System.out.println();
        
        n = 1;
        list = new ArrayList();
         
        long time2start = System.nanoTime(); 
        for (int i = 1; i <= n; ++i) {
            SumTask task = new SumTask((((begin + end) / n) * (i - 1)), ((begin + end) / n) * i, n, intervalCount);
            task.run();
            list.add(task);
        }
        
        long time2end = System.nanoTime() - time2start; 
        System.out.println("Данные для 1 потока: ");
        System.out.println("Результат: " + list.stream().mapToDouble(s -> s.getSum()).sum());
        System.out.println("Время выполнения: " + time2end);
        
    }
}
