package com.sunyujun.encap.e01;

public class Account {
    private String name;
    private double balance;
    private String pwd;

    public Account() {
        name = "admin";
        balance = 0;
        pwd = "000000";
    }

    public Account(String name, double balance, String pwd) {
        setName(name);
        setBalance(balance);
        setPwd(pwd);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 2 || name.length() > 6){
            throw new RuntimeException("麻烦了, 操蛋了, 名字不对了");
        }
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        if (pwd.length() != 6){
            throw new RuntimeException("密码必须是6位数");
        }
        this.pwd = pwd;
    }
}
