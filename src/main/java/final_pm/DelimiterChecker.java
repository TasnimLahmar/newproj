


package final_pm;


import java.util.Scanner;
import java.util.Stack;

public class DelimiterChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        boolean balanced = true;
        String expression;
        
        System.out.print("Entrez une expression à base de délimiteurs : ");
        expression = sc.nextLine();
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    balanced = false;
                    System.out.println("L'expression n'est pas équilibrée. Le délimiteur " + c + " est incorrect à la position " + i + ".");
                    break;
                }
               char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    balanced = false;
                    System.out.println("L'expression n'est pas équilibrée. Le délimiteur " + c + " est incorrect à la position " + i + ".");
                    break;
                }
            }
        }
        
        if (balanced && stack.isEmpty()) {
            System.out.println("L'expression est équilibrée.");
        }
        else if (balanced) {
            System.out.println("L'expression n'est pas équilibrée. Il manque un délimiteur.");
        }
    }
}
