import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args){
        Socket socket = null;
        Scanner keyBoard = null;
        Scanner connectionIn = null;
        PrintStream connectionOut = null;



        try{
            socket = new Socket("127.0.0.1", 1234);
            connectionIn = new Scanner(socket.getInputStream());
            connectionOut = new PrintStream(socket.getOutputStream());
            keyBoard = new Scanner(System.in);


            //Runtime.getRuntime().addShutdownHook(new Thread(new UponShutdown(connectionOut)));

            boolean sentinel = true;


            while(sentinel){
                String command = keyBoard.nextLine();
                String name,pass,result;

                switch(command){
                    case "quit":
                        connectionOut.println("QUIT");
                        sentinel = false;
                        break;

                    case"create":
                        name = keyBoard.nextLine();
                        pass = keyBoard.nextLine();
                        connectionOut.println("CREATEACCOUNT");
                        connectionIn.nextLine();
                        connectionOut.println(name);
                        connectionIn.nextLine();
                        connectionOut.println(pass);

                        result = connectionIn.nextLine();
                        System.out.println(result);

                        break;

                    case "delete":
                        name = keyBoard.nextLine();
                        pass = keyBoard.nextLine();
                        connectionOut.println("DELETEACCOUNT");
                        connectionIn.nextLine();
                        connectionOut.println(name);
                        connectionIn.nextLine();
                        connectionOut.println(pass);

                        result = connectionIn.nextLine();
                        System.out.println(result);
                        break;

                    case "login":
                        name = keyBoard.nextLine();
                        pass = keyBoard.nextLine();
                        connectionOut.println("LOGIN");
                        connectionIn.nextLine();
                        connectionOut.println(name);
                        connectionIn.nextLine();
                        connectionOut.println(pass);

                        result = connectionIn.nextLine();
                        System.out.println(result);
                        break;


                    case "logout":
                        name = keyBoard.nextLine();
                        pass = keyBoard.nextLine();
                        connectionOut.println("LOGOUT");
                        connectionIn.nextLine();
                        connectionOut.println(name);
                        connectionIn.nextLine();
                        connectionOut.println(pass);

                        result = connectionIn.nextLine();
                        System.out.println(result);
                        break;



                    case "host":

                        name = keyBoard.nextLine();
                        pass = keyBoard.nextLine();
                        String sname = keyBoard.nextLine();

                        connectionOut.println("TRYTOHOST");

                        connectionIn.nextLine();
                        connectionOut.println(sname);
                        connectionIn.nextLine();
                        connectionOut.println(name);
                        connectionIn.nextLine();
                        connectionOut.println(pass);

                        int myresult = Integer.parseInt(connectionIn.nextLine());
                        connectionOut.println("OKAY");

                        if(myresult == 0){
                            //code to ineract with talk to game server

                        }









                        break;



                    default:
                        System.out.println("Did not recognize the command");
                        break;
                }




            }





            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }



    }




}


