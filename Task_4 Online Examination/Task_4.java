package OIB_Internsship_Projects;
// Online Examination System
import java.util.*;
public class Task_4 {
    private String username,password;
    private boolean isLoggedIn;
    private int timeRemaining,questionCount;
    private int[] userAns;
    private int[] rightAns;

    public Task_4(String username , String password){
        this.username = username;
        this.password = password;
        System.out.println("Your Registration is Successful !");
        this.isLoggedIn = false;
        this.timeRemaining = 10; //Min
        this.questionCount = 10;
        this.userAns = new int[questionCount];
        this.rightAns = new int[questionCount];
        //The ans will show option 1 or 2
        for (int i=0;i<questionCount;i++){
            rightAns[i] = (int) Math.round(Math.random());
        }
    }

    //Log in Method
    public void login(){
        System.out.println("Log in with your Credentials:- ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your USERNAME:- ");
        String iu = sc.nextLine();
        System.out.println("Enter Your PASSWORD:- ");
        String ip = sc.nextLine();

        if (iu.equals(username) && ip.equals(password)) {
            isLoggedIn = false;
            System.out.println("--Best Of Luck! Your Login is Successful--");
        } else {
            System.out.println("--Login failed. Please try again--.");
        }
    }
    //Log out Method
    public void logout(){
        isLoggedIn = false;
        System.out.println("Logged Out Successfully");
    }
    //Exam Starting Method
    public void startExam(){
        if (isLoggedIn){
            System.out.println("--Please Login with your Credentials First--");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("You have "+timeRemaining+" min to complete the exam");
        for(int i = 0; i<questionCount; i++){
            System.out.println("Question:- "+(i+1));
            System.out.println("Option 1:- ");
            System.out.println("Option 2:- ");
            System.out.println("Enter Your Choice below 1 or 2");
            int ans = sc.nextInt();
            userAns[i] = ans;
        }
        System.out.println("Want to submit your answers:- \n1. Yes \n2. No");
        int n = sc.nextInt();
        if (n==1){
            Submit();
        }
        else {
            try{
                Thread.sleep(timeRemaining*100);
            }
            catch (InterruptedException e){
                e.printStackTrace();
                Submit();
            }
        }
    }

    //Submit Method
    public void Submit(){
        if (isLoggedIn){
            System.out.println("First Log in !");
            return;
        }
        int marks = 0;
        for(int i = 0; i<questionCount; i++){
            if(userAns[i] == rightAns[i]){
                marks++;
            }
        }
        if(marks>5){
            System.out.println("You Are Passed");
        }
        else{
            System.out.println("Better luck next time");
        }
        System.out.println("Your marks "+marks+" out of "+questionCount);
        System.out.println("--Thank You--");
        logout();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Name:- ");
        String n = sc.nextLine();
        System.out.println("Create a password:- ");
        String d = sc.nextLine();

        Task_4 exam = new Task_4(n,d);
        exam.login();
        exam.startExam();
    }
}
