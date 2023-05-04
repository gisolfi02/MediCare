package model;

public class Counter {
    private int counter;

    public Counter(){
    }

    public void increaseCounter(){
       this.counter++;
    }
    public void setSessionCount(int count){
        this.counter = count;
    }
    public int getSessionCount(){
        return this.counter;
    }

    public void decreaseCounter(){
         this.counter--;
    }

    public int getCounter(){
        return this.counter;
    }



}
