package name_Application;

public class Nombre_Applicacion {

		public static void main(String[] args) {
			//create instance of "name" class name
			final Name name = new Name();
			name.setFirst(args[0]);
			name.setMiddle(args[1]);
			name.setLast(args[2]);
			name.setBirth(args[3]);
			name.setAlias(args[4]);
			
			System.out.println(name.toString());
			System.out.println(name.toString());
			System.out.println(name.toString());
		
		}
}
