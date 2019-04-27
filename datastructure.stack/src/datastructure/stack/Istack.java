package datastructure.stack;

public class Istack {
 static SNode tail;	
 /**
  * removes the element at the top of the stack and returns that element.
  * @return top of stack element ,or through exception if empty
  */
 
	public object pop() {
   SNode temp=tail;
   tail=tail.previous;
  temp.setprevious(null);
   return temp.getobject();
   
}
	/**
	 * get the element at the top of the stack without removing it from the stack
	 * @return top of stack element, or through exception if empty
	 */
public object peek() {
    return tail.getobject();    		
	}
/**
 * pushes an item onto the top of the stack.
 * @param element
 *            to insert
 */
public void push(object element) {
	SNode new_node=new SNode(element);
	if(tail==null)
	{ 
		tail=new_node;
		tail.setprevious(null);
		tail.getobject().setsize(1);
	}
	else{new_node.setprevious(tail);
	tail=new_node;
	tail.getobject().setsize(tail.previous.getobject().getsize()+1);}
}
/**
 * Tests if this stack is empty
 * @return true if stack is empty
 */
public boolean isEmpty() {
if(tail==null)
  {
	return true;
  }
else
  {
	return false;
  }	
}
/**
 * Returns the number of elements in the stack
 * @return number of elements in the stack
 */
public int size() {
	return tail.getobject().getsize();
}

}
