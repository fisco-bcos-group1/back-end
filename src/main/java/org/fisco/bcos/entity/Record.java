package org.fisco.bcos.entity;

/**
 * 依次包含授权人姓名、联系电话
 * 用于授权中的授权人信息
 * 准确的说应该是申请授权人信息
 */
public class Record {

    private String user;   // 被授权人地址
    private String author;   // 授权人/版权拥有人地址
    private String alltime;  // 所有时间，beg_time # end_time # modified
    private String music;   // bin # mname # singer # owner
    private String info;      // applicantName # phone # use # location # length # text # price

    public Record() {
    }

    public Record(String user, String author, String alltime, String music, String info) {
        this.user = user;
        this.author = author;
        this.alltime = alltime;
        this.music = music;
        this.info = info;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAlltime() {
        return alltime;
    }

    @Override
    public String toString() {
        return "Record{" +
                "user='" + user + '\'' +
                ", author='" + author + '\'' +
                ", alltime='" + alltime + '\'' +
                ", music='" + music + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    public void setAlltime(String alltime) {
        this.alltime = alltime;
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

}
