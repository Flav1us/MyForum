package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ForumThread implements Serializable {
	private static final long serialVersionUID = 7849517898704798222L;
	
	private List<ForumPost> posts = new ArrayList<>();
	public void addPost(ForumPost post) {
		posts.add(post);
	}
	public List<ForumPost> getPosts() {
		return posts;
	}
}
