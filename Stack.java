public class Stack{
	String string;
	Queue queue;
	Queue temp;
	String str = "";
	int size = 0;

	public Stack(int size){
		this.size = size;
		queue = new Queue(size);
		temp = new Queue(size);
	}

	public void push(String string){
		queue.enqueue(string);
	}

	public String pop(){
		String string = "";

		while(!queue.empty()){
		string = queue.dequeue();
			if(queue.empty()){
				break;
			}else{
				temp.enqueue(string);
			}
		}

		while(!temp.empty()){
			queue.enqueue(temp.dequeue());
		}
		return string;
	}

	public String display(){
		return queue.display();
	}

	public boolean isEmpty(){
		if(queue.empty() == true)
			return true;
		else
			return false;
	}
}
