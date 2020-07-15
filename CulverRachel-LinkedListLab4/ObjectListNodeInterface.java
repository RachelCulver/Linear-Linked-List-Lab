/**
 * Contains the signatures of public methods from the ObjectListNode class.
 * 
 * @author Culver, Rachel 
 * @version 10/21/2017
 */
public interface ObjectListNodeInterface
{ 
    public void setInfo(Object o);
    public Object getInfo();
    public void setNext(ObjectListNode p);
    public ObjectListNode getNext();
}
