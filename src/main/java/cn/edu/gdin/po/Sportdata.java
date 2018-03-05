package cn.edu.gdin.po;

import java.util.Date;

public class Sportdata {
    private Integer id;

    private String userAccount;

    private Date collectionTime;

    private Integer step;

    private Integer kilometers;

    private Short lightSleep;

    private Short deepSleep;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public Date getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Date collectionTime) {
        this.collectionTime = collectionTime;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }

    public Short getLightSleep() {
        return lightSleep;
    }

    public void setLightSleep(Short lightSleep) {
        this.lightSleep = lightSleep;
    }

    public Short getDeepSleep() {
        return deepSleep;
    }

    public void setDeepSleep(Short deepSleep) {
        this.deepSleep = deepSleep;
    }
}