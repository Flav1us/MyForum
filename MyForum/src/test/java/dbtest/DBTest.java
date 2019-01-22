package dbtest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.junit.Test;

import entity.ForumPost;
import entity.ForumThread;
import entity.ForumThreadAsBytes;
import storage.ForumThreadDAO;

public class DBTest {
	@Test
	public void test() {
		String text = "test post";
		ForumPost post = new ForumPost(text);
		ForumThread thread = new ForumThread();
		ForumThread thread_read = null;
		thread.addPost(post);
		byte[] bytes = null;
		try (	ByteArrayOutputStream baoo = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(baoo);
			) {
			oos.writeObject(thread);
			oos.flush();
			bytes = baoo.toByteArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert (bytes != null);
		ForumThreadDAO.save(new ForumThreadAsBytes(bytes));
		//byte[] nbytes = ForumThreadDAO.load();
	}
}
