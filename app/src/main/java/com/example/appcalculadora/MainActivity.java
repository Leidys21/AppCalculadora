package com.example.appcalculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputNumber;
    private EditText inputNumber2;
    private EditText inputResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.inputNumber);
        inputNumber2 = findViewById(R.id.inputNumber2);
        inputResult = findViewById(R.id.inputResult);

        // Botón para la suma
        Button buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(this::onAdd);

        // Botón para la resta
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonSubtract.setOnClickListener(this::onSubtract);

        // Botón para la multiplicación
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(this::onMultiply);

        // Botón para la división
        Button buttonDivide = findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(this::onDivide);

        // Botón para limpiar los inputs
        Button buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(v -> clearInputs());
    }

    private void onAdd(View view) {
        performOperation(Operation.ADD);
    }

    private void onSubtract(View view) {
        performOperation(Operation.SUBTRACT);
    }

    private void onMultiply(View view) {
        performOperation(Operation.MULTIPLY);
    }

    private void onDivide(View view) {
        performOperation(Operation.DIVIDE);
    }

    private void performOperation(Operation operation) {
        String number1Str = inputNumber.getText().toString();
        String number2Str = inputNumber2.getText().toString();

        if (!number1Str.isEmpty() && !number2Str.isEmpty()) {
            double number1 = Double.parseDouble(number1Str);
            double number2 = Double.parseDouble(number2Str);
            double result = 0;

            switch (operation) {
                case ADD:
                    result = number1 + number2;
                    break;
                case SUBTRACT:
                    result = number1 - number2;
                    break;
                case MULTIPLY:
                    result = number1 * number2;
                    break;
                case DIVIDE:
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        inputResult.setText("No se puede dividir por cero");
                        return;
                    }
                    break;
            }

            inputResult.setText(String.valueOf(result));
        } else {
            inputResult.setText("Por favor ingresa los números");
        }
    }

    private void clearInputs() {
        inputNumber.setText("");
        inputNumber2.setText("");
        inputResult.setText("");
    }

    // Enum para las operaciones
    private enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }
}
