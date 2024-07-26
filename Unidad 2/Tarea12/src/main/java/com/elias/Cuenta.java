package com.elias;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

enum Operaciones{apertura, ingreso, reintegro};

public class Cuenta {
    private final String  bankAccount;
    private String          owner;
    private double          balance;
    private boolean         status = false;
    private List<Operacion> operations = new ArrayList<>();

    private void setBalance(double balance) {
        this.balance += balance;
    }

    public Cuenta(String owner, String bankAccount) {
        this.owner = owner;
        this.bankAccount = bankAccount;
    }

    public void open(double initBalance){
        if (status == false){
            this.balance = initBalance;
            operations.add(this.new Operacion(Operaciones.apertura, LocalDateTime.now(), initBalance));
            this.status = true;
        }
        else{
            throw new RuntimeException();
        }
    }

    public void deposit(double amount){
        if (amount > 0){
            setBalance(amount);
            operations.add(this.new Operacion(Operaciones.ingreso, LocalDateTime.now(), amount));
        }
        else{
            throw new RuntimeException();
        }
    }

    public void withdraw(double amount){
        if (amount > 0){
            setBalance(-amount);
            operations.add(this.new Operacion(Operaciones.reintegro, LocalDateTime.now(), amount));
        }
        else{
            throw new RuntimeException();
        }
    }

    public List<Operacion>  getOperations(){
        return (this.operations);
    }

    public class Operacion{
        private final Operaciones     op;
        private final LocalDateTime   date;
        private final double    amount;

        private Operacion(Operaciones op, LocalDateTime date, double amount){
            this.op = op;
            this.date = date;
            this.amount = amount;
        }

        public String toString(){
            String  text = Cuenta.this.owner + ", " + op + ": " + amount + ", " + date;
            return (text);
        }
    }
}
