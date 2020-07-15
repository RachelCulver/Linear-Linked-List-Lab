
/**
 * Creates and maintains nodes.
 * 
 *@auther Stegman, Richard
 */

public class ObjectListNode implements ObjectListNodeInterface {
    private Object info;
    private ObjectListNode next;
    
    /**
     * Default ctor
     */
    public ObjectListNode() {
        info = null;
        next = null;
    }

    /**
     * One-arg ctor
     * 
     * @param o - Object to be set in info field of node 
     */
    public ObjectListNode (Object o) {
        info = o;
        next = null;
    }    

    /**
     * Two-arg ctor
     * 
     * @param o - Object to be set in info field of node
     * @param p - ObjectListNode to be set to next node
     */
    public ObjectListNode (Object o, ObjectListNode p) {
        info = o;
        next = p;
    }       

    /**
     * Sets info field
     * 
     * @param o - Object to be set to info field
     */
    public void setInfo(Object o) {
        info = o;
    }    

    /**
     * Returns objects in info field
     * 
     * @returns object in info field
     */
    public Object getInfo() {
        return info;
    }

    /**
     * Sets next field
     * 
     * @param p - ObjectListNode to be set to next field
     */
    public void setNext(ObjectListNode p) {
        next = p;
    }

    /**
     * Returns object in info field
     * 
     * @returns the object in info field
     */
    public ObjectListNode getNext() {
        return next;
    }
} 




