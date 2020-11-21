package ar.edu.grupoi.backend.desappbackend.dto;

import java.util.List;

public class DtoAdmin {

    private Integer id;
    private String name;
    private String mail;
    private String password;
    private String nickname;
    private Integer points;
    private List<DtoDonation> dtoDonations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void setDtoDonations(List<DtoDonation> dtoDonations) {
        this.dtoDonations = dtoDonations;
    }

    public List<DtoDonation> getDtoDonations() {
        return dtoDonations;
    }
}
