package core.Actions;

import android.widget.EditText;

/**
 * Created by Jesus on 05/03/2018.
 */

public class verify_input_data extends Actions {

    private void _construct()
    {
        description = "Verificar datos de entradas de texto";
    }


    public verify_input_data(EditText input_text,EditText input_text2) {
        super();
        if( input_text.getText().toString().length() == 0 )
        {
            input_text.setError( "First name is required!" );
        }

    }
}
