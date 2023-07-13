package sg.edu.rp.c346.id22043453.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);


    }


    @Override
    protected void onResume() {
        super.onResume();

        // Step 2a: Obtain the SharedPreferences instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        // Step 2b: Retrieve the saved data from the SharedPreferences
        // with a default value if no matching data
        String strName = prefs.getString("name", "John");
        float gpa = prefs.getFloat("gpa", 0.0f);

        // Step 2c: Update the UI element with value
        etName.setText(strName);
        etGPA.setText(String.valueOf(gpa));


    }

    @Override
    protected  void onPause() {
        super.onPause();

        // Step 1a: Get the user input from the Edittext and store it in a variable
        String strName = etName.getText().toString();
        float gpa = Float.parseFloat(etGPA.getText().toString());

        // Step 1b: Obtain the SharedPreferences instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        // Step 1c: Create a SharedPreferences Editor by calling edit()
        SharedPreferences.Editor prefEdit = prefs.edit();

        // Step 1d: Set a key-value pair in the editor
        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", gpa);

        // Step 1e: Call commit() to save the changes made to the SharedPreferences
        prefEdit.commit();
    }
}