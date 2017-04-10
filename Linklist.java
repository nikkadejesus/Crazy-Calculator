public class Linklist{
	public String string = "";
	public Linklist next;
	public Linklist previous;

	public String getString(){
		return string;
	}

	public void setString(String str){
		string = str;
	}

	public void displayLink(){
		if(!string.equals("")){
			System.out.print(string);
		}
	}
}
