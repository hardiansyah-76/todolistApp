package Test.Service;


import Entity.TodoList;
import Repository.TodoListRepository;
import Repository.TodoListRepositoryImpl;
import Service.TodoListService;
import Service.TodoListServiceImpl;

public class TestServiceTodoList {
    public static void main(String[] args) {
        testRemoveTodoList();
    }

    public static void testShowTodoList() {

        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        todoListRepository.data[0] = new TodoList("Java");
        todoListRepository.data[1] = new TodoList("Kotlin");
        todoListRepository.data[2] = new TodoList("Swift");

        TodoListServiceImpl todoListService = new TodoListServiceImpl(todoListRepository);
        todoListService.showTodoList();

    }

    public static void testAddTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();

        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("learn java");
        todoListService.addTodoList("learn java oop");
        todoListService.addTodoList("learn java classes");

        todoListService.showTodoList();
    }

    public static void testRemoveTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();

        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        for (var i = 0; i < 5; i++) {
            todoListService.addTodoList("todo Activity - " + i);

            todoListService.showTodoList();

            todoListService.removeTodoList(5);

            todoListService.showTodoList();


            todoListService.removeTodoList(4);

            todoListService.showTodoList();
        }


    }
}
