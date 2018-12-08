package com.fcc.jdk8api.core.thread.concurrent.bank_water;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 16:52 2018/12/8
 */
public class BankWaterService implements Runnable {
    //创建4个屏障，处理完后执行当前类的run方法
    private CyclicBarrier c=new CyclicBarrier(4,this);

    private Executor executor= Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String,Integer> sheetBankWaterCount=new ConcurrentHashMap<String,Integer>();
    private void count(){
        for(int i=0;i<4;i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    //计算当前sheet的引流数据
                    sheetBankWaterCount.put(Thread.currentThread().getName(),1);
                    try {
                        c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public void run(){
        int result=0;
        for(Map.Entry<String,Integer> sheet : sheetBankWaterCount.entrySet()){
            result+=sheet.getValue();
        }
        sheetBankWaterCount.put("result",result);
        System.out.println(result);
    }

    public static void main(String[] args){
        BankWaterService bankWaterService=new BankWaterService();
        bankWaterService.count();
    }
}
