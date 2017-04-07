public class Queue{

	int rear = 0;
	PseudoArray array;

	public Queue(int size){

		array = new PseudoArray(30);
	}

	public void enqueue(String string){
		array.add(string);
		rear++;
	}

	public String dequeue(){
		rear--;
		return array.remove();
	}

	public boolean empty(){
		if(rear == 0){
			return true;
		}else{
			return false;
		}
	}

	public String display(){
		return array.display();
	}
}
