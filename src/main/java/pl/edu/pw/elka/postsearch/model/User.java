package pl.edu.pw.elka.postsearch.model;

import java.net.URL;

/**
 * Bean zawierający informacje o użytkowniku.
 */
public class User {
    private String username;
    private String avatarURL;

    protected User() {/** empty by design */}

    public User(final String username, final String avatarURL) {
        this.username = username;
        this.avatarURL = avatarURL;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(final String avatarURL) {
        this.avatarURL = avatarURL;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (avatarURL != null ? !avatarURL.equals(user.avatarURL) : user.avatarURL != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (avatarURL != null ? avatarURL.hashCode() : 0);
        return result;
    }
}

