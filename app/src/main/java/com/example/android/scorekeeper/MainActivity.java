package com.example.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Team teamA;
    private Team teamB;
    private String nameTeamA;
    private String nameTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nameTeamA = this.getResources().getString(R.string.txt_team_a);
        this.nameTeamB = this.getResources().getString(R.string.txt_team_b);
        this.teamA = new Team(this.nameTeamA);
        this.teamB = new Team(this.nameTeamB);
    }

    /**
     * set the goal for selected team
     */
    public void goal(final View view) {
        if (null != view && view.getTag() instanceof String) {
            String tag = (String) view.getTag();
            if (tag.equals(this.teamA.getName())) {
                setMetricValue(this.teamA, MetricType.SCORE);
                display(this.teamA, MetricType.SCORE);
            }
            if (tag.equals(this.teamB.getName())) {
                setMetricValue(this.teamB, MetricType.SCORE);
                display(this.teamB, MetricType.SCORE);
            }
        }
    }

    /**
     * set the free kick for selected team
     */
    public void freeKick(final View view) {
        if (null != view && view.getTag() instanceof String) {
            String tag = (String) view.getTag();
            if (tag.equals(this.teamA.getName())) {
                this.setMetricValue(this.teamA, MetricType.FREE_KICK);
                this.display(this.teamA, MetricType.FREE_KICK);
            }
            if (tag.equals(this.teamB.getName())) {
                this.setMetricValue(this.teamB, MetricType.FREE_KICK);
                this.display(this.teamB, MetricType.FREE_KICK);
            }
        }
    }

    /**
     * set the corners for selected team
     */
    public void corner(final View view) {
        if (null != view && view.getTag() instanceof String) {
            String tag = (String) view.getTag();
            if (tag.equals(this.teamA.getName())) {
                this.setMetricValue(this.teamA, MetricType.CORNER);
                this.display(this.teamA, MetricType.CORNER);
            }
            if (tag.equals(this.teamB.getName())) {
                this.setMetricValue(this.teamB, MetricType.CORNER);
                this.display(this.teamB, MetricType.CORNER);
            }
        }
    }

    /**
     * set the penalties for selected team
     */
    public void penalty(final View view) {
        if (null != view && view.getTag() instanceof String) {
            String tag = (String) view.getTag();
            if (tag.equals(this.teamA.getName())) {
                this.setMetricValue(this.teamA, MetricType.PENALTY);
                this.display(this.teamA, MetricType.PENALTY);
            }
            if (tag.equals(this.teamB.getName())) {
                this.setMetricValue(this.teamB, MetricType.PENALTY);
                this.display(this.teamB, MetricType.PENALTY);
            }
        }
    }

    /**
     * reset all values for both teams
     */
    public void reset(final View view) {
        this.teamA.reset();
        this.display(this.teamA, MetricType.ALL);
        this.teamB.reset();
        this.display(this.teamB, MetricType.ALL);
    }

    /**
     * set value of selected metric type for selected team
     */
    private void setMetricValue(final Team team, final MetricType metricType) {
        switch (metricType) {
            case SCORE:
                team.setScore(team.getScore() + 1);
                break;
            case CORNER:
                team.setCorner(team.getCorner() + 1);
                break;
            case FREE_KICK:
                team.setFreeKick(team.getFreeKick() + 1);
                break;
            case PENALTY:
                team.setPenalty(team.getPenalty() + 1);
                break;
        }
    }

    /**
     * display values of selected metric type for the given team
     * @param metricType
     */
    private void display(final Team team, final MetricType metricType) {
        if (null != team) {

            if (team.getName().equals(this.nameTeamA)) {
                TextView textView;
                switch (metricType) {
                    case ALL:
                        textView = (TextView) findViewById(R.id.txt_team_a_score);
                        textView.setText(String.valueOf(team.getScore()));
                        textView = (TextView) findViewById(R.id.txt_team_a_free_kick);
                        textView.setText(String.valueOf(team.getFreeKick()));
                        textView = (TextView) findViewById(R.id.txt_team_a_corner);
                        textView.setText(String.valueOf(team.getCorner()));
                        textView = (TextView) findViewById(R.id.txt_team_a_penalty);
                        textView.setText(String.valueOf(team.getPenalty()));
                        break;
                    case SCORE:
                        textView = (TextView) findViewById(R.id.txt_team_a_score);
                        textView.setText(String.valueOf(team.getScore()));
                        break;
                    case FREE_KICK:
                        textView = (TextView) findViewById(R.id.txt_team_a_free_kick);
                        textView.setText(String.valueOf(team.getFreeKick()));
                        break;
                    case CORNER:
                        textView = (TextView) findViewById(R.id.txt_team_a_corner);
                        textView.setText(String.valueOf(team.getCorner()));
                        break;
                    case PENALTY:
                        textView = (TextView) findViewById(R.id.txt_team_a_penalty);
                        textView.setText(String.valueOf(team.getPenalty()));
                        break;
                }
            }

            if (team.getName().equals(this.nameTeamB)) {
                TextView textView;
                switch (metricType) {
                    case ALL:
                        textView = (TextView) findViewById(R.id.txt_team_b_score);
                        textView.setText(String.valueOf(team.getScore()));
                        textView = (TextView) findViewById(R.id.txt_team_b_free_kick);
                        textView.setText(String.valueOf(team.getFreeKick()));
                        textView = (TextView) findViewById(R.id.txt_team_b_corner);
                        textView.setText(String.valueOf(team.getCorner()));
                        textView = (TextView) findViewById(R.id.txt_team_b_penalty);
                        textView.setText(String.valueOf(team.getPenalty()));
                        break;
                    case SCORE:
                        textView = (TextView) findViewById(R.id.txt_team_b_score);
                        textView.setText(String.valueOf(team.getScore()));
                        break;
                    case FREE_KICK:
                        textView = (TextView) findViewById(R.id.txt_team_b_free_kick);
                        textView.setText(String.valueOf(team.getFreeKick()));
                        break;
                    case CORNER:
                        textView = (TextView) findViewById(R.id.txt_team_b_corner);
                        textView.setText(String.valueOf(team.getCorner()));
                        break;
                    case PENALTY:
                        textView = (TextView) findViewById(R.id.txt_team_b_penalty);
                        textView.setText(String.valueOf(team.getPenalty()));
                        break;
                }
            }
        }
    }
}
