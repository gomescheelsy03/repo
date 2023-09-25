/**
 * The DataManager class provides a set of methods that return greetings 
 * in different languages. This class acts as a simple data layer for the application 
 * and is designed to be independent of the GUI or any other layers.
 * 
 * @author YourName (or whoever wrote it)
 */
public class DataManager {
    
    /**
     * Default constructor for the DataManager class.
     */
    DataManager() { }

    /**
     * Returns a greeting in English.
     * 
     * @return a string "Hello World"
     */
    public String getHello() {
        return "Hello World";
    }

    /**
     * Returns a greeting in Southern English.
     * 
     * @return a string "Howdy y'all"
     */
    public String getHowdy() {
        return "Howdy y'all";
    }

    /**
     * Returns a greeting in Chinese.
     * 
     * @return a string "Ni hau"
     */
    public String getChinese() {
        return "Ni hau";
    }

    /**
     * Returns a greeting in French.
     * 
     * @return a string "Bonjour"
     */
    public String getBonjour() {
        return "Bonjour";
    }
}
