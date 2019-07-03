package org.fisco.bcos.entity;

/**
 * 用于版权信息
 */
public class RecordInformation {
    private Music music;
    private User user;

    public RecordInformation(Music music, User user) {
        this.music = music;
        this.user = user;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RecordInformation() {
    }


}
