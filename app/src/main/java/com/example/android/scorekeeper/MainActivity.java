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

        nameTeamA = this.getResources().getString(R.string.txt_team_a);
        nameTeamB = this.getResources().getString(R.string.txt_team_b);
        teamA = new Team(nameTeamA);
        teamB = new Team(nameTeamB);
    }

    /**
     * set the goal for selected team
     */
    public void goal(final View view) {
        if (null != view && view.getTag() instanceof String) {
            String tag = (String) view.getTag();
            if (tag.equals(this.teamA.getName())) {
                incrementAndDisplay(this.teamA, MetricType.SCORE);
            } else {
                incrementAndDisplay(this.teamB, MetricType.SCORE);
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
                this.incrementAndDisplay(this.teamA, MetricType.FREE_KICK);
            } else {
                this.incrementAndDisplay(this.teamB, MetricType.FREE_KICK);
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
                this.incrementAndDisplay(this.teamA, MetricType.CORNER);
            } else {
                this.incrementAndDisplay(this.teamB, MetricType.CORNER);
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
                this.incrementAndDisplay(this.teamA, MetricType.PENALTY);
            } else {
                this.incrementAndDisplay(this.teamB, MetricType.PENALTY);
            }
        }
    }

    /**
     * reset all values for both teams
     */
    public void reset(final View view) {
        this.teamA.reset();
        this.incrementAndDisplay(this.teamA, MetricType.ALL);
        this.teamB.reset();
        this.incrementAndDisplay(this.teamB, MetricType.ALL);
    }

    /**
     * increment and display value of selected metric type for selected team
     */
    private void incrementAndDisplay(final Team team, final MetricType metricType) {
        if (null != team && null != metricType) {
            // do increment stuff
            team.increment(metricType);

            // do display stuff
            int teamIdScore = R.id.txt_team_a_score;
            int teamIdFreeKick = R.id.txt_team_a_free_kick;
            int teamIdCorner = R.id.txt_team_a_corner;
            int teamIdPenalty = R.id.txt_team_a_penalty;
            if (null != team.getName() && team.getName().equals(this.nameTeamB)) {
                teamIdScore = R.id.txt_team_b_score;
                teamIdFreeKick = R.id.txt_team_b_free_kick;
                teamIdCorner = R.id.txt_team_b_corner;
                teamIdPenalty = R.id.txt_team_b_penalty;
            }

            TextView textView = null;
            switch (metricType) {
                case ALL:
                    textView = (TextView) findViewById(teamIdScore);
                    textView.setText(String.valueOf(team.getScore()));
                    textView = (TextView) findViewById(teamIdFreeKick);
                    textView.setText(String.valueOf(team.getFreeKick()));
                    textView = (TextView) findViewById(teamIdCorner);
                    textView.setText(String.valueOf(team.getCorner()));
                    textView = (TextView) findViewById(teamIdPenalty);
                    textView.setText(String.valueOf(team.getPenalty()));
                    break;
                case SCORE:
                    textView = (TextView) findViewById(teamIdScore);
                    textView.setText(String.valueOf(team.getScore()));
                    break;
                case FREE_KICK:
                    textView = (TextView) findViewById(teamIdFreeKick);
                    textView.setText(String.valueOf(team.getFreeKick()));
                    break;
                case CORNER:
                    textView = (TextView) findViewById(teamIdCorner);
                    textView.setText(String.valueOf(team.getCorner()));
                    break;
                case PENALTY:
                    textView = (TextView) findViewById(teamIdPenalty);
                    textView.setText(String.valueOf(team.getPenalty()));
                    break;
            }
        }
    }
}
