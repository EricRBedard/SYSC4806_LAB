import static org.junit.Assert.*;

import com.myApp.model.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

public class BuddyInfoTest {
	private BuddyInfo buddy = null;

	@Before
	public void setUp() throws Exception {
		buddy = new BuddyInfo("name","address",123);
	}

	@Test
	public void testGetName() {
		assertEquals("getName should return the name","name",buddy.getName());
	}

	@Test
	public void testSetName() {
		buddy.setName("test");
		assertEquals("setName should change the name","test",buddy.getName());
	}

	@Test
	public void testGetAddress() {
		assertEquals("getAddress should return the address","address",buddy.getAddress());
	}

	@Test
	public void testSetAddress() {
		buddy.setAddress("test");
		assertEquals("setrAddress should change the address","test",buddy.getAddress());
	}

	@Test
	public void testGetPhoneNumber() {
		assertEquals("getNumber should return the phone number",123,buddy.getPhoneNumber());
	}

	@Test
	public void testSetPhoneNumber() {
		buddy.setPhoneNumber(987);
		assertEquals("setNumber should change the phone number",987,buddy.getPhoneNumber());
	}
	
	@Test
	public void testGetAge() {
		assertEquals("getAge should return the age",-1,buddy.getAge());
	}

	@Test
	public void testSetAge() {
		buddy.setAge(0);
		assertEquals("setAge should change the age",0,buddy.getAge());
	}

	@Test
	public void testToString() {
		assertEquals("toString should return a string containing the contents","Id: null Name: name Address: address Phone: 123",buddy.toString());
	}

	@Test
	public void testEqualsBuddyInfo() {
		BuddyInfo test = new BuddyInfo("name","address",123);
		assertTrue("equalsBuddyInfo shoud return true when given a buddy info with equal contents",buddy.equals(test));
		test.setName("different");
		assertFalse("equalsBuddyInfo shoud return false when given a buddy info with different contents",buddy.equals(test));
	}

//    @Test
//    public void performPersistence(){
//        BuddyInfo buddy1 = new BuddyInfo("Eric", "Ottawa", 123);
//        BuddyInfo buddy2 = new BuddyInfo("Sam", "Toronto", 456);
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        em.persist(buddy1);
//        em.persist(buddy2);
//        tx.commit();
//        Query q = em.createQuery("SELECT b FROM BuddyInfo b");
//        @SuppressWarnings("unchecked")
//        List<BuddyInfo> results = q.getResultList();
//        System.out.println("List of products\n----------------");
//        for (BuddyInfo b : results) {
//            System.out.println(b.getName() + " (id=" + b.getId() + ")");
//        }
//        em.close();
//        emf.close();
//    }

}
