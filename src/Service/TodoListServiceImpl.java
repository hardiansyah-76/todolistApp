package Service;

import Entity.TodoList;
import Repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        TodoList[] model = todoListRepository.getAll();
        System.out.println("TODO LIST");
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (model[i] != null) {
                System.out.println(no + ". " + todo.getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);

        todoListRepository.add(todoList);
        System.out.println("succes add todo");
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean success = todoListRepository.remove(number);
        if (success){
            System.out.println("succes remove todo : " + number);
        } else {
            System.out.println("failed remove todo : " + number);
        }
    }
}
