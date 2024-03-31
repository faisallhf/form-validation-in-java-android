package com.example.formvalidation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText number;
    EditText email;
    EditText enter_password;
    EditText re_enter_password;
    Button Login;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextName);
        email = findViewById(R.id.editTextEmail);
        number = findViewById(R.id.editTextNumber);
        enter_password = findViewById(R.id.editTextPassword);
        re_enter_password = findViewById(R.id.editTextReEnterPassword);
        Login = findViewById(R.id.login_id);

        // Assuming you're validating upon a certain action like button click
        // e.g., a submit button click
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateForm()) {
                    Intent intent = new Intent(getApplicationContext(), NavigatedTo.class);
                    intent.putExtra("name", name.getText().toString());
                    intent.putExtra("number", number.getText().toString());
                    intent.putExtra("email", email.getText().toString());
                    intent.putExtra("password", enter_password.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validateForm() {
        String uname = name.getText().toString().trim();
        String uemail = email.getText().toString().trim();
        String unumber = number.getText().toString().trim();
        String uenter_password = enter_password.getText().toString().trim();
        String ure_enter_password = re_enter_password.getText().toString().trim();
        boolean isValid = true;

        if (uname.isEmpty()) {
            name.setError("Name can't be Empty.");
            isValid = false;
        } else if (uname.length() < 6) {
            name.setError("Name must be at least 6 characters");
            isValid = false;
        }

        if (unumber.isEmpty()) {
            number.setError("Number can't be Empty.");
            isValid = false;
        } else if (unumber.length() < 10) {
            number.setError("Number must be at least 10 digits");
            isValid = false;
        }

        if (uemail.isEmpty()) {
            email.setError("Email can't be Empty.");
            isValid = false;
        } else if (!uemail.contains("@gmail.com")) {
            email.setError("Email should contain @gmail.com");
            isValid = false;
        }

        if (uenter_password.isEmpty()) {
            enter_password.setError("Password can't be Empty.");
            isValid = false;
        }

        if (ure_enter_password.isEmpty()) {
            re_enter_password.setError("Re-enter Password can't be Empty.");
            isValid = false;
        } else if (!uenter_password.equals(ure_enter_password)) {
            re_enter_password.setError("Passwords do not match.");
            isValid = false;
        }

        return isValid;
    }
}
