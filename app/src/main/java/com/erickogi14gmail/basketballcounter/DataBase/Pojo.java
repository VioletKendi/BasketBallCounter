package com.erickogi14gmail.basketballcounter.DataBase;

/**
 * Created by kimani kogi on 4/14/2017.
 */

public class Pojo {
    private  int id;

    private   String NAME_A ;
    private   String NAME_B;


    private   int TEAM_ONE_R1 ;
    private   int TEAM_TWO_R1;

    private   int TEAM_ONE_R2;
    private   int TEAM_TWO_R2 ;

    private   int TEAM_ONE_R3 ;
    private   int TEAM_TWO_R3 ;

    private   int TEAM_ONE_R4 ;
    private   int TEAM_TWO_R4 ;

    private   int TEAM_ONE_R5 ;
    public  int TEAM_TWO_R5 ;

    private   int TEAM_ONE_T;
    private   int TEAM_TWO_T;

    public Pojo() {
    }

    public Pojo(int id, String NAME_A, String NAME_B, int TEAM_ONE_R1, int TEAM_TWO_R1,
                int TEAM_ONE_R2, int TEAM_TWO_R2, int TEAM_ONE_R3, int TEAM_TWO_R3,
                int TEAM_ONE_R4, int TEAM_TWO_R4, int TEAM_ONE_R5, int TEAM_TWO_R5,
                int TEAM_ONE_T, int TEAM_TWO_T) {
        this.id = id;
        this.NAME_A = NAME_A;
        this.NAME_B = NAME_B;
        this.TEAM_ONE_R1 = TEAM_ONE_R1;
        this.TEAM_TWO_R1 = TEAM_TWO_R1;
        this.TEAM_ONE_R2 = TEAM_ONE_R2;
        this.TEAM_TWO_R2 = TEAM_TWO_R2;
        this.TEAM_ONE_R3 = TEAM_ONE_R3;
        this.TEAM_TWO_R3 = TEAM_TWO_R3;
        this.TEAM_ONE_R4 = TEAM_ONE_R4;
        this.TEAM_TWO_R4 = TEAM_TWO_R4;
        this.TEAM_ONE_R5 = TEAM_ONE_R5;
        this.TEAM_TWO_R5 = TEAM_TWO_R5;
        this.TEAM_ONE_T = TEAM_ONE_T;
        this.TEAM_TWO_T = TEAM_TWO_T;
    }

    public int getGId() {
        return id;
    }

    public void setGId(int id) {
        this.id = id;
    }

    public String getNAME_A() {
        return NAME_A;
    }

    public void setNAME_A(String NAME_A) {
        this.NAME_A = NAME_A;
    }

    public String getNAME_B() {
        return NAME_B;
    }

    public void setNAME_B(String NAME_B) {
        this.NAME_B = NAME_B;
    }

    public int getTEAM_ONE_R1() {
        return TEAM_ONE_R1;
    }

    public void setTEAM_ONE_R1(int TEAM_ONE_R1) {
        this.TEAM_ONE_R1 = TEAM_ONE_R1;
    }

    public int getTEAM_TWO_R1() {
        return TEAM_TWO_R1;
    }

    public void setTEAM_TWO_R1(int TEAM_TWO_R1) {
        this.TEAM_TWO_R1 = TEAM_TWO_R1;
    }

    public int getTEAM_ONE_R2() {
        return TEAM_ONE_R2;
    }

    public void setTEAM_ONE_R2(int TEAM_ONE_R2) {
        this.TEAM_ONE_R2 = TEAM_ONE_R2;
    }

    public int getTEAM_TWO_R2() {
        return TEAM_TWO_R2;
    }

    public void setTEAM_TWO_R2(int TEAM_TWO_R2) {
        this.TEAM_TWO_R2 = TEAM_TWO_R2;
    }

    public int getTEAM_ONE_R3() {
        return TEAM_ONE_R3;
    }

    public void setTEAM_ONE_R3(int TEAM_ONE_R3) {
        this.TEAM_ONE_R3 = TEAM_ONE_R3;
    }

    public int getTEAM_TWO_R3() {
        return TEAM_TWO_R3;
    }

    public void setTEAM_TWO_R3(int TEAM_TWO_R3) {
        this.TEAM_TWO_R3 = TEAM_TWO_R3;
    }

    public int getTEAM_ONE_R4() {
        return TEAM_ONE_R4;
    }

    public void setTEAM_ONE_R4(int TEAM_ONE_R4) {
        this.TEAM_ONE_R4 = TEAM_ONE_R4;
    }

    public int getTEAM_TWO_R4() {
        return TEAM_TWO_R4;
    }

    public void setTEAM_TWO_R4(int TEAM_TWO_R4) {
        this.TEAM_TWO_R4 = TEAM_TWO_R4;
    }

    public int getTEAM_ONE_R5() {
        return TEAM_ONE_R5;
    }

    public void setTEAM_ONE_R5(int TEAM_ONE_R5) {
        this.TEAM_ONE_R5 = TEAM_ONE_R5;
    }

    public int getTEAM_TWO_R5() {
        return TEAM_TWO_R5;
    }

    public void setTEAM_TWO_R5(int TEAM_TWO_R5) {
        this.TEAM_TWO_R5 = TEAM_TWO_R5;
    }

    public int getTEAM_ONE_T() {
        return TEAM_ONE_T;
    }

    public void setTEAM_ONE_T(int TEAM_ONE_T) {
        this.TEAM_ONE_T = TEAM_ONE_T;
    }

    public int getTEAM_TWO_T() {
        return TEAM_TWO_T;
    }

    public void setTEAM_TWO_T(int TEAM_TWO_T) {
        this.TEAM_TWO_T = TEAM_TWO_T;
    }
}


