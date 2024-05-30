package fer_jdbc;

import java.util.List;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

import junit.framework.TestCase;

public class FERServiceImplTest extends TestCase {
	FERService ferService = new FERServiceImpl();

	public void testLogin() {
		// 1.Get the input
		String username = "Sanjay";
		String password = "rs";
		// 2.Call the service by passing the input
		boolean expected = true;
		boolean actual = ferService.login(username, password);
		// Assertion
		assertEquals(expected, actual);
	}

	public void testLoginInvalidUsername() {
		// 1.Get the input
		String username = "Sanjay1";
		String password = "rs";
		// 2.Call the service by passing the input
		boolean expected = false;
		boolean actual = ferService.login(username, password);
		// Assertion
		assertEquals(expected, actual);
	}

	public void testLoginInvalidPassword() {
		// 1.Get the input
		String username = "Sanjay";
		String password = "rs1";
		// 2.Call the service by passing the input
		boolean expected = false;
		boolean actual = ferService.login(username, password);
		// Assertion
		assertEquals(expected, actual);
	}

	public void testLoginBothInvalid() {
		// 1.Get the input
		String username = "Sanjay12";
		String password = "rs12";
		// 2.Call the service by passing the input
		boolean expected = false;
		boolean actual = ferService.login(username, password);
		// Assertion
		assertEquals(expected, actual);
	}

	public void testRegistration() {
		// 1.Get the input
		User user = new User();
		user.setFirstName("Sanjay");
		user.setMiddleName("kumar");
		user.setLastName("Vasireddy");
		user.setEmail("info@gmail.com");
		user.setUsername("sanjay");
		user.setPassword("rs");
		user.setMobile("9392414122");
		// 2.Call the service by passing the input
		boolean expected = true;
		boolean actual = ferService.registration(user);

		// Assertion
		assertEquals(expected, actual);
	}

	public void testRegistrationFailure() {
		// 1.Get the input
		User user = new User();
		// user.setFirstName("Sanjay");
		user.setMiddleName("kumar");
		user.setLastName("Vasireddy");
		user.setEmail("info@gmail.com");
		user.setUsername("sanjay");
		user.setPassword("rs");
		user.setMobile("9392414122");
		// 2.Call the service by passing the input
		boolean expected = false;
		boolean actual = ferService.registration(user);

		// Assertion
		assertEquals(expected, actual);
	}

	// Add Expense 2 test cases
	public void testAddExpense() {
		// 1.Get the input
		Expense expense = new Expense();
		expense.setType("coffee");
		expense.setDate("04-01-2024");
		expense.setPrice(15);
		expense.setNumberofitems(4);
		expense.setTotal(60);
		expense.setBywhom("me");
		expense.setUserid(1);

		// 2.Call the service by passing the input
		boolean expected = true;
		boolean actual = ferService.addExpense(expense);

		// Assertion
		assertEquals(expected, actual);
	}

	public void testAddExpenseFailure() {
		// 1.Get the input
		Expense expense = new Expense();
		// expense.setType("coffee");
		expense.setDate("04-01-2024");
		expense.setPrice(15);
		expense.setNumberofitems(4);
		expense.setTotal(60);
		expense.setBywhom("me");
		expense.setUserid(1);

		// 2.Call the service by passing the input
		boolean expected = false;
		boolean actual = ferService.addExpense(expense);

		// Assertion
		assertEquals(expected, actual);
	}
	// Edit expense 2 test cases

	public void testEditExpense() {
		// 1.Get the input
		Expense expense = new Expense();
		expense.setType("coffee");
		expense.setDate("04-01-2024");
		expense.setPrice(15);
		expense.setNumberofitems(4);
		expense.setTotal(60);
		expense.setBywhom("me");
		expense.setId(3);

		// 2.Call the service by passing the input
		boolean expected = true;
		boolean actual = ferService.editExpense(expense);

		// Assertion
		assertEquals(expected, actual);
	}

	public void testEditExpenseFailure() {
		// 1.Get the input
		Expense expense = new Expense();
		expense.setType("coffee");
		// expense.setDate("04-01-2024");
		expense.setPrice(15);
		expense.setNumberofitems(4);
		expense.setTotal(60);
		expense.setBywhom("me");
		expense.setId(3);

		// 2.Call the service by passing the input
		boolean expected = false;
		boolean actual = ferService.editExpense(expense);

		// Assertion
		assertEquals(expected, actual);
	}

	// Delete Expense two test cases

	public void testDeleteExpense() {
		// 1.Get the input
		int expenseid = 7;

		// 2.Call the service by passing the input
		boolean expected = true;
		boolean actual = ferService.deleteExpense(expenseid);

		// Assertion assertEquals(expected, actual);
	}

	public void testDeleteExpenseFailure() {
		// 1.Get the input
		int expenseid = 20;

		// 2.Call the service by passing the input
		boolean expected = false;
		boolean actual = ferService.deleteExpense(expenseid);

		// Assertion
		assertEquals(expected, actual);
	}

