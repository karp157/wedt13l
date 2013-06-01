package pl.edu.pw.elka.postsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * Bean przechowujący informacje posta (wiadomości).
 */
@Document(indexName = "twitter", type = "post")
public class Post {
    /** Id wiadomości. */
    @Id
    private Long id;
    /** Data utworzenia wiadomości w serwisie twitter. */
    private Date creationDate;
    /** Autor wiadomości */
    private User user;
    /** Treść wiadomości. */
    private String message;
//    private String followers; TODO dodać kiedy będzie to istotne
    /** Kod kraju pochodzenia wiadomości. */
    private String countryCode;

    protected Post() {/** Empty by design */}

    public Post(final Date creationDate, final Long id, final User user, final String message, final String countryCode) {
        this.creationDate = creationDate;
        this.id = id;
        this.user = user;
        this.message = message;
        this.countryCode = countryCode;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(final Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (countryCode != null ? !countryCode.equals(post.countryCode) : post.countryCode != null) return false;
        if (creationDate != null ? !creationDate.equals(post.creationDate) : post.creationDate != null) return false;
        if (id != null ? !id.equals(post.id) : post.id != null) return false;
        if (message != null ? !message.equals(post.message) : post.message != null) return false;
        if (user != null ? !user.equals(post.user) : post.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = creationDate != null ? creationDate.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Post{" +
                "creationDate=" + creationDate +
                ", id=" + id +
                ", user=" + user +
                ", message='" + message + '\'' +
                ", countryCode='" + countryCode + '\'' +
                "} " + super.toString();
    }
}
