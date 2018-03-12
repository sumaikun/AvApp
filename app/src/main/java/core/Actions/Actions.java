package core.Actions;

/**
 * Created by Jesus on 05/03/2018.
 */

 abstract class Actions {
    public String description;
    public String[] commands;

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription(String description)
    {
        return this.description ;
    }
    /*protected Actions(String description,String[] commands)
    {
        this.description = description;
        this.commands = commands;
    }*/
}
