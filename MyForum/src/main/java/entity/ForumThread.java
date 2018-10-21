package entity;

import java.util.ArrayList;
import java.util.List;

public class ForumThread {
	private List<ForumPost> posts = new ArrayList<>();
	public void addPost(ForumPost post) {
		posts.add(post);
	}
	public List<ForumPost> getPosts() {
		return posts;
	}
}
