package core.Actions;

import android.widget.EditText;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import core.Objects.ruled_EditText;

/**
 * Created by Jesus on 05/03/2018.
 */

public class verify_input_data extends Actions {

    private ArrayList<ruled_EditText> ruled_editText;
    private String current_description = "Verificar datos de entrada";


    public verify_input_data(ArrayList<ruled_EditText> ruled_editText) {
        setDescription(this.current_description);
        this.ruled_editText = ruled_editText;
    }

    public void verify()
    {

        for (ruled_EditText editText: this.ruled_editText) {

            if(editText.min_lenght != null)
            {
                if(editText.CurrentEditText.length()<editText.min_lenght)
                {
                    editText.CurrentEditText.setError( "El numero de caracteres del texto no debe ser menor de "+editText.min_lenght);
                }
            }
            if(editText.max_lenght!= null)
            {
                if(editText.CurrentEditText.length()>editText.max_lenght)
                {
                    editText.CurrentEditText.setError("El numero de caracteres del texto no debe ser mayor de "+editText.max_lenght);
                }
            }
            if(editText.pattern != null)
            {
                /*if(editText.CurrentEditText.getText().toString().matches(editText.pattern))
                {
                    editText.CurrentEditText.setError( "El texto viene en un formato no requerido" );
                }*/
                //System.out.println("verficar pattern");
                Pattern p = Pattern.compile(editText.pattern);
                String editstring = editText.CurrentEditText.getText().toString();
                System.out.println("verficar pattern "+editText.pattern+" "+editstring);
                Matcher m = p.matcher(editstring);
                if (m.find())
                {
                    System.out.println("patron  encontrado");
                }
                else
                {
                    editText.CurrentEditText.setError( "El texto viene en un formato no requerido" );
                    System.out.println("patron no encontrado");
                }
            }

        }
    }
}
