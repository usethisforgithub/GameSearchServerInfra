public class Account {
    private String name;
    private String passwordHash;
    private boolean loggedIn;
    private boolean isHostingGameServer;
    private int tempKey;

    public Account(String n, String p){
        name = n;
        passwordHash = p;
        loggedIn = false;
        isHostingGameServer = false;
        tempKey = -1; // not on a server
    }

    public int logIn(String passHash){
        boolean success = passHash.equals(passwordHash);

        if(success && loggedIn == false){
            loggedIn = true;//successful login
            return 0;
        }else if(success && loggedIn == true){
            return 2;//already logged in, fishy flag, shows possible hacked client
        }else{
            return 1;//wrong password
        }

    }

    public int logOut(String passHash){
        boolean success = passHash.equals(passwordHash);

        if(success && loggedIn == true){
            loggedIn = false;//successful logout
            return 0;
        }else if(success && loggedIn == false){
            return 2;//already logged out, fishy flag, shows possible hacked client
        }else{
            return 1;//logout without proper credentials, fishy flag, shows possible hacked client
        }
    }

    public boolean changePassword(String oldPassHash, String newPassHash){
        boolean success = oldPassHash.equals(passwordHash);
        if(success){
            passwordHash = newPassHash;
        }
        return success;
    }

    public String getName(){
        return name;
    }

    public String getPasswordHash(){
        return passwordHash;
    }

    public boolean isLoggedIn(){
        return loggedIn;
    }

    public boolean isHosting(){
        return isHostingGameServer;
    }

    public void setIsHosting(Boolean val){
        isHostingGameServer = val;
    }

    public int getTempKey(){
        return tempKey;
    }

    public void setTempKey(int val){
        tempKey = val;
    }
}
