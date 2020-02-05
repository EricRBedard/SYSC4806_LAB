import static org.junit.Assert.*;

import java.util.List;

import com.myApp.model.AddressBook;
import com.myApp.model.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;

public class AddressBookTest {
	AddressBook book = null;
	AddressBook bookWithBuddy = null;
	BuddyInfo buddy = null;

	@Before
	public void setUp() throws Exception {
		book = new AddressBook();
		bookWithBuddy = new AddressBook();
		buddy = new BuddyInfo("name","address",123);
		bookWithBuddy.addBuddy(buddy);
	}
	
	@Test
	public void testsizeEmptyAddressBook() {
		assertEquals("Should return 0 when there are no items in the list",0,book.size());
	}

	@Test
	public void testAddBuddy() {
		bookWithBuddy.addBuddy(buddy);
		book.addBuddy(buddy);
		assertEquals("adding a buddy should increase the size of the addressBook",1,book.size());
		assertEquals("Nadding a buddy should increase the size of the addressBook",2,bookWithBuddy.size());
	}

	@Test
	public void testGetBuddyInfo() {
		BuddyInfo list = bookWithBuddy.getBuddyInfo().get(0);
		assertTrue("should return a list containing all the com.myApp.model.BuddyInfo",buddy.equals(list));
	}

	@Test
	public void testRemoveBuddy() {
		bookWithBuddy.removeBuddy(buddy);
		assertEquals("RemoveBuddy should remove the buddy from the list",0,book.size());
	}

	@Test
	public void testGetBuddy() {
		assertEquals("getBuddy should return the chosen buddy",buddy,bookWithBuddy.getBuddy(0));
	}

//	@Test
//	public void performPersistence(){
//		BuddyInfo buddy1 = new BuddyInfo("Eric", "Ottawa", 123, 1);
//		BuddyInfo buddy2 = new BuddyInfo("Sam", "Toronto", 456, 2);
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		em.persist(buddy1);
//		em.persist(buddy2);
//		tx.commit();
//		AddressBook address = new AddressBook();
//		address.setId(10);
//		address.addBuddy(buddy1);
//		address.addBuddy(buddy2);
//		tx.begin();
//		em.persist(address);
//		tx.commit();
//		Query q = em.createQuery("SELECT a FROM AddressBook a");
//		@SuppressWarnings("unchecked")
//		List<AddressBook> results = q.getResultList();
//		System.out.println("List of products\n----------------");
//		for (AddressBook a : results) {
//			System.out.println("Buddy1 :(" + a.getBuddyString(0) + ") and Buddy 2:(" + a.getBuddyString(1) + ") (com.myApp.model.AddressBook id=" + a.getId() + ")");
//		}
//		em.close();
//		emf.close();
//	}
}
