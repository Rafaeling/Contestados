package com.example.root.contestados;

/**
 * Created by root on 9/05/15.
 */
public class Pregunta {
    private int id;

    private String text;

    private String resp1;

    private String resp2;

    private String resp3;

    private String resp4;

    private int genero;

    private int answer;

    public Pregunta( int i, String t, String r1, String r2,  String r3, String r4, int g, int a)
    {
        this.id = i;

        this.text = t;

        this.resp1 = r1;

        this.resp2 = r2;

        this.resp3 = r3;

        this.resp4 = r4;

        this.genero = g;

        this.answer = a;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return text;
    }

    public void setTexto(String te){
        this.text = te;
    }

    public String getResp1()
    {
        return resp1;
    }

    public void setResp1(String te){
        this.resp1 = te;
    }

    public String getResp2()
    {
        return resp2;
    }

    public void setResp2(String te){
        this.resp2 = te;
    }

    public String getResp3()
    {
        return resp3;
    }

    public void setResp3(String te){
        this.resp3 = te;
    }

    public String getResp4()
    {
        return resp4;
    }

    public void setResp4(String te){
        this.resp4 = te;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int ge) {
        this.genero= ge;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int a) {
        this.answer = a;
    }


}
