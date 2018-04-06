public class Person {

    private String username, password;
    private char personType;

    /**
     * Basic constructor for the Person Class
     * @param user Initialize userName
     * @param pass Initialize password
     */
    public Person(String user, String pass, char type){
        username = user;
        password = pass;
        personType = type;
    }//Person

    public Person(String user, String pass){
        username = user;
        password = pass;
    }//Person

    /**
     * Simple getter method for the userName variable.
     * @return userName
     */
    public String getUserName(){
        return username;
    }//getUserName

    /**
     * Simple getter method for the password variable.
     * @return password
     */
    public String getPassword(){
        return password;
    }//getPassword

    public char getPersonType(){
        return personType;
    }

    /**
     * Simple setter method for the userName variable.
     * @param newUserName the new userName
     */
    public void setUserName(String newUserName){
        username = newUserName;
    }//setUserName

    /**
     * Simple setter method for the password variable.
     * @param newPassword the new password
     */
    public void setPassword(String newPassword){
        password = newPassword;
    }//setPassword

    public void setPersonType(char newType){
        personType = newType;
    }

    public String toString(){
        return getUserName() + " " + getPassword() + " " + getPersonType();
    }

}//Person
