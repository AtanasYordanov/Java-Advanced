package LinearDataStructures.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class InfixToPrefix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        Deque<String> numbersQueue = new ArrayDeque<>();
        Deque<String> operatorStack = new ArrayDeque<>();
        for (String element : input) {
            if (Character.isDigit(element.charAt(0)) || Character.isLetter(element.charAt(0))) {
                numbersQueue.offer(element);
            } else {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(element);
                } else {
                    String lastOperator = operatorStack.peek();
                    switch (element) {
                        case "+":
                        case "-":
                            if (lastOperator.equals("(")) {
                                operatorStack.push(element);
                            } else {
                                numbersQueue.offer(operatorStack.pop());
                                operatorStack.push(element);
                            }
                            break;
                        case "*":
                        case "/":
                            if (lastOperator.equals("*") || lastOperator.equals("/")) {
                                numbersQueue.offer(operatorStack.pop());
                                operatorStack.push(element);
                            } else {
                                operatorStack.push(element);
                            }
                            break;
                        case "(":
                            operatorStack.push(element);
                            break;
                        case ")":
                            while (!operatorStack.peek().equals("(")) {
                                numbersQueue.offer(operatorStack.pop());
                            }
                            operatorStack.pop();
                            break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!numbersQueue.isEmpty()) {
            sb.append(numbersQueue.poll()).append(" ");
        }
        while (!operatorStack.isEmpty()) {
            sb.append(operatorStack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}
