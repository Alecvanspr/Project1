package sample.inlogScreen;

public class ForgotPassword {
    Main main = new Main();
    public int getUser(String username){
        int ret = 0;
        for(int i = 0; i<main.arraykeeper.getData().size();i++){
            if(main.arraykeeper.getData().get(i).getUsername().equals(username)){
                ret = i;
            }
        }
        return ret;
    }
}
