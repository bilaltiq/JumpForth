public class JumpForth {

    private Stack stack;
    private int programCounter;

    public JumpForth(Stack stack) {
        this.stack = stack;
        this.programCounter = 0;
    }

    public void start(String[] args) {
        long start = System.nanoTime();

        while (programCounter < args.length) {
            operation(args[programCounter]);
            programCounter++;
        }

        long end = System.nanoTime();
        stack.print();
        System.out.println("Runtime: " + (end - start) + " ns");

    }

    public void operation(String arg) {
        try {
            int x = Integer.parseInt(arg);
            stack.push(x);
        } catch (NumberFormatException e) {
        }

        switch (arg) {
            case "+":

                if (stack.size() >= 2) {
                    int x = stack.pop();
                    int y = stack.pop();

                    stack.push(x + y);
                }
                break;
            case "-":
                if (stack.size() >= 2) {
                    int x = stack.pop();
                    int y = stack.pop();

                    stack.push(x - y);
                }
                break;
            case "*":
                if (stack.size() >= 2) {
                    int x = stack.pop();
                    int y = stack.pop();

                    stack.push(x * y);
                }
                break;
            case "/":
                if (stack.size() >= 2) {
                    int x = stack.pop();
                    int y = stack.pop();

                    stack.push(x / y);
                }
            case "dup":
                if (stack.size() >= 1) {
                    int x = stack.pop();

                    stack.push(x);
                    stack.push(x);
                }
                break;
            case "drop":
                if (stack.size() >= 1) {
                    stack.pop();
                }
                break;
            case "swap":
                if (stack.size() >= 2) {
                    int tmp = stack.pop();
                    int tmp2 = stack.pop();

                    stack.push(tmp);
                    stack.push(tmp2);
                }
            case "rot":
                if (stack.size() >= 3) {
                    int tmp = stack.pop();
                    int tmp2 = stack.pop();
                    int tmp3 = stack.pop();

                    stack.push(tmp2);
                    stack.push(tmp);
                    stack.push(tmp3);
                }
            case "=":
                if (stack.size() >= 2) {
                    int tmp = stack.pop();
                    int tmp2 = stack.pop();

                    if (tmp == tmp2) {
                        stack.push(1);
                    } else {
                        stack.push(0);
                    }
                }
            case "<":
                if (stack.size() >= 2) {
                    int tmp = stack.pop();
                    int tmp2 = stack.pop();

                    if (tmp2 < tmp) {
                        stack.push(1);
                    } else {
                        stack.push(0);
                    }
                }
            case ">":
                if (stack.size() >= 2) {
                    int tmp = stack.pop();
                    int tmp2 = stack.pop();

                    if (tmp2 > tmp) {
                        stack.push(1);
                    } else {
                        stack.push(0);
                    }
                }
            case "jump":
                if (stack.size() >= 1) {
                    int tmp = stack.pop();
                    this.programCounter += tmp;
                }
            case "if":
                if (stack.size() >= 1) {
                    int tmp = stack.pop();

                    if (tmp <= 0) {
                        programCounter++;
                    }
                }
            case "yank":
                if (stack.size() >= 2) {
                    int tmp = stack.extractBottom();
                    stack.push(tmp);
                }
            case "shove":
                if (stack.size() >= 2) {
                    int tmp = stack.pop();
                    stack.insertBottom(tmp);
                }

        }

    }

    public static void main(String[] args) {

        // Stack stack = new ArrayStack();
        Stack stack = new ListStack();
        JumpForth jumptforth = new JumpForth(stack);

        jumptforth.start(args);

    }

}