package core.Objects;

import android.widget.EditText;

/**
 * Created by Jesus on 11/03/2018.
 */

public class ruled_EditText {
    private String description = "Son los edittext a los que se le arreglan reglas de validación";

    public EditText CurrentEditText;
    public Integer max_lenght;
    public Integer min_lenght;
    public String pattern;

    public ruled_EditText(EditText CurrentEditText,Integer max_lenght,Integer min_lenght,String pattern)
    {
        this.CurrentEditText = CurrentEditText;
        this.max_lenght = max_lenght;
        this.min_lenght = min_lenght;
        this.pattern = pattern;
    }

}