	public void testResetPassword() {
		// 1.Get the input

		String newPassword = "Sanjay";
		String currentPassword = "SANJAY";
		int id = 2;
		// 2.Call the service by passing the input
		boolean expected = true;
		boolean actual = ferService.resetPassword(newPassword, id, currentPassword);

		// Assertion
		assertEquals(expected, actual);
	}

	public void testResetPasswordFailure() {
		// 1.Get the input

		String newPassword = "Sanjay";
		String currentPassword = "SANJAY1";
		int id = 2;
		// 2.Call the service by passing the input
		boolean expected = false;
		boolean actual = ferService.resetPassword(newPassword, id, currentPassword);

		// Assertion
		assertEquals(expected, actual);
	}

	public void testUpdateProfile() {
		// 1.Get the input

		int userId = 1;

		User user = ferService.getUser(userId);

		// Name.Info
		user.setFirstName("SANJAY");
		user.setMiddleName("KUMAR");
		user.setLastName("VASIREDDY");

		// Contact Info
		user.setEmail("SANJAY@MAIL");
		user.setMobile("9392456355");

		// AddressInfo
		Address address = user.getAddress();
		address.setLine1("100FT ROAD");
		address.setLine2("MADHAPUR");
		address.setCity("HYDERABAD");
		address.setState("TG");
		address.setPinCode("89893");
		address.setCountry("IND");

		// 2.Call the service by passing the input
		boolean expected = true;
		boolean actual = ferService.updateUser(user);

		// Assertion
		assertEquals(expected, actual);
	}

	public void testUpdateProfileFailure() {
		// 1.Get the input

		int userId = 2;

		User user = ferService.getUser(userId);

		// Name.Info
		user.setFirstName("SANJAY");
		user.setMiddleName("KUMAR");
		user.setLastName("VASIREDDY");

		// Contact Info
		user.setEmail("SANJAY@MAIL");
		user.setMobile("9392456355");

		// AddressInfo
		Address address = user.getAddress();
		address.setLine1("100FT ROAD");
		address.setLine2("MADHAPUR");
		address.setCity("HYDERABAD");
		address.setState("TG");
		address.setPinCode("89893");
		address.setCountry("IND");

		// 2.Call the service by passing the input
		boolean expected = true;
		boolean actual = ferService.updateUser(user);

		// Assertion
		assertEquals(expected, actual);
	}

	// Get Expense test cases

	public void testGetExpense() {
		// 1.Get the input

		int expenseId = 1;

		// 2.Call the service by passing the input
		Expense expense = ferService.getExpense(expenseId);

		// assertion
		assertNotNull(expense);
	}

	public void testGetExpenseNotFound() {
		// 1.Get the input

		int expenseId = 420;

		// 2.Call the service by passing the input
		Expense expense = ferService.getExpense(expenseId);

		// assertion
		assertNull(expense);
	}

	// Get User test cases
	public void testGetUser() {
		// 1.Get the input

		int userId = 1;

		// 2.Call the service by passing the input
		User user = ferService.getUser(userId);

		// assertion
		assertNotNull(user);
	}

	public void testGetUsernotfound() {
		// 1.Get the input

		int userId = 50;

		// 2.Call the service by passing the input
		User user = ferService.getUser(userId);

		// assertion
		assertNull(user);
	}
	// GetExpenseOptions test cases

	public void testGetExpenseOptions() {

		// 1.Get the input

		int userId = 1;

		// 2.Call the service by passing the input
		List<Expense> expenses = ferService.getExpenseOptions(userId);

		// Assertion

		boolean expectedIsEmpty = false;
		boolean actualIsEmpty = expenses.isEmpty();
		assertEquals(expectedIsEmpty, actualIsEmpty);
	}

	public void testGetExpenseOptionsNotFound() {

		// 1.Get the input

		int userId = 50;

		// 2.Call the service by passing the input
		List<Expense> expenses = ferService.getExpenseOptions(userId);

		// Assertion

		boolean expectedIsEmpty = true;
		boolean actualIsEmpty = expenses.isEmpty();
		assertEquals(expectedIsEmpty, actualIsEmpty);
	}

	// Expense Report test cases

	public void testExpenseReport() {
		// 1.Get the input

		int userId = 1;
		String expenseType = "Tea";
		String fromDate = "02-01-2024";
		String toDate = "05-01-2024";

		// 2.Call the service by passing the input
		List<Expense> expenses = ferService.getExpenseReport(userId, expenseType, fromDate, toDate);

		// assertion

		boolean expectedIsEmpty = false;
		boolean actualIsEmpty = expenses.isEmpty();
		assertEquals(expectedIsEmpty, actualIsEmpty);
	}

	public void testExpenseReportNotFound() {
		// 1.Get the input

		int userId = 60;
		String expenseType = "Tea";
		String fromDate = "02-01-2024";
		String toDate = "05-01-2024";

		// 2.Call the service by passing the input
		List<Expense> expenses = ferService.getExpenseReport(userId, expenseType, fromDate, toDate);

		// assertion

		boolean expectedIsEmpty = true;
		boolean actualIsEmpty = expenses.isEmpty();
		assertEquals(expectedIsEmpty, actualIsEmpty);
	}

}
