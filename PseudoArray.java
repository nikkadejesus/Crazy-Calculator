import java.util.Scanner;

public class PseudoArray{
	public Linklist first;
	public Linklist last;
	public static int ctr = 0;
	Linklist list;
	Linklist temp = new Linklist();
	Linklist cur = new Linklist();
	String str = "";
	String string = "";
	int size;
	
	public PseudoArray(int size){
		this.size = size;
		first = null;
		last = null;
		for(int i = 0; i < size; i++){
			list = new Linklist();
			
			if(first == null){
				first = list;
			}else{
				last.next = list;
				list.previous = last;
			}
			last = list;		
		}
		cur = first;
	}
	
	public void add(String string){
		cur.setString(string);
		cur = cur.next;
	}
	
	public String remove(){
		temp = first;
		
		if(first.next == null){
			last = null;
		}else{
			first.next.previous = null;
		}
		
		first = first.next;
		
		return temp.getString();            
	}
	
	public String display(){
		String string = "";
		Linklist current = first;
		if(current == null){
			System.out.println("Empty");
		}
		//System.out.print("Array: ");
		while(current != null){
			str = current.getString();
			string += str;
			current = current.next;
		}
		System.out.println("");
		return string;
	}
}