package com.wangsd.web.pojo;

/**
 * 报事报修
 */
public class Report {

    private String idAndName;
    private Integer housingId;
    private String housingName;
    private String username;
    private String phone;
    private String address;
    private String content;

    public String getIdAndName() {
        return idAndName;
    }

    public void setIdAndName(String idAndName) {
        this.idAndName = idAndName;
        String[] temp = idAndName.split("|");
        this.housingId = Integer.parseInt(temp[0]);
        this.housingName = temp[1];
    }

    public String getHousingName() {
        return housingName;
    }

    public void setHousingName(String housingName) {
        this.housingName = housingName;
    }

    public Integer getHousingId() {
        return housingId;
    }

    public void setHousingId(Integer housingId) {
        this.housingId = housingId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Report{" +
                "housingId=" + housingId +
                ", housingName='" + housingName + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
