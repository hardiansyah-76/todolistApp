public class AplikasiTodoList {
    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * show todo list
     */
    public static void showTodoList() {
        System.out.println("TODO LIST");
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (model[i] != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodoList() {
        model[0] = "Learn Basic Java";
        model[1] = "Learn Java OOP";
        showTodoList();
    }

    /**
     * add todo to list
     */
    public static void addTodoList(String todo) {
        // check whether the model (array) is full
        var isFull = true;
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        // if it is full, then the model (array) is resized 2x
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (var i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // add to the array data position which is null
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for (var i = 0; i < 25; i++) {

            addTodoList("Example todo " + i);
        }
        showTodoList();

    }

    /**
     * Remove todo list
     */
    public static boolean removeTodoList(int number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (var i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }

            }
            return true;
        }
    }

    public static void testRemoveTodoList() {
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        var result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    /**
     * input for USER
     * String info for information input
     *
     */
    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var name = input("Name");
        System.out.println("Hi " + name);

        var country = input("Country");
        System.out.println("Ohh You " + name + " from " + country);
    }

    /**
     * view for show todo list
     */
    public static void viewShowTodoList() {
        while (true) {
            showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Add todo");
            System.out.println("2. Remove todo");
            System.out.println("x. Exit App");

            var input = input("Choose");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Wrong input");
            }
        }
    }

    public static void testViewShowTodoList() {
        addTodoList("One");
        addTodoList("Two");
        addTodoList("Three");
        addTodoList("Four");
        addTodoList("Five");
        viewShowTodoList();
    }

    /**
     * view for add todo list
     */
    public static void viewAddTodoList() {
        System.out.println("Add TodoList");
        var todo = input("todo : (x for cancel)");

        if (todo.equals("x")) {
            // stop
        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList() {
        addTodoList("one");
        addTodoList("two");

        viewAddTodoList();

        showTodoList();
    }

    /**
     * view for remove todo list
     */
    public static void viewRemoveTodoList() {
        var number = input("Number to delete : (x untuk for cancel)");
        if (number.equals("x")) {
            // cancel
        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("failed to remove" + number);
            }
        }
    }

    public static void testViewRemoveTodoList() {
        addTodoList("one");
        addTodoList("two");
        addTodoList("three");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}
