package com.example.code4covid_404notfound;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;
import java.util.Random;


public class QuizeFragment extends Fragment {
    private TextView questionTV,questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<QuizModel> quizModelArrayList;
    Random random;
    int currentScore = 0,questionAttempted = 1,currentPos;

    private Button clickg;
    private PieChart chart;
    //    private int i1 = 15;
    public int i2 ;
    //    private int i3 = 35;
    public int i4 ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_quize,container,false);
        questionTV = v.findViewById(R.id.idTVQuestion);
        questionNumberTV =v.findViewById(R.id.idTVQuestionsAttempted);
        option1Btn = v.findViewById(R.id.idBtnOption1);
        option2Btn = v.findViewById(R.id.idBtnOption2);
        option3Btn = v.findViewById(R.id.idBtnOption3);
        option4Btn = v.findViewById(R.id.idBtnOption4);
        quizModelArrayList = new ArrayList<>();
        random = new Random();
        getQuestion(quizModelArrayList);
        currentPos = random.nextInt(quizModelArrayList.size());
        setDataToView(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToView(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToView(currentPos);
            }
        });
        option3Btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToView(currentPos);
            }
        });
        option4Btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToView(currentPos);
            }
        });
        return v;
    }

    private void showBottomSheet(){
        LinearLayout linearLayout = new LinearLayout(getActivity());

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity());
        View bottomSheetView;
        bottomSheetView = LayoutInflater.from(getContext()).inflate(R.layout.score_bottom_sheet,linearLayout.findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTVScore);
        chart =bottomSheetView.findViewById(R.id.pie_chart);
        clickg = bottomSheetView.findViewById(R.id.btn_click);
        Button restartQuizeBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Basic Health Status Is \n"+currentScore+"/10");
        TextView statusTV =  bottomSheetView.findViewById(R.id.idTVStatus);
        if(currentScore>8){
            statusTV.setText("Your Are Healthy.");
        }
        else if(currentScore>5){
            statusTV.setText("Take home precaution");
        }
        else{
            statusTV.setText("Try visiting the doctor");
        }
        i2=currentScore*10;
        i4=(10-currentScore)*10;
        addToPieChart();
        restartQuizeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                questionAttempted = 0;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToView(currentPos);
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void setDataToView(int currentPos) {
        questionNumberTV.setText("Questions Attempted: " + questionAttempted + "/10");
        if (questionAttempted == 10) {

            showBottomSheet();
        } else {
            questionTV.setText(quizModelArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModelArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModelArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModelArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModelArrayList.get(currentPos).getOption4());
        }
    }

    private void getQuestion(ArrayList<QuizModel> quizModelArrayList) {
        quizModelArrayList.add(new QuizModel("How Are Your Feeling Today?","GREAT","GOOD","NOT WELL","WORST","GREAT"));
        quizModelArrayList.add(new QuizModel("Do you Have Cold Today?","Yes","No","Mild","severe","No"));
        quizModelArrayList.add(new QuizModel("Do you Have Cough Today?","Yes","No","Mild","severe","No"));
        quizModelArrayList.add(new QuizModel("Do you Have Fever Today?","Yes","No","Mild","severe","No"));
        quizModelArrayList.add(new QuizModel("Do you Have Body Pains Today?","Yes","No","Mild","severe","No"));
        quizModelArrayList.add(new QuizModel("Do you Have Breathing problem Today?","Yes","No","Mild","severe","No"));
        quizModelArrayList.add(new QuizModel("Are you habituated to drugs and alcohol?","Yes to both","Only to drugs","Only to alcohol","I am not habituated to either","I am not habituated to either"));
        quizModelArrayList.add(new QuizModel("Overall, how do you rate the local hospitals in your area?","Excellent","Above average","Below average","Very poor","Excellent"));
        quizModelArrayList.add(new QuizModel("how did you take your medicine?","In the right dosage and right time","someone prepares the medicine or reminds you to take it","Miss Often","Completely unable to take it","In the right dosage and right time"));
        quizModelArrayList.add(new QuizModel("Do you WorkOut Regularly","Yes","Sometimes","Rarely","No","Yes"));

    }

    private void addToPieChart() {
        // add to pie chart

//        chart.addPieSlice(new PieModel("Integer 1", i1, Color.parseColor("#FFA726")));
        chart.addPieSlice(new PieModel("Integer 2", i2, Color.parseColor("#66BB6A")));
//        chart.addPieSlice(new PieModel("Integer 3", i3, Color.parseColor("#EF5350")));
        chart.addPieSlice(new PieModel("Integer 4", i4, Color.parseColor("#ff0000")));
        chart.startAnimation();
        clickg.setClickable(false);
    }
}