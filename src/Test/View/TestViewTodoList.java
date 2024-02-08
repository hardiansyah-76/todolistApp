package Test.View;

import Repository.TodoListRepository;
import Repository.TodoListRepositoryImpl;
import Service.TodoListService;
import Service.TodoListServiceImpl;
import View.TodoListView;

public class TestViewTodoList {
    public static void main(String[] args) {
        testRemoveTodoList();
    }

    public static void testShowTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListService.addTodoList("JAVA");
        todoListService.addTodoList("KOTLIN");
        todoListService.addTodoList("C++");

        todoListView.showTodoList();
    }

    public static void testAddTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();

        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.addTodoList();
        todoListView.showTodoList();
    }

    public static void testRemoveTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();

        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.showTodoList();
        todoListView.addTodoList();

        todoListView.removeTodoList();
        todoListView.showTodoList();
    }
}