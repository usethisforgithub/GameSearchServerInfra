import java.util.ArrayList;

public class GameServerPA {


    private String IP;
   // private int port;
    private String serverName;
    private String hostAccountName;
    private long threadID;
    private ArrayList<Account> connectedClients;

    private int updateIndex;

    public GameServerPA(String i,  String sname, String h, long t){
        IP = i;
        //port = p;
        serverName = sname;
        hostAccountName = h;
        threadID = t;
        connectedClients = new ArrayList<Account>();
        updateIndex = 0;
    }
    
    
    public String getIP(){
        return IP;
    }
    
  //  public int getPort(){
   //     return port;
   // }
    
    public String getServerName(){
        return serverName;
    }
    
    public String getHostAccountName(){
        return hostAccountName;
    }
    
    public long getThreadID(){
        return threadID;
    }

    public boolean connectClient(Account account){
        for(int i = 0; i < connectedClients.size(); i++){
            if(connectedClients.get(i).getName().equals(account.getName())){
                return false;
            }
        }
        boolean returnVal = connectedClients.add(account);
        if(returnVal){
            updateIndex++;
        }
        return returnVal;
    }
    
    public boolean disconnectClient(Account account){

        for(int i = 0; i < connectedClients.size(); i++){
            if(connectedClients.get(i).getName().equals(account.getName())){
                updateIndex++;
                return connectedClients.remove(account);
            }
        }
        return false;
    }

    public int getUpdateIndex(){
        return updateIndex;
    }

    public ArrayList<Account> getConnectedClientList(){
        return connectedClients;
    }

   // private void updateTheIndex(){
       // updateIndex++;
    //}



}
