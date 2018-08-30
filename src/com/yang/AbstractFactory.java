package com.yang;

import java.util.Date;

interface IFactory {
    public IUser createUser();
    public ILogin createLogin();
}

interface IUser {

    public void insert(Entity entity);
    public IUser getUser(int uid);

}

interface ILogin {

    public void insert(Login login);
    public Login getLogin(int id);

}

class Entity {

    private int uid;
    private String uname;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

}


class Login {

    private int id;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

class MysqlUser implements IUser{

    @Override
    public void insert(Entity entity) {
        System.out.println("对 MySQL 里的 User 表插入了一条数据");
    }

    @Override
    public IUser getUser(int uid) {
        System.out.println("通过 uid 在 MySQL 里的 User 表得到了一条数据");
        return null;
    }
}

class OracleUser implements IUser{

    @Override
    public void insert(Entity entity) {
        System.out.println("对 Oracle 里的 User 表插入了一条数据");
    }

    @Override
    public IUser getUser(int uid) {
        System.out.println("通过 uid 在 Oracle 里的 User 表得到了一条数据");
        return null;
    }
}


class MysqlLogin implements ILogin{

    @Override
    public void insert(Login login) {
        System.out.println("对 MySQL 里的 Login 表插入了一条数据");
    }

    @Override
    public Login getLogin(int id) {
        System.out.println("通过 uid 在 MySQL 里的 Login 表得到了一条数据");
        return null;
    }
}

class OracleLogin implements ILogin{

    @Override
    public void insert(Login login) {
        System.out.println("对 Oracle 里的 Login 表插入了一条数据");
    }

    @Override
    public Login getLogin(int id) {
        System.out.println("通过 uid 在 Oracle 里的 Login 表得到了一条数据");
        return null;
    }
}



class MysqlFactory implements IFactory{

    @Override
    public IUser createUser() {
        return new MysqlUser();
    }

    @Override
    public ILogin createLogin() {
        return new MysqlLogin();
    }
}

class OracleFactory implements IFactory{

    @Override
    public IUser createUser() {
        return new OracleUser();
    }

    @Override
    public ILogin createLogin() {
        return new OracleLogin();
    }
}


public class AbstractFactory {
    public static void main(String[] args) {
        Entity entity = new Entity();
        Login login = new Login();

        IFactory factory = new OracleFactory();
        IUser userOperation = factory.createUser();

        userOperation.getUser(1);
        userOperation.insert(entity);

        ILogin loginOperation = factory.createLogin();

        loginOperation.insert(login);
        loginOperation.getLogin(1);

    }
}
