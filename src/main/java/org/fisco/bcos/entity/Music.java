package org.fisco.bcos.entity;

/**
 * 包含音乐的所有属性
 */
public class Music {
    private String mName;    //歌曲名称
    private String singer;       // 歌手
    private String owner;        // 版权所有者
    private String bin;          // 音乐二进制文件哈希
    private boolean isValid;     // 版权是否有效
    private String alltime;     //所有时间，beg_time # end_time # modified


    public Music(String mName, String singer, String owner, String bin, boolean isValid, String alltime) {
        this.mName = mName;
        this.singer = singer;
        this.owner = owner;
        this.bin = bin;
        this.isValid = isValid;
        this.alltime = alltime;
    }

    @Override
    public String toString() {
        return "Music{" +
                "mName='" + mName + '\'' +
                ", singer='" + singer + '\'' +
                ", owner='" + owner + '\'' +
                ", bin='" + bin + '\'' +
                ", isValid=" + isValid +
                ", alltime='" + alltime + '\'' +
                '}';
    }

    public Music() {
    }


    public String getAlltime() {
        return alltime;
    }

    public void setAlltime(String alltime) {
        this.alltime = alltime;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

}
