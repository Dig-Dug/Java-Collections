

package ocp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static org.junit.Assert.*;
import org.hamcrest.*;
import static org.junit.Assert.assertThat;
import org.junit.Test;
public class Tests {

	
	@Test
	public void test() {
		Users user = new Users();
		user.setUsername("tpage");
		user.setPassword("password");
		
		Users user2 = new Users();
		user2.setUsername("zpage");
		user2.setPassword("password!");
		
		List<Users> list = new ArrayList<Users>();
		list.add(user2);
		list.add(user);
		
		Collections.sort(list);
		assertThat(list.get(0).getUsername(), is ("tpage"));
		assertThat(list.get(1).getUsername(),is ("tpage"));
	}
	@Test
	public void test2() {
		String str1 = "tpage";
		String str2 = "Zpage";
		List<String> list = new ArrayList<String>();
		list.add(str2);
		list.add(str1);
		
		Collections.sort(list , new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return 0;
			}
		});
		assertThat(list.get(0), is ("tpage"));
		assertThat(list.get(1),is ("Zpage"));
	
	}

	private Matcher is(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
