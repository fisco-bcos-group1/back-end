package org.fisco.bcos.entity;

/**
 * 包含音乐的所有属性
 */
public class Music {
    private String musicName;    //歌曲名称
    private String singer;       // 歌手
    private String owner;        // 版权所有者
    private String bin;          // 音乐二进制文件哈希
    private boolean isValid;     // 版权是否有效
    private String beg_time;     //版权有效开始时间
    private String end_time;     //版权有效结束时间
    private String platform;     //信息变更的节点名称
    private String modified;     //信息变更时间

    public Music() {
    }

    public Music(String musicName, String singer, String owner, String bin, boolean isValid, String beg_time, String end_time, String platform, String modified) {
        this.musicName = musicName;
        this.singer = singer;
        this.owner = owner;
        this.bin = bin;
        this.isValid = isValid;
        this.beg_time = beg_time;
        this.end_time = end_time;
        this.platform = platform;
        this.modified = modified;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
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

    public String getBeg_time() {
        return beg_time;
    }

    public void setBeg_time(String beg_time) {
        this.beg_time = beg_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }
}
