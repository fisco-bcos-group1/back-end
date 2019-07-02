package org.fisco.bcos.entity;

/**
 * 仅包含作品名称、作者、版权人
 */
public class MusicInformation {
    private String musicNmae;
    private String singer;
    private String owner;

    public MusicInformation(String musicNmae,String singer,String owner){
        this.musicNmae =musicNmae;
        this.singer = singer;
        this.owner =owner;
    }

    public String getMusicNmae(){
        return musicNmae;
    }

    public String getSinger(){
        return singer;
    }

    public String getOwner(){
        return owner;
    }
}
