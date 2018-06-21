package core.Objects;

import android.content.Context;
import android.content.SharedPreferences;

public class KeyValueDB {

    private SharedPreferences sharedPreferences;
    private static String PREF_NAME = "prefs";

    public KeyValueDB() {
        // Blank
    }

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static String getStringProperty(Context context, String key) {
        return getPrefs(context).getString(key, null);
    }

    public static int getIntProperty(Context context, String key){
        return getPrefs(context).getInt(key, 0);
    }

    public static void setProperty(Context context,String key, String input) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString(key, input);
        editor.commit();
    }
}