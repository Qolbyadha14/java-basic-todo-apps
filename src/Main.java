import javax.swing.plaf.PanelUI;

public class Main {

    /***
     * create model for data list of todos app
     * we make it max 10 item
     */
    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        /*
         testShowTodos();
         testAddTodo();
         testRemoveTodo();
         testInput();
         testViewShowTodos();
         testViewAddTodo();
         testViewRemoveTodo();
         */
        viewShowTodos();
    }

    /***
     * show all todos
     */
    public  static  void  showTodos(){
        System.out.println("Todo List : ");
        for (int i = 0; i < model.length; i++) {
            String todo = model[i];

            if (todo == null){
                continue;
            }

            var number = i + 1;
            System.out.println(number + " - " + todo);
        }
    }

    public static void testShowTodos(){
        model[0] = "Buy milk";
        model[1] = "Learn Java";
        model[2] = "Make a cup of tea";
        model[3] = "Have lunch";
        model[4] = "Go to work";
        showTodos();
    }

    /***
     * add new todos to list
     */
    public static void addTodo(String todo){
//        check if model is full
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null){
                isFull = false;
                break;
            }
        }

//        if is full we can resize model
        if (isFull){
            String[] temp = new String[model.length * 2];
            for (int i = 0; i < model.length; i++) {
                temp[i] = model[i];
            }
            model = temp;
        }

        for (int i = 0; i < model.length; i++) {
            if (model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodo(){
        addTodo("Buy milk");
        addTodo("Learn Java");
        addTodo("Make a cup of tea");
        addTodo("Have lunch");
        addTodo("Go to work");
        addTodo("Go to bed");
        addTodo("Sleep");
        addTodo("Study");
        addTodo("Code");
        addTodo("Eat");
        addTodo("Repeat");
        addTodo("end");
        addTodo("practice");
        addTodo("complete");
        showTodos();
    }

    /***
     * remove todos from list
     */
    public static boolean removeTodo(Integer number){
        if ((number - 1) >= model.length){
            return false;
        }else if (model[number - 1] == null){
            return false;
        }else {
            for (int i = number - 1; i < model.length - 1; i++) {
                if (i == model.length - 1){
                    model[i] = null;
                }else {
                    model[i] = model[i + 1];
                }
            }

            return true;
        }
    }

    public static void testRemoveTodo(){
        model[0] = "Buy milk";
        model[1] = "Learn Java";
        model[2] = "Make a cup of tea";
        model[3] = "Have lunch";
        model[4] = "Go to work";
        removeTodo(1);
        removeTodo(2);
        removeTodo(10);
        showTodos();
    }


    public static  String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Name");
        System.out.println("Hello " + name);

        var age = input("Age");
        System.out.println("Age " + age);
    }

    /***
     * view for show list all todos
     */
    public static void viewShowTodos(){
        while (true){
            showTodos();
            System.out.println("Menu...");
            System.out.println("1 - Add");
            System.out.println("2 - Remove");
            System.out.println("x - Exit");

            var input = input("Choose");

            if (input.equals("1")){
                viewAddTodo();
            } else if (input.equals("2")){
                viewRemoveTodo();
            } else if (input.equals("x")){
                System.out.println("Bye");
                break;
            } else {
                System.out.println("Wrong input");
            }
        }
    }

    public static void testViewShowTodos(){
        addTodo("Buy milk");
        addTodo("Learn Java");
        addTodo("Make a cup of tea");
        addTodo("Have lunch");
        addTodo("Go to work");
        addTodo("Go to bed");
        viewShowTodos();
    }

    /***
     * view for add todos
     */
    public static void viewAddTodo(){
        System.out.println("Add Todo : ");
        var todo = input("Todo (x to exit)");

        if (todo.equals("x")){
            System.out.println("Bye");
        }else {
            addTodo(todo);
        }
    }

    public static void testViewAddTodo(){
        addTodo("Buy milk");
        addTodo("Learn Java");

        viewAddTodo();
        showTodos();
    }

    /***
     * view for deleted todos
     */
    public static void viewRemoveTodo(){
        System.out.println("Remove Todo : ");
        var number = input("Number (x to exit)");

        if (number.equals("x")){
            System.out.println("Bye");
        }else {
            if (removeTodo(Integer.valueOf(number))){
                System.out.println("Todo removed");
            } else {
                System.out.println("Wrong number");
            }
        }
    }

    public static void testViewRemoveTodo(){
        addTodo("Buy milk");
        addTodo("Learn Java");
        addTodo("Make a cup of tea");
        addTodo("Have lunch");
        addTodo("Go to work");
        addTodo("Go to bed");
        showTodos();
        viewRemoveTodo();
        showTodos();
    }
}