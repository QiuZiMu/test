public class SynBlockExample {
    public static void main(String[] args) {
        Company c=new Company(6,"BAT");
        new Applicant(c,"谢洋",2).start();
        new Applicant(c,"余浩冉",2).start();
        new Applicant(c,"岳孟森",2).start();
    }
}

class Applicant extends Thread{
    Integer seats;
    public Applicant(Runnable target, String name, int seats) {
        super(target, name);
        this.seats=seats;
    }
}

class Company implements Runnable{

    Integer avaliable;
    String name;

    public Company(Integer avaliable, String name) {
        this.name=name;
        this.avaliable = avaliable;
    }

    public synchronized boolean bookTickets(Integer seats){
        if (seats>avaliable){
            return false;
        }
        avaliable-=seats;
        return true;
    }

     public void run() {
         Applicant p=(Applicant)Thread.currentThread();
         boolean flag=this.bookTickets(p.seats);
         if(flag){
             System.out.println(this.name+"上岸成功："+p.getName()+"->"+p.seats+"offer");
         }else{
             System.out.println(this.name+"上岸失败："+p.getName());
         }
     }
 }