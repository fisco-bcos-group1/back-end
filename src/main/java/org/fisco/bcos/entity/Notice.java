package org.fisco.bcos.entity;

/**
 * 交易的所有属性
 */
public class Notice {

    private String start;  // 通知发起方
    private String to;    // 接收方
    private String music;  // mname # singer # recordTime # applyTime
    private String info;  // applicantName # phone # use # location # length # text # price
    private boolean valid;     // 是否授权


    public Notice() {
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Notice(String from, String to, String music, String info, boolean valid) {
        this.start = from;
        this.to = to;
        this.music = music;
        this.info = info;
        this.valid = valid;
    }




}
