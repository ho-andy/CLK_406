public class Person {

    private String userName, password;
    //char personType;

    /**
     * Simple getter method for the userName variable.
     * @return userName
     */
    public String getUserName(){
        return userName;
    }//getUserName

    /**
     * Simple getter method for the password variable.
     * @return password
     */
    public String getPassword(){
        return password;
    }//getPassword

    /**
     * Simple setter method for the userName variable.
     * @param newUserName the new userName
     */
    public void setUserName(String newUserName){
        userName = newUserName;
    }//setUserName

    /**
     * Simple setter method for the password variable.
     * @param newPassword the new password
     */
    public void setPassword(String newPassword){
        password = newPassword;
    }//setPassword

}//Person
