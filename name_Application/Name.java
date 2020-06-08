package name_Application;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Name {
	//static fields--optional
	static private final String DEFAULT_FIRST_NAME = "Vorname";
	static private final String DEFAULT_LAST_NAME;
	//static initializer = class constructor
	static {
		DEFAULT_LAST_NAME = "Nachname";
	}
	//not static fields
	private String first;
	private String middle;
	private String last;
	private String birth;
	private String alias;
	//not static instance .constructor .Instance initializer
	/**
	 * init a new name using default values for first & last name & remaining instance fields
	 */
	public Name () {
		this(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME);	
	}
	//init a new name using given first & last name and(code null)for  remaining instance fields
	public Name (String first, String last) {
		if(first == null| first.isEmpty()|last == null|last.isEmpty()) throw new IllegalArgumentException();
		
		this.first = first;
		this.last = last;
	}
	//not static methods --instance methods
	public String getFirst() {
		return this.first;
	}
	//set method(first name)
	public void setFirst (String first) {
		if(first == null|first.isEmpty()) throw new IllegalArgumentException();
		this.first = first;
	}
	public String getLast () {
		return this.last;
	}
	public void setLast(String last) {
		if(last == null|last.isEmpty()) throw new IllegalArgumentException();
		this.last = last;
	}
	public String getBirth() {
		return this.birth;
	}
	public void setBirth(String birth) {
		if(birth != null && birth.isEmpty()) throw new IllegalArgumentException();
		this.birth = birth;
	}
	public String getAlias() {
		return this.alias;
	}
	public void setAlias(String alias) {
		if(alias != null && alias.isEmpty()) throw new IllegalArgumentException();
		this.alias = alias;
	}
	public String getMiddle() {
		return this.middle;
	}
	public void setMiddle(String middle) {
		if(middle != null && middle.isEmpty()) throw new IllegalArgumentException();
		this.middle = middle;
	}
	//converts this.name into a text representation
	public String toString() {
		return String.format("Name(first = %s, middle = %s, last = %s, birth = %s, alias = %s)", this.first, this.middle, this.last, birth, this.getAlias());
	}
	//converts this.name into json representation
	public String toJsonString() {
		final StringBuilder builder = new StringBuilder("{");
		builder
			.append("\n\tfirst: \"")
			.append(this.first)
			.append("\", \n\tlast: \"")
			.append(this.last)
			.append('"');
		
		builder.append(",\n\tmiddle; ");
		if (this.middle == null) {
			builder.append("null");
		} else {
			builder
			.append('"')
			.append(this.middle)
			.append('"');
		}
		builder.append(",\n\tbirth: ");
		if(this.birth == null) {
			builder.append("null");
		}else {
			builder
				.append('"')
				.append(this.birth)
				.append('"');
		}
		builder.append(",\n\talias: ");
		if(this.alias == null) {
			builder.append("null");
		}else {
			builder
				.append('"')
				.append(this.alias)
				.append('"');
			
		}
		builder.append("\n}");
		return builder.toString();
	}
	public String toXmlString() {
		final StringBuilder builder = new StringBuilder("<name");
		
		builder
			.append("\n\tfirst=\"")
			.append(this.first)
			.append("\"\n\tlast=\"")
			.append(this.last)
			.append('"');

		if (this.middle != null) {
			builder
				.append("\n\tmiddle=\"")
				.append(this.middle)
				.append('"');
		}

		if (this.birth != null) {
			builder
				.append("\n\tbirth=\"")
				.append(this.birth)
				.append('"');
		}

		if (this.alias != null) {
			builder
				.append("\n\talias=\"")
				.append(this.alias)
				.append('"');
		}

		builder.append("\n/>");
		return builder.toString();
	}
	//static methods converts JSON representation into a name
	//check this again!!!
	static public Name valueOfJson (final String json) {
		return Name.valueOfEncoding(json, "{","}",",",":");
	}
	static public Name valueOfXml (final String xml) {
		return Name.valueOfEncoding(xml, "<name ","/>", " ","=");
	}
	static private Name valueOfEncoding(final String text, final String startDelimiter, final String endDelimiter, final String associationDelimiter, final String associationKeyDelimiter) {
		if(!text.startsWith(startDelimiter)& !text.endsWith(endDelimiter))throw new IllegalArgumentException();
		
		final Name name = new Name();
		for(final String association : text.replace(startDelimiter, "").replace(endDelimiter, "").split(associationDelimiter)) {
			final int offset = association.indexOf(associationKeyDelimiter);
			if(offset == -1) throw new IllegalArgumentException();
			
			final String associationKey = association.substring(0, offset).trim();
			String associationValue = association.substring(offset + 1).replaceAll("[\\'\\\"]", "").trim();
			if(associationValue.equals("null")) associationValue = null;
			
			switch(associationKey) {
			case "first":
				name.setFirst(associationValue);
				break;
			case "last":
				name.setLast(associationValue);
				break;
			case "middle":
				name.setMiddle(associationValue);
				break;
			case "alias":
				name.setAlias(associationValue);
				break;
			case "birth":
				name.setBirth(associationValue);
				break;
				default:
					Logger.getGlobal().log(Level.INFO, String.format("Ignoring extra association: %s", associationKey));
					break;
					
			}
		}
		return name;
	}
}
	
