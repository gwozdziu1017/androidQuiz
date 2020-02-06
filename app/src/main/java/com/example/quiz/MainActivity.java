package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Spinner dropBox;
    List<Question> listOfQuestions = new LinkedList<>();
    TextView lblQuestion;
    TextView txtWinOrLose;

    int questionId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dropBox = findViewById(R.id.dropBox);
        lblQuestion = findViewById(R.id.lblQuestion);
        txtWinOrLose = findViewById(R.id.txtWinOrLose);
        String[] items = new String[]{"Matematyka", "Historia"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropBox.setAdapter(arrayAdapter);
        listOfQuestions = populateQuestions();
    }

    public void drawQuestion(View view)
    {
       //Log.d("info", listOfQuestions.get(0).getLabel());
        questionId = getRandomNumber(listOfQuestions.size());
        lblQuestion.setText(listOfQuestions.get(questionId).getLabel());
    }

    public void checkAnswerYes(View view)
    {
        if(listOfQuestions.get(questionId).getRightAnswer() == true)
        {
            txtWinOrLose.setText("Wygrana");
        }
        else
        {
            txtWinOrLose.setText("Przegrana");
        }
    }

    public void checkAnswerNo(View view)
    {
        if(listOfQuestions.get(questionId).getRightAnswer() == false)
        {
            txtWinOrLose.setText("Wygrana");
        }
        else
        {
            txtWinOrLose.setText("Przegrana");
        }
    }

    private List<Question> populateQuestions()
    {
        List<Question> questionList= new LinkedList<>();
        questionList.add(new Question("2+2=4", true));
        questionList.add(new Question("2^10=1024", true));
        questionList.add(new Question("9876-10=0", false));

        return questionList;
    }

    public int getQuestionCategory()
    {
        return getQuestionCategoryId(dropBox.getSelectedItem().toString());
    }

    public int getQuestionCategoryId(String questionCategoryString)
    {
        switch (questionCategoryString)
        {
            case "Matematyka":
                return 1;
            case "Historia":
                return 2;
            default:
                return 0;
        }
    }

    public int getRandomNumber(int maxNumber)
    {
        Random rand = new Random();
        return rand.nextInt((maxNumber - 1) + 1) + 1;
    }
}
