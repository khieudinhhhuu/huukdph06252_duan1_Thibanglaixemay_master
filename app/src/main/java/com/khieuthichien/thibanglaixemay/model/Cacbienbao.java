package com.khieuthichien.thibanglaixemay.model;

public class Cacbienbao {

    private String anhcacbienbao;
    private String tieudecacbienbao;
    private String giaithichcacbienbao;

    public Cacbienbao(String anhcacbienbao, String tieudecacbienbao, String giaithichcacbienbao) {
        this.anhcacbienbao = anhcacbienbao;
        this.tieudecacbienbao = tieudecacbienbao;
        this.giaithichcacbienbao = giaithichcacbienbao;
    }

    public String getAnhcacbienbao() {
        return anhcacbienbao;
    }

    public void setAnhcacbienbao(String anhcacbienbao) {
        this.anhcacbienbao = anhcacbienbao;
    }

    public String getTieudecacbienbao() {
        return tieudecacbienbao;
    }

    public void setTieudecacbienbao(String tieudecacbienbao) {
        this.tieudecacbienbao = tieudecacbienbao;
    }

    public String getGiaithichcacbienbao() {
        return giaithichcacbienbao;
    }

    public void setGiaithichcacbienbao(String giaithichcacbienbao) {
        this.giaithichcacbienbao = giaithichcacbienbao;
    }
}
