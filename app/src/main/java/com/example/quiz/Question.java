package com.example.quiz;

public class Question
{
    private String label;
    private Boolean rightAnswer;

    public Question(String label, Boolean rightAnswer)
    {
        this.label = label;
        this.rightAnswer = rightAnswer;
    }

    public Question() { }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public Boolean getRightAnswer()
    {
        return rightAnswer;
    }

    public void setRightAnswer(Boolean rightAnswer)
    {
        this.rightAnswer = rightAnswer;
    }
}
