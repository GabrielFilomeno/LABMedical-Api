package com.example.LABMedical_API.dtos;

public class LoginResponse {

    private String token;
    private Long tempoExperiacao;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getTempoExperiacao() {
        return tempoExperiacao;
    }

    public void setTempoExperiacao(Long tempoExperiacao) {
        this.tempoExperiacao = tempoExperiacao;
    }

    public LoginResponse() {
    }

    public LoginResponse(String token, Long tempoExperiacao) {
        this.token = token;
        this.tempoExperiacao = tempoExperiacao;
    }
}
