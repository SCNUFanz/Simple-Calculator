package com.example.calc_fanz;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Stack;

public class Calculator
{
    public static int priority(char a)
    {//判断符号优先级
        switch (a) {
            case '+':
            case '-':
            case '(':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return 0;
    }

    public static char[] middleToBack(String exp)
    {//中缀表达式转后缀表达式
        Stack<Character> stack = new Stack();//栈用来进出运算的符号
        char[] arr = exp.toCharArray();
        char[] brr = new char[arr.length * 2];//保存后缀表达式，需在数字和符号之间加空格区分，因此长度定为arr的2倍
        int count = 0;//标记brr

        for (int i = 0; i < arr.length; i++)
        {
            if (i == arr.length - 1) {//防止越界
                brr[count++] = arr[i];
                brr[count++] = ' ';
            } else if ((arr[i] >= '0' && arr[i] <= '9') && !(arr[i + 1] >= '0' && arr[i + 1] <= '9')) {
                brr[count++] = arr[i];
                brr[count++] = ' ';
            } else if (arr[i] >= '0' && arr[i] <= '9') {
                brr[count++] = arr[i];
            } else {//符号
                if (stack.isEmpty()) {
                    stack.push(arr[i]);
                } else if (arr[i] == '(') {
                    stack.push(arr[i]);
                } else if (arr[i] == ')') {
                    while (stack.peek() != '(') {//'('与')'之间的符号出栈
                        brr[count++] = stack.peek();
                        brr[count++] = ' ';
                        stack.pop();
                    }
                    stack.pop();//将'('出栈
                } else if (priority(arr[i]) >= priority(stack.peek())) {//如果优先级高于或等于栈顶元素，直接入栈
                    stack.push(arr[i]);
                } else if (priority(arr[i]) < priority(stack.peek())) {//如果优先级低于栈顶元素，依次出栈
                    while (!stack.isEmpty()) {
                        brr[count++] = stack.peek();
                        brr[count++] = ' ';
                        stack.pop();
                    }
                    stack.push(arr[i]);
                }
            }
        }
        while (!stack.empty()) {
            brr[count++] = stack.peek();
            brr[count++] = ' ';
            stack.pop();
        }
        return brr;
    }

    public static String calculate(char[] brr) {//后缀表达式求得计算结果
        Stack<Double> stack = new Stack();//栈用来进出运算的数字
        for (int i = 0; i < brr.length; ) {
            String number = "";
            if (brr[i] == ' '||brr[i]=='\0') {//空格或为空
                i++;
                continue;
            }
            if (brr[i] >= '0' && brr[i] <= '9') {//数字入栈
                while (brr[i] >= '0' && brr[i] <= '9') {
                    number += brr[i];
                    i++;
                }
                stack.push(Double.valueOf(number));//字符型转整型入栈
            } else if(brr[i]=='+'||brr[i]=='-'||brr[i]=='*'||brr[i]=='/') {//符号
                double top1 = stack.peek();
                stack.pop();
                double top2 = stack.peek();
                stack.pop();
                double result = operate(top2,top1,brr[i]);//注意top2和top1的位置
                stack.push(result);
                i++;
            }
        }
        return(stack.peek().toString());
    }

    public static double operate(Double item1, Double item2, char operator) {
        double result = 0;
        switch (operator) {
            case '+':
                result = item1 + item2;
                break;
            case '-':
                result = item1 - item2;
                break;
            case '*':
                result = item1 * item2;
                break;
            case '/':
                result = item1 / item2;
                break;
        }
        return result;
    }

    public static String resu (String exp)
    {
        char brr[] = middleToBack(exp);
        return calculate(brr);
    }
/*
    public static void main(String[] args)
    {
        String exp = "9+(3-1)*3+10/2";
        char[] brr = middleToBack(exp);
        calculate(brr);
    }
*/
}
