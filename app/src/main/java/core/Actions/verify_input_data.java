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

    public boolean verify()
    {

        for (ruled_EditText editText: this.ruled_editText) {

            if(editText.min_lenght != null)
            {
                if(editText.CurrentEditText.length()<editText.min_lenght)
                {
                    editText.CurrentEditText.setError( "El numero de caracteres del texto no debe ser menor de "+editText.min_lenght);
                    return false;
                }

            }
            if(editText.max_lenght!= null)
            {
                if(editText.CurrentEditText.length()>editText.max_lenght)
                {
                    editText.CurrentEditText.setError("El numero de caracteres del texto no debe ser mayor de "+editText.max_lenght);
                    return false;
                }
            }
            if(editText.pattern != null)
            {
                Pattern pattern;
                Matcher mat;

                switch (editText.pattern){
                    case "email":
                        pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
                        mat = pattern.matcher(editText.CurrentEditText.getText().toString());
                        if(mat.matches()){
                            System.out.println("Valid email address");
                        }else{
                            editText.CurrentEditText.setError("No es un correo electronico valido");
                            return false;
                        }
                        break;
                    case "numbers":
                        pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
                        mat = pattern.matcher(editText.CurrentEditText.getText().toString());
                        if(mat.matches()){
                            System.out.println("Valid number");
                        }else{
                            editText.CurrentEditText.setError("El valor ingresado no es un numero");
                            return false;
                        }
                        break;
                    default:
                        break;
                }

            }
        }
        return true;
    }
}
