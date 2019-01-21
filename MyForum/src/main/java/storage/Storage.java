package storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import entity.ForumThread;

public class Storage {
	private static String savefile_path = "C:\\main\\prog\\Git\\MyForum\\MyForum\\src\\main\\resources\\temp.out"; 
	
	public static void saveMainThread(ForumThread thread) {
		try (	FileOutputStream fos = new FileOutputStream(new File(savefile_path));
				ObjectOutputStream oos = new ObjectOutputStream(fos);
			) {
			oos.writeObject(thread);
		} catch (IOException e) {
			System.err.println("Error occured while SAVING forum thread");
			e.printStackTrace();
		}
	}
	
	public static ForumThread loadMainThread() {
		ForumThread thread_read = null;
		try (	FileInputStream fis = new FileInputStream(savefile_path);
				ObjectInputStream oos = new ObjectInputStream(fis);
			) {
			thread_read = (ForumThread) oos.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Error occured while LOADING forum thread");
			e.printStackTrace();
		}
		return thread_read;
	}

}
