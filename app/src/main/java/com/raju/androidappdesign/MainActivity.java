package com.raju.androidappdesign;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int vehicleNumber = 1;
    private EditText etMake, etYear, etColor, etPrice, etEngineSize;
    private TextView details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
    }

    private void initComponents() {
        etMake = findViewById(R.id.et_make);
        etYear = findViewById(R.id.et_year);
        etColor = findViewById(R.id.et_color);
        etPrice = findViewById(R.id.et_price);
        etEngineSize = findViewById(R.id.et_engine_size);
        details = findViewById(R.id.details);
    }

    public void displayResult(View view) {
        if (!isEmpty(etMake) | !isEmpty(etYear) | !isEmpty(etColor) | !isEmpty(etPrice) | !isEmpty(etEngineSize)) {
            String make = etMake.getText().toString().trim();
            int year = Integer.parseInt(etYear.getText().toString().trim());
            String color = etColor.getText().toString().trim();
            double price = Double.parseDouble(etPrice.getText().toString().trim());
            double engineSize = Double.parseDouble(etEngineSize.getText().toString().trim());

            Car car = new Car(vehicleNumber++, make, color, year, price, engineSize);

            setDetails(car);

            // hide keyboard
            InputMethodManager imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);

            etMake.requestFocus();
        }
    }

    private void setDetails(Car car) {
        details.append("This is vehicle No. " + car.getVehicleNumber() + "\n Manufacturer: " + car.getMake()
                + "\n Made year: " + car.getYear() + "\n Color: " + car.getColor() + "\n Price: " + car.getPrice() + "\n Engine size: "
                + car.getEngineSize() + "\n\n");

    }

    private boolean isEmpty(EditText editText) {
        if (editText.getText().toString().trim().isEmpty()) {
            editText.setError("Required");
            return true;
        } else {
            return false;
        }
    }
}
