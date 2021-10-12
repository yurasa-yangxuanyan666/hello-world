package com.mr.service;

import java.io.*;
import java.util.Arrays;

public class ScoureRecorder {
    private static final String SCOREFILE = "data/soure";
    private static int scores[] = new int[3];

    public static void init() {
        File f = new File(SCOREFILE);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            fis = new FileInputStream(f);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String value = br.readLine();
            if (!(value == null || "".equals(value))) {//如果value不为空，或者没有字符
                String vs[] = value.split(",");//分割字符串
                if (vs.length < 3) {//如果分割结果小于3
                    Arrays.fill(scores, 0);//数组填充0
                } else {
                    for (int i = 0; i < 3; i++) {
                        scores[i] = Integer.parseInt(vs[i]);//将记录文件中的值赋值给当前分数数组
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {//依次关闭先开后关
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                isr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //将成绩写到文件中
    public static void saveScore() {
        String value = scores[0] + "," + scores[1] + "," + scores[2];//拼接得分组
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            fos = new FileOutputStream(SCOREFILE);//文件字节输出流
            osw = new OutputStreamWriter(fos);//字节流转字符流
            bw = new BufferedWriter(osw);//缓冲字符流
            bw.write(value);
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                osw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    static public void  addNewScore(int score){
        int tmp[]=Arrays.copyOf(scores,4);//在之前的三个成绩创建一个4个成绩的数组
        tmp[3]=score;//新分数为第4个数
        Arrays.sort(tmp);//调用sort方法排序
        scores=Arrays.copyOfRange(tmp,1,4);//将后面三个元素赋值给scores
    }

    public static int[] getScores() {
        return scores;
    }
}
