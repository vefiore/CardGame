package com.example.android.cardgame;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class card1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card1);
    }

    public void startEvaluation(View view) {
        String[] answers = evaluateGui();

        int result = evaluateQuiz(answers);

        toastResult(result);
    }

    public String[] evaluateGui() {
        String[] ret = new String[5];

        //collecting variable contents
        EditText editTextQuestion1 = findViewById(R.id.question_1);

        CheckBox checkBoxQuestion2Camden = findViewById(R.id.question_2_Camden);
        CheckBox checkBoxQuestion2Nyack = findViewById(R.id.question_2_Nyack);
        CheckBox checkBoxQuestion2Morristown = findViewById(R.id.question_2_Morristown);

        //checking answers based on input/boxes checked

        Boolean answerQuestion2 = false;

        if (checkBoxQuestion2Camden.isChecked() == true && checkBoxQuestion2Nyack.isChecked() == false && checkBoxQuestion2Morristown.isChecked() == true) {
            answerQuestion2 = true;
        }

        CheckBox checkBoxQuestion4Capital = findViewById(R.id.question_4_capital);
        CheckBox checkBoxQuestion4Ottowa = findViewById(R.id.question_4_ottowa);
        CheckBox checkBoxQuestion4Bavaria = findViewById(R.id.question_4_falls);

        Boolean answerQuestion4 = false;

        Boolean capital = checkBoxQuestion4Capital.isChecked();
        Boolean ottowa = checkBoxQuestion4Ottowa.isChecked();
        Boolean falls = checkBoxQuestion4Bavaria.isChecked();


        if (capital == true && ottowa == false && falls == false) {
            answerQuestion4 = true;
        }

        ret[0] = editTextQuestion1.getText().toString().toLowerCase();
        ret[1] = Boolean.toString(answerQuestion2);
        ret[2] = evaluateRadioGroup(R.id.radio_group_question_3).toLowerCase();
        ret[3] = Boolean.toString(answerQuestion4);
        ret[4] = evaluateRadioGroup(R.id.radio_group_question_5).toLowerCase();

        return ret;
    }


    //calculate results
    public int evaluateQuiz(String[] answers) {
        int result = 0;
        String[] correctAnswers = {"paris", "true", "south", "true", "germany"};

        for (int i = 0; i < correctAnswers.length; i++) {
            if (answers[i].equals(correctAnswers[i])) {
                result++;
            }
        }

        return result;
    }

    //show confirmation UI/Toast based on results

    public void toastResult(int result) {
        double  total  = 0;
        String message = result + " out of 5. ";

        if (result == 0) {
            message += "Better luck next time.";
        } else if (result == 1) {
            message += "Better luck next time.";
        } else if (result == 2) {
            message += "Better luck next time.";
        } else if (result == 3) {
            message += "Almost there!";
        } else if (result == 4) {
            message += "Great!";
        } else if (result == 5) {
            message += "Perfect!";
        }

        Toast reportResult = Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT);
        reportResult.show();

        //variable total for data persistence
        TextView totalView = findViewById(R.id.textView4);
        total = total  + result;
        totalView.setText(String.valueOf(total));

    }



    private String evaluateRadioGroup(int id) {
        RadioGroup radioGroupQuestion;
        RadioButton radioButtonQuestion;

        radioGroupQuestion = findViewById(id);

        int radioButtonId = radioGroupQuestion.getCheckedRadioButtonId();
        radioButtonQuestion = findViewById(radioButtonId);

        if (radioButtonQuestion == null) {
            return "";
        }

        return (String)radioButtonQuestion.getText();
    }


    //reset answers
    public void reset(View view) {
        EditText editText = findViewById(R.id.question_1);
        editText.setText("");

        CheckBox checkBox = findViewById(R.id.question_2_Camden);
        checkBox.setChecked(false);

        checkBox = findViewById(R.id.question_2_Nyack);
        checkBox.setChecked(false);

        checkBox = findViewById(R.id.question_2_Morristown);
        checkBox.setChecked(false);

        RadioGroup radioGroup = findViewById(R.id.radio_group_question_3);
        radioGroup.clearCheck();

        checkBox = findViewById(R.id.question_4_capital);
        checkBox.setChecked(false);

        checkBox = findViewById(R.id.question_4_ottowa);
        checkBox.setChecked(false);

        checkBox = findViewById(R.id.question_4_falls);
        checkBox.setChecked(false);

        radioGroup = findViewById(R.id.radio_group_question_5);
        radioGroup.clearCheck();
    }
}