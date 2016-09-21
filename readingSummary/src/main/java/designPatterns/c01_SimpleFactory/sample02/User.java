package designPatterns.c01_SimpleFactory.sample02;

public abstract class User {
    public void sameOperation() {
        System.out.println("修改个人资料！");
    }

    public abstract void diffOperation();
}