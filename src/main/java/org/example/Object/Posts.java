package org.example.Object;

import jakarta.persistence.*;

import javax.xml.namespace.QName;
import java.time.LocalDate;

@Entity
@Table
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;

    private String caption;

    private String mediaURL;

    private String createAt;

    public Posts(int postId, String caption, String mediaURL, String createAt) {
        this.postId = postId;
        this.caption = caption;
        this.mediaURL = mediaURL;
        this.createAt = createAt;
    }

    public Posts() {

    }

    public int getPostId() {
        return postId;
    }

    public String getCaption() {
        return caption;
    }

    public String getMediaURL() {
        return mediaURL;
    }

    public String getCreateAt() {
        return createAt;
    }

    public Users getUser() {
        return user;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setMediaURL(String mediaURL) {
        this.mediaURL = mediaURL;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void printPost() {
        System.out.printf("%-20d %-20s %-20s %-20s\n", postId, caption, mediaURL, createAt);
    }

}
