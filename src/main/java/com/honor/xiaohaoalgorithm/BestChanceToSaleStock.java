package com.honor.xiaohaoalgorithm;

/**
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * <p>
 * ​ 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * <p>
 * ​ 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * <p>
 * ​ 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * <p>
 * 示例 3:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 题目分析：首先我们看一下题目中给出的两个条件：
 * <p>
 * 1、不能参与多笔交易。换句话讲，我们只能在手上没有股票的时候买入，也就是必须在再次购买前出售掉之前的股票。像我们平时买股票时的追涨杀跌是不可以的。
 * <p>
 * 2、尽可能地多进行交易。这个非常好理解。像是黄金，一年基本上都有2-3次涨跌。我们只要把握住机会，在每一次涨跌的时候，低价卖入高价卖出，就可以使利益达到最大化。这个条件也是相当重要的，如果我们把这里变成，最多完成两笔交易，就变成另一道题。
 *
 * @program: cloud-integration
 * @description:
 * @Author: baimeng
 * @Date: 2021/8/14 12:56
 */
public class BestChanceToSaleStock {
    public static void main(String[] args) {
        BestChanceToSaleStock bestChanceToSaleStock = new BestChanceToSaleStock();

//        int[] stocks = new int[]{7,1,5,3,6,4};
//        int[] stocks = new int[]{1,2,3,4,5};
        int[] stocks = new int[]{7, 6, 4, 3, 1};
        int stock = bestChanceToSaleStock.stock(stocks);
        System.out.println(stock);

    }

    public int stock(int[] stocks) {

        int buy = -1;


        int total = 0;
        for (int i = 0; i < stocks.length; i++) {
            //低点
            if (checkLow(i, stocks)) {
                buy = i;
            }

            //高点
            if (checkHigh(i, stocks) && buy >= 0) {
                total += stocks[i] - stocks[buy];
                buy = -1;
            }


        }


        return total;


    }

    private boolean checkHigh(int i, int[] stocks) {
        int current = stocks[i];

        int leftIndex = i - 1;


        int rightIndex = i + 1;
        int leftValue = leftIndex > 0 ? stocks[leftIndex] : Integer.MIN_VALUE;

        int rightValue = rightIndex < stocks.length ? stocks[rightIndex] : Integer.MIN_VALUE;

        return current >= leftValue && current > rightValue;
    }

    private boolean checkLow(int i, int[] stocks) {
        int current = stocks[i];

        int leftIndex = i - 1;


        int rightIndex = i + 1;
        int leftValue = leftIndex >= 0 ? stocks[leftIndex] : Integer.MAX_VALUE;

        int rightValue = rightIndex < stocks.length ? stocks[rightIndex] : Integer.MAX_VALUE;

        return current <= leftValue && current < rightValue;
    }
}
