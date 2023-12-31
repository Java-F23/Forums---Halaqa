import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

class Post {
    private int postID;
    private String title;
    private String content;
    private User author;
    private Date timestamp;
    private int viewCount;
    private int likeCount;
    private Set<User> usersWhoLiked;

    private ArrayList<Comment> comments;
    private ArrayList<String> test;
    private static int nextPostID = 1;

    public Post(){

    }
    public Post(String title, String content, User author) {
        test = new ArrayList<String>();
        comments = new ArrayList<Comment>();
        this.postID = generateUniquePostID();
        this.title = title;
        this.content = content;
        this.author = author;
        this.timestamp = new Date(); // Use the current date and time
        this.usersWhoLiked = new HashSet<>();

    }

    public boolean hasUserLiked(User user) {
        return usersWhoLiked.contains(user);
    }

    public void incrementLikeCount(User user) {
        if (usersWhoLiked.contains(user)) {
            // If the user has already liked, then they're unliking
            likeCount--;
            usersWhoLiked.remove(user);
        } else {
            likeCount++;
            usersWhoLiked.add(user);
        }
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int id) {
        this.postID = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int count) {
        this.viewCount = count;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int count) {
        this.likeCount = count;
    }

    public void incrementViewCount(User user) {
        this.viewCount++;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        // Implement code to add a comment to the post
        comments.add(comment);
    }

    public ArrayList<String> getTest() { return test;}
    public void deleteComment(Comment comment) {
        Iterator<Comment> iterator = comments.iterator();
        while (iterator.hasNext()) {
            Comment c = iterator.next();
            if (c.equals(comment)) {
                iterator.remove();
            }
        }
    }



    private int generateUniquePostID() {
        int uniqueID = nextPostID;
        nextPostID++; // Increment for the next post
        return uniqueID;
    }

    @Override
    public String toString() {
        StringBuilder postString = new StringBuilder();
        postString.append("Post ID: ").append(postID).append("\n");
        postString.append("Title: ").append(title).append("\n");
        postString.append("Content: ").append(content).append("\n");
        postString.append("Author: ").append(author.getUsername()).append("\n");
        postString.append("Timestamp: ").append(timestamp).append("\n");
        postString.append("View Count: ").append(viewCount).append("\n");
        postString.append("Like Count: ").append(likeCount).append("\n");

        postString.append("Comments:").append("\n");
        for (Comment comment : comments) {
            postString.append(comment.toString()).append("\n");
        }

        return postString.toString();
    }

}