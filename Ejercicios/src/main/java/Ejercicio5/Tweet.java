package Ejercicio5;

import java.time.LocalDateTime;

public class Tweet {
    protected String message;
    protected UserAccount author;
    protected LocalDateTime time;

    // Constructor
    public Tweet(String message, UserAccount author, LocalDateTime time) {
        if (message.length() > 140) {
            throw new IllegalArgumentException("El mensaje no puede tener más de 140 caracteres");
        }
        this.message = message;
        this.author = author;
        this.time = time;
    }

    // Getters
    public String getMessage() {
        return message;
    }

    public UserAccount getAuthor() {
        return author;
    }

    public LocalDateTime getTime() {
        return time;
    }

    // Setters
    public void setMessage(String message) {
        if (message.length() > 140) {
            throw new IllegalArgumentException("El mensaje no puede tener más de 140 caracteres");
        }
        this.message = message;
    }

    public void setAuthor(UserAccount author) {
        this.author = author;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    // Methods

    @Override
    public String toString() {
        return "Tweet{" +
                "message='" + message + '\'' +
                ", author=" + author +
                ", time=" + time +
                '}';
    }

    public class DirectMessage extends Tweet {
        private UserAccount recividor;

        public DirectMessage(String message, UserAccount author, LocalDateTime time, UserAccount recividor) {
            super(message, author, time);
            this.recividor = recividor;
        }

        @Override
        public String toString() {
            return "DirectMessage{" +
                    "message='" + message + '\'' +
                    ", author=" + author +
                    ", time=" + time +
                    ", recividor=" + recividor +
                    '}';
        }
    }

    public class Retweet extends Tweet {
        private Tweet originalTweet;

        public Retweet(String message, UserAccount author, LocalDateTime time, Tweet originalTweet) {
            super(message, author, time);
            this.originalTweet = originalTweet;
        }

        @Override
        public String toString() {
            return "Retweet{" +
                    "message='" + message + '\'' +
                    ", author=" + author +
                    ", time=" + time +
                    ", originalTweet=" + originalTweet +
                    '}';
        }
    }
}
