package com.boylan.csci;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

//Mike Boylan
class Task {    //Class that creates the tasks with Title, desc, priority
    private String title;
    private String description;
    private int priority;

    public Task(String title, String descriptoin, int priority) {
        this.title = title;
        this.description = descriptoin;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptoin() {
        return description;
    }

    public void setDescriptoin(String descriptoin) {
        this.description = descriptoin;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return title +": "+ description +"| Priority: "+ priority;
    }
}

//Will catch if any information is the wrong format
class UserInput{
    Scanner scanner = new Scanner(System.in);
    public String promptString(String message){
        System.out.println(message);
        String userInput= scanner.nextLine();
        String stringInput = "";
        boolean isString = false;
        while(!isString){
            try{
                stringInput= userInput;
                isString= true;
            }
            catch(Exception e){
                System.out.println(userInput+" is not a valid String."+message);
                userInput = scanner.nextLine();
            }
        }
        return stringInput;
    }
    public int promptInt(String message){
        System.out.println(message);
        String userInput = scanner.nextLine();

        int intInput = 0;
        boolean isInt = false;
        while(!isInt){
            try{
                intInput = Integer.parseInt(userInput);
                isInt=true;
            }
            catch(NumberFormatException e){
                System.out.println(userInput+" is not a valid integer. "+message);
                userInput = scanner.nextLine();
            }
        }

        return intInput;
    }
}

public class Main {
    static String menu(){
        String menuList="Please choose an option: " +
                "\n(1) Add a task." +
                "\n(2) Remove a task." +
                "\n(3) Update a task." +
                "\n(4) List all tasks." +
                "\n(0) Exit.";
        return menuList;
    }

    public static void main(String[] args) {
        List<Task> list = new ArrayList<>();
        while(true){
            UserInput input = new UserInput();
            int selection = input.promptInt(menu());

            if(selection== 0){
                System.out.println("Goodbye!");
                System.exit(0);
            }else if(selection==1){
                UserInput inputT = new UserInput();
                String title =inputT.promptString("Please enter the title of the task: ");
                UserInput inputD = new UserInput();
                String desc = inputD.promptString("Please enter a description of the task: ");
                UserInput inputP = new UserInput();
                int priority = inputP.promptInt("Please enter priority 0(low)-5(high): ");
                Task t1 = new Task(title,desc,priority);
                list.add(t1);
            }else if(selection==2){
                int currentPosition =0;
                for(Task items: list){
                    System.out.println("("+currentPosition+") "+items);
                }
                UserInput inputR = new UserInput();
                int remove = inputR.promptInt("Please type the number beside the task.");
                list.remove(remove);

            }else if(selection==3){
                int currentPosition = 0;
                for (Task items: list){
                    System.out.println("("+currentPosition+") "+items);
                    currentPosition++;
                }
                UserInput inputU = new UserInput();
                int update = inputU.promptInt("Please type the number beside the task.");
                UserInput inputT = new UserInput();
                String title =inputT.promptString("Please enter the title of the task: ");
                UserInput inputD = new UserInput();
                String desc = inputD.promptString("Please enter a description of the task: ");
                UserInput inputP = new UserInput();
                int priority = inputP.promptInt("Please enter priority 0(low)-5(high): ");
                Task t1 = new Task(title,desc,priority);
                list.set(update, t1);

            }else if(selection==4){
                for(Task items: list){
                    System.out.println(items);
                }
            }else{
                System.out.println("That is not a one of the choices.");
            }
        }
    }
}
