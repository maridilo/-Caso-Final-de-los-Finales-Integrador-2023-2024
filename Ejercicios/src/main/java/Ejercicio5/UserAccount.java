package Ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class UserAccount {
    private String alias;
    private String email;
    private List<Tweet> tweets;
    private List<Tweet> timeline;
    private List<UserAccount> followers;
    private List<UserAccount> following;

    // Constructor
    public UserAccount(String alias, String email) {
        if (!Utils.isValidAlias(alias)) {
            throw new IllegalArgumentException("El alias no es válido");
        }
        if (!Utils.isValidEmail(email)) {
            throw new IllegalArgumentException("El email no es válido");
        }
        this.alias = alias;
        this.email = email;
        this.tweets = new ArrayList<>();
        this.timeline = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
    }

    // Getters
    public String getAlias() {
        return alias;
    }

    public String getEmail() {
        return email;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public List<Tweet> getTimeline() {
        return timeline;
    }

    public List<UserAccount> getFollowers() {
        return followers;
    }

    public List<UserAccount> getFollowing() {
        return following;
    }

    // Setters
    public void addFollower(UserAccount follower) {
        if (!followers.contains(follower)) {
            followers.add(follower);
            follower.addFollowing(this);
        }
    }

public void addFollowing(UserAccount following) {
        if (!this.following.contains(following)) {
            this.following.add(following);
            following.addFollower(this);
        }
    }

    private void removeFollower(UserAccount follower) {
        if (followers.contains(follower)) {
            followers.remove(follower);
            follower.removeFollowing(this);
        }
    }

    private void removeFollowing(UserAccount following) {
        if (this.following.contains(following)) {
            this.following.remove(following);
            following.removeFollower(this);
        }
    }

    public void follow(UserAccount user) {
        if (user == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
        if (this == user) {
            throw new IllegalArgumentException("No puedes seguirte a ti mismo");
        }
        if (following.contains(user)) {
            throw new IllegalArgumentException("Ya sigues a " + user.alias);
        }
        following.add(user);
        user.followers.add(this);
    }

    public void tweet(Tweet tweet) {
        if (tweet == null) {
            throw new IllegalArgumentException("El tweet no puede ser nulo");
        }
        tweets.add(tweet);
        for (UserAccount follower : followers) {
            follower.timeline.add(tweet);
        }
    }


    @Override
    public String toString() {
        return "Ejercicio5.Ejercicio5.UserAccount{" +
                "alias='" + alias + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
