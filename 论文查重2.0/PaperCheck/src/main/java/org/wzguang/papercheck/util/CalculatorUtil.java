package org.wzguang.papercheck.util;


import org.wzguang.papercheck.pojo.Paper;


public final class CalculatorUtil {
    /**
     * 计算重复字数
     * @param originText 原文文本
     * @param modifiedText 抄袭版论文文本
     */
    public static void calculate(Paper originText, Paper modifiedText){
        int sum = originText.getSentence().length();
        String origin = " " + originText.getSentence();
        String modification = " " + modifiedText.getSentence();
        //设置字符串长度,具体大小可自行设置
        int xLength = origin.length();
        int yLength = modification.length();
        int i = 1, j;
        int pre, cur;
        int[] opt = new int[yLength];
        for (; i < xLength; i++){
            pre = 0;
            for (j = 1; j < yLength; j++){
                cur = opt[j];
                if (origin.charAt(i) == modification.charAt(j)) {
                    opt[j] = pre + 1;
                }else{
                    opt[j] = Math.max(opt[j-1], opt[j]);
                }
                pre = cur;
            }
        }
        modifiedText.setRepetition(opt[yLength - 1]);
        modifiedText.setSum(sum);
    }
}
