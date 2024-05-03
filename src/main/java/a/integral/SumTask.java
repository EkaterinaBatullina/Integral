/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a.integral;

/**
 *
 * @author ekaterina
 */
public class SumTask extends Thread{
    
    private int intervalCount;
    private int n;
    private double a;
    private double b;
    
    private double sum;
    
    public SumTask(double a, double b, int n, int intervalCount) {
        
        this.a = a;
        this.b = b;
        this.n = n;
        this.intervalCount = intervalCount;
        
    }
    
    public double getSum() {
        
        return sum;
        
    }
    
    private double func(double x) {
        
        return Math.sin(x);
        
    }
    
    public void run() {

        for (double i = a; i < b; i += (b - a) / (intervalCount / n)) {
            sum += ((b - a) / (intervalCount / n)) * func(i);
        }
        
    }

}
