import java.sql.Date;

import java.util.List;

import controller.ownerHelper;
import model.Owner;

public class OwnerTester {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date date = Date.valueOf( "1993-07-05" );

		
		Owner spencer = new Owner("Spencer", date, 1);
		ownerHelper sh = new ownerHelper();
		sh.insertOwner(spencer);
		
		List<Owner> allOwners = sh.showAllOwners();
		for(Owner a: allOwners) {
		System.out.println(a.toString());
		}
	}

}
