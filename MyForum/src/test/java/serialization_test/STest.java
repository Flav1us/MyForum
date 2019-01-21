package serialization_test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.jupiter.api.Test;

import entity.ForumPost;
import entity.ForumThread;
import storage.Storage;


public class STest {

	@Test
	public void test_serialization() throws IOException {
		String text = "test post";
		ForumPost post = new ForumPost(text);
		ForumThread thread = new ForumThread();
		ForumThread thread_read = null;
		thread.addPost(post);
		try (	FileOutputStream fos = new FileOutputStream("src\\main\\resources\\temp.out");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
			) {
			oos.writeObject(thread);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//File f = new File("src\\main\\resources\\temp.out");
		//System.out.println(f.getCanonicalPath());

		try (	FileInputStream fis = new FileInputStream("src\\main\\resources\\temp.out");
				ObjectInputStream oos = new ObjectInputStream(fis);
			) {
			thread_read = (ForumThread) oos.readObject();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(thread_read);
		assertTrue(thread_read.getPosts().get(0).getText().equals(text));
	}

	@Test
	public void test_storage() {
		String text = "test post new";
		ForumPost post = new ForumPost(text);
		ForumThread thread = new ForumThread();
		ForumThread thread_read = null;
		thread.addPost(post);
		
		Storage.saveMainThread(thread);
		thread_read = Storage.loadMainThread();
		
		assertNotNull(thread_read);
		assertTrue(thread_read.getPosts().get(0).getText().equals(text));
	}

}
