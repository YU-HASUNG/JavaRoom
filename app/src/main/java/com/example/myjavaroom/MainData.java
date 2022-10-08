package com.example.myjavaroom;

import androidx.room.ColumnInfo;
import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "players")
public class MainData implements Serializable
{
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "spid")
    private String text;

    @ColumnInfo(name = "position")
    private String position;

    @ColumnInfo(name = "position1")
    private String position1;

    @ColumnInfo(name = "position2")
    private String position2;

    @ColumnInfo(name = "season")
    private String season;

    @ColumnInfo(name = "nation")
    private String nation;

    @ColumnInfo(name = "pay")
    private String pay;

    @ColumnInfo(name = "team1")
    private String team1;

    @ColumnInfo(name = "team2")
    private String team2;

    @ColumnInfo(name = "team3")
    private String team3;

    @ColumnInfo(name = "team4")
    private String team4;

    @ColumnInfo(name = "team5")
    private String team5;

    @ColumnInfo(name = "team6")
    private String team6;

    @ColumnInfo(name = "team7")
    private String team7;

    @ColumnInfo(name = "team8")
    private String team8;

    @ColumnInfo(name = "team9")
    private String team9;

    @ColumnInfo(name = "team10")
    private String team10;

    @ColumnInfo(name = "team11")
    private String team11;

    @ColumnInfo(name = "team12")
    private String team12;

    @ColumnInfo(name = "team13")
    private String team13;

    @ColumnInfo(name = "team14")
    private String team14;

    @ColumnInfo(name = "team15")
    private String team15;

    @ColumnInfo(name = "team16")
    private String team16;

    @ColumnInfo(name = "team17")
    private String team17;

    @ColumnInfo(name = "team18")
    private String team18;

    @ColumnInfo(name = "team19")
    private String team19;

    @ColumnInfo(name = "team20")
    private String team20;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public String getPosition1() {
        return position1;
    }

    public void setPosition1(String position1) {
        this.position1 = position1;
    }

    public String getPosition2() {
        return position2;
    }

    public void setPosition2(String position2) {
        this.position2 = position2;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getSeason()
    {
        return season;
    }

    public void setSeason(String season)
    {
        this.season = season;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getTeam3() {
        return team3;
    }

    public void setTeam3(String team3) {
        this.team3 = team3;
    }

    public String getTeam4() {
        return team4;
    }

    public void setTeam4(String team4) {
        this.team4 = team4;
    }

    public String getTeam5() {
        return team5;
    }

    public void setTeam5(String team5) {
        this.team5 = team5;
    }

    public String getTeam6() {
        return team6;
    }

    public void setTeam6(String team6) {
        this.team6 = team6;
    }

    public String getTeam7() {
        return team7;
    }

    public void setTeam7(String team7) {
        this.team7 = team7;
    }

    public String getTeam8() {
        return team8;
    }

    public void setTeam8(String team8) {
        this.team8 = team8;
    }

    public String getTeam9() {
        return team9;
    }

    public void setTeam9(String team9) {
        this.team9 = team9;
    }

    public String getTeam10() {
        return team10;
    }

    public void setTeam10(String team10) {
        this.team10 = team10;
    }

    public String getTeam11() {
        return team11;
    }

    public void setTeam11(String team11) {
        this.team11 = team11;
    }

    public String getTeam12() {
        return team12;
    }

    public void setTeam12(String team12) {
        this.team12 = team12;
    }

    public String getTeam13() {
        return team13;
    }

    public void setTeam13(String team13) {
        this.team13 = team13;
    }

    public String getTeam14() {
        return team14;
    }

    public void setTeam14(String team14) {
        this.team14 = team14;
    }

    public String getTeam15() {
        return team15;
    }

    public void setTeam15(String team15) {
        this.team15 = team15;
    }

    public String getTeam16() {
        return team16;
    }

    public void setTeam16(String team16) {
        this.team16 = team16;
    }

    public String getTeam17() {
        return team17;
    }

    public void setTeam17(String team17) {
        this.team17 = team17;
    }

    public String getTeam18() {
        return team18;
    }

    public void setTeam18(String team18) {
        this.team18 = team18;
    }

    public String getTeam19() {
        return team19;
    }

    public void setTeam19(String team19) {
        this.team19 = team19;
    }

    public String getTeam20() {
        return team20;
    }

    public void setTeam20(String team20) {
        this.team20 = team20;
    }
}